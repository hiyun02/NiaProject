package kopo.poly.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kopo.poly.dto.AreaDTO;
import kopo.poly.dto.CityDTO;
import kopo.poly.dto.ReportDTO;
import kopo.poly.dto.RowCityDTO;
import kopo.poly.repository.ReportRepository;
import kopo.poly.repository.entity.ReportEntity;
import kopo.poly.service.IApiService;
import kopo.poly.service.IAreaService;
import kopo.poly.service.IFileUploadService;
import kopo.poly.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiService implements IApiService {

    private final RestTemplate restTemplate;
    private final IFileUploadService fileUploadService;
    private final IAreaService areaService;
    private final ReportRepository repository;
    @Value("${api.key}")
    private String apiKey;

    /* 인구밀집 업로드 */
    @Override
    public int insertReport(ReportDTO reportDTO, MultipartFile mf, String saveFileName) throws Exception {
        log.info(this.getClass().getName() + "인구밀집 업로드 시작!");

        int res = 0;
        ReportEntity entity = ReportEntity.builder().belong(reportDTO.getBelong()).name(reportDTO.getName())
                .location(reportDTO.getLocation()).phone(reportDTO.getPhone()).density(reportDTO.getDensity())
                .filePath(fileUploadService.fileUpload(mf, saveFileName)).reportDT(DateUtil.getDateTime("yyyy-MM-dd hh:mm")).build();

        repository.save(entity);
        res = 1;

        log.info(this.getClass().getName() + "인구밀집 업로드 종료!");
        return res;
    }

    @Override
    public String getHourReportList(String title) throws Exception {
        log.info(this.getClass().getName() + " 1시간 과거부터 현재까지 가져오기");

        log.info("현재 시간 : " + DateUtil.getDateTime("yyyy-MM-dd hh:mm") + " / " + "한시간 전 : " + DateUtil.getDateTimeHour("yyyy-MM-dd hh:mm"));

        String startTime = DateUtil.getDateTimeHour("yyyy-MM-dd hh:mm");
        String end = DateUtil.getDateTime("yyyy-MM-dd hh:mm");

        String maxReport = repository.getReportMax(title, startTime, end);

        log.info(maxReport);

        return maxReport;
    }

    @Override
    public List<ReportDTO> getReportList(String locationName) throws Exception {
        log.info(this.getClass().getName() + "인구밀집 리스트 가져오기 시작!");

        return new ObjectMapper().convertValue(repository.findAllByLocationOrderByReportDT(locationName), new TypeReference<List<ReportDTO>>() {
        });
    }

    @Override
    public CityDTO getSeoulData(String city) throws Exception {
        log.info(this.getClass().getName() + "실시간 인구 밀집도 가져오기 시작!");

        CityDTO cityDTO = new CityDTO();
        StringBuilder url = new StringBuilder();
        log.info(city);

//        url.append("http://openapi.seoul.go.kr:8088/").append(apiKey)
//                .append("/json").append("/citydata_ppltn")
//                .append("/1/5/").append(city);
        url.append("http://223.130.129.189:9191/").append("/citydata_ppltn")
                .append("/1/5/").append(city);

        restTemplate.getInterceptors().add((request, body, execution) -> {
            ClientHttpResponse response = execution.execute(request, body);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return response;
        });

//        ResponseEntity<String> response = restTemplate.exchange(url.toString(), HttpMethod.GET, null, String.class);
//
//        log.info(response.getBody());
//
//        JSONParser jsonParser = new JSONParser();
//        JSONObject jsonObject = (JSONObject) jsonParser.parse(response.getBody());
//        JSONArray jsonArray = (JSONArray) jsonObject.get("SeoulRtd.citydata_ppltn");

        String response = restTemplate.getForObject(url.toString(), String.class);

        // 호출 결과가 XML이기 때문에 Simple Json 라이브러리로 JSON으로 변환
        JSONObject responseJson = XML.toJSONObject(response);
        JSONObject map = (JSONObject) responseJson.get("Map");
        log.info(map.toString());

        if (map.has("SeoulRtd.citydata_ppltn")) {
            JSONObject json = (JSONObject) map.get("SeoulRtd.citydata_ppltn");

            cityDTO.setAREA_CD(String.valueOf(json.get("AREA_CD")));
            cityDTO.setAREA_NM(String.valueOf(json.get("AREA_NM")));
            cityDTO.setAREA_CONGEST_LVL(String.valueOf(json.get("AREA_CONGEST_LVL")));
            cityDTO.setAREA_CONGEST_MSG(String.valueOf(json.get("AREA_CONGEST_MSG")));
            cityDTO.setAREA_PPLTN_MIN(String.valueOf(json.get("AREA_PPLTN_MIN")));
            cityDTO.setAREA_PPLTN_MAX(String.valueOf(json.get("AREA_PPLTN_MAX")));
            cityDTO.setFEMALE_PPLTN_RATE(String.valueOf(json.get("FEMALE_PPLTN_RATE")));
            cityDTO.setPPLTN_RATE_0(String.valueOf(json.get("PPLTN_RATE_0")));
            cityDTO.setPPLTN_RATE_10(String.valueOf(json.get("PPLTN_RATE_10")));
            cityDTO.setPPLTN_RATE_20(String.valueOf(json.get("PPLTN_RATE_20")));
            cityDTO.setPPLTN_RATE_30(String.valueOf(json.get("PPLTN_RATE_30")));
            cityDTO.setPPLTN_RATE_40(String.valueOf(json.get("PPLTN_RATE_40")));
            cityDTO.setPPLTN_RATE_50(String.valueOf(json.get("PPLTN_RATE_50")));
            cityDTO.setPPLTN_RATE_60(String.valueOf(json.get("PPLTN_RATE_60")));
            cityDTO.setPPLTN_RATE_70(String.valueOf(json.get("PPLTN_RATE_70")));
            cityDTO.setRESNT_PPLTN_RATE(String.valueOf(json.get("RESNT_PPLTN_RATE")));
            cityDTO.setNON_RESNT_PPLTN_RATE(String.valueOf(json.get("NON_RESNT_PPLTN_RATE")));
            cityDTO.setREPLACE_YN(String.valueOf(json.get("REPLACE_YN")));
            cityDTO.setPPLTN_TIME(String.valueOf(json.get("PPLTN_TIME")));
            if (json.get("FCST_YN").equals("Y")) {
                JSONObject object = (JSONObject) json.get("FCST_PPLTN");
                cityDTO.setFCST_YN(String.valueOf(json.get("FCST_YN")));

                JSONArray arr = (JSONArray) object.get("FCST_PPLTN");

                List<RowCityDTO> rowCityDTOList = new ArrayList<>();

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject item = (JSONObject) arr.get(i);
                    RowCityDTO rowCityDTO = new RowCityDTO();
                    rowCityDTO.setFcst_congest_lvl(String.valueOf(item.get("FCST_CONGEST_LVL")));
                    rowCityDTO.setFcst_ppltn_min(String.valueOf(item.get("FCST_PPLTN_MIN")));
                    rowCityDTO.setFcst_ppltn_max(String.valueOf(item.get("FCST_PPLTN_MAX")));
                    rowCityDTO.setFcst_time(String.valueOf(item.get("FCST_TIME")));
                    rowCityDTOList.add(rowCityDTO);
                }

                cityDTO.setFCST_PPLTN(rowCityDTOList);
//                list = null;
            }
            cityDTO.setMALE_PPLTN_RATE(String.valueOf(json.get("MALE_PPLTN_RATE")));

        }else {
            return new CityDTO();
        }


//        if (jsonArray == null) {
//            jsonArray = new JSONArray();
//            return new CityDTO();
//        }else{
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject json = (JSONObject) jsonArray.get(i);
//                cityDTO.setAREA_CD(String.valueOf(json.get("AREA_CD")));
//                cityDTO.setAREA_NM(String.valueOf(json.get("AREA_NM")));
//                cityDTO.setAREA_CONGEST_LVL(String.valueOf(json.get("AREA_CONGEST_LVL")));
//                cityDTO.setAREA_CONGEST_MSG(String.valueOf(json.get("AREA_CONGEST_MSG")));
//                cityDTO.setAREA_PPLTN_MIN(String.valueOf(json.get("AREA_PPLTN_MIN")));
//                cityDTO.setAREA_PPLTN_MAX(String.valueOf(json.get("AREA_PPLTN_MAX")));
//                cityDTO.setFEMALE_PPLTN_RATE(String.valueOf(json.get("FEMALE_PPLTN_RATE")));
//                cityDTO.setPPLTN_RATE_0(String.valueOf(json.get("PPLTN_RATE_0")));
//                cityDTO.setPPLTN_RATE_10(String.valueOf(json.get("PPLTN_RATE_10")));
//                cityDTO.setPPLTN_RATE_20(String.valueOf(json.get("PPLTN_RATE_20")));
//                cityDTO.setPPLTN_RATE_30(String.valueOf(json.get("PPLTN_RATE_30")));
//                cityDTO.setPPLTN_RATE_40(String.valueOf(json.get("PPLTN_RATE_40")));
//                cityDTO.setPPLTN_RATE_50(String.valueOf(json.get("PPLTN_RATE_50")));
//                cityDTO.setPPLTN_RATE_60(String.valueOf(json.get("PPLTN_RATE_60")));
//                cityDTO.setPPLTN_RATE_70(String.valueOf(json.get("PPLTN_RATE_70")));
//                cityDTO.setRESNT_PPLTN_RATE(String.valueOf(json.get("RESNT_PPLTN_RATE")));
//                cityDTO.setNON_RESNT_PPLTN_RATE(String.valueOf(json.get("NON_RESNT_PPLTN_RATE")));
//                cityDTO.setREPLACE_YN(String.valueOf(json.get("REPLACE_YN")));
//                cityDTO.setPPLTN_TIME(String.valueOf(json.get("PPLTN_TIME")));
//                cityDTO.setFCST_YN(String.valueOf(json.get("FCST_YN")));
//                cityDTO.setFCST_PPLTN((List<RowCityDTO>) json.get("FCST_PPLTN"));
//                cityDTO.setMALE_PPLTN_RATE(String.valueOf(json.get("MALE_PPLTN_RATE")));
//            }
//        }

        return cityDTO;
    }


    @Cacheable(cacheNames = "seoulCityData")
    @Scheduled(cron = "0 0 * * * *", zone = "Asia/Seoul")
    @Override
    public List<CityDTO> allSeoulData() throws Exception {
        log.info(this.getClass().getName() + "인구 데이터 전체 가져오기");

        List<AreaDTO> areaDTOList = areaService.getAresList();
        List<CityDTO> result = new ArrayList<>();

        for (AreaDTO areaDTO : areaDTOList) {
            CityDTO cityDTO = getSeoulData(areaDTO.getLocation());

            cityDTO.setLat(areaDTO.getLat());
            cityDTO.setLng(areaDTO.getLng());
            cityDTO.setLocation(areaDTO.getLocation());

            result.add(cityDTO);

        }

        log.info(this.getClass().getName() + "인구 데이터 전체 가져오기");
        return result;
    }

}
