package kopo.poly.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import kopo.poly.service.IApiService;
import kopo.poly.util.LocateUtil;
import kopo.poly.util.UrlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service("ApiService")
public class ApiService implements IApiService {

    private final String fireForestForcastSigunguEndpoint = "http://223.130.129.189:9191/getForestPointListSigunguSearch/";
    private final String fireForestStaticsEndpoint = "http://apis.data.go.kr/1400000/forestStusService/getfirestatsservice?ServiceKey=QsNI5r9fd5VjOIgitMwAbEic3pyzcsW0zwEqf0z94%2F6jR9Yg3HgYcEMAo5DCAIY1mUCbDpHQzKPjXJP9QzXymA%3D%3D";

    @Override
    public List<Map<String, String>> fireForestForcast(String address) throws Exception {

        log.info(this.getClass().getName() + ".checkEmergency Start!!");
        log.info("address : " + address);

        String regionCode = LocateUtil.getSigunguCode(address);
        log.info("regionCode : " + regionCode);

        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(fireForestForcastSigunguEndpoint);
        urlBuilder.append("localAreas=");
        urlBuilder.append(regionCode);
        urlBuilder.append("&_type=json");
        urlBuilder.append("&excludeForecast=0");
        String url = urlBuilder.toString();
        log.info("request url : " + url);

        UrlUtil uu = new UrlUtil();
        String json = uu.urlReadforString(url);
        log.info("response : " + json);

        List<Map<String, String>> rList;
        if(!(json.charAt(0)+"").equals("<")) {
        Map<String, Object> rMap = new ObjectMapper().readValue(json, LinkedHashMap.class);
        Map<String, Object> responseMap = (Map<String, Object>) rMap.get("response");
        Map<String, Object> bodyMap = (Map<String, Object>) responseMap.get("body");
        Map<String, Object> itemsMap = (Map<String, Object>) bodyMap.get("items");
        List<Map<String, Object>> item = (List<Map<String, Object>>) itemsMap.get("item");

        rList = new ArrayList<>();

        for (Map<String, Object> map : item) {
            String analdate = (String) map.get("analdate");
            String area = String.valueOf(map.get("area"));
            String d1 = String.valueOf(map.get("d1"));
            String d2 = String.valueOf(map.get("d2"));
            String d3 = String.valueOf(map.get("d3"));
            String d4 = String.valueOf(map.get("d4"));
            String doname = (String) map.get("doname");
            String maxi = String.valueOf(map.get("maxi"));
            String meanavg = String.valueOf(map.get("meanavg"));
            String mini = String.valueOf(map.get("mini"));
            String regioncode = ((String) map.get("regioncode")).trim();
            String sigucode = ((String) map.get("sigucode")).trim();
            String sigun = (String) map.get("sigun");
            String std = String.valueOf(map.get("std"));
            String upplocalcd = String.valueOf(map.get("upplocalcd"));

            log.info("analdate : " + analdate);
            log.info("area : " + area);
            log.info("d1 : " + d1);
            log.info("d2 : " + d2);
            log.info("d3 : " + d3);
            log.info("d4 : " + d4);
            log.info("doname : " + doname);
            log.info("maxi : " + maxi);
            log.info("meanavg : " + meanavg);
            log.info("mini : " + mini);
            log.info("regioncode : " + regioncode);
            log.info("sigucode : " + sigucode);
            log.info("sigun : " + sigun);
            log.info("std : " + std);
            log.info("upplocalcd : " + upplocalcd);

            Map<String, String> resultMap = new HashMap<>();
            resultMap.put("analdate", analdate);
            resultMap.put("area", area);
            resultMap.put("d1", d1);
            resultMap.put("d2", d2);
            resultMap.put("d3", d3);
            resultMap.put("d4", d4);
            resultMap.put("doname", doname);
            resultMap.put("maxi", maxi);
            resultMap.put("meanavg", meanavg);
            resultMap.put("mini", mini);
            resultMap.put("regioncode", regioncode);
            resultMap.put("sigucode", sigucode);
            resultMap.put("sigun", sigun);
            resultMap.put("std", std);
            resultMap.put("upplocalcd", upplocalcd);

            rList.add(resultMap);
        }} else {
            log.info("response error");
            rList = new ArrayList<>();
        }

        log.info(this.getClass().getName() + ".checkEmergency End!!");

        return rList;
    }

    @Override
    public List<Map<String, String>> fireForestStatics(String searchStDt, String searchEdDt) throws Exception {
        log.info(this.getClass().getName() + ".fireForestStatics Start!");

        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(fireForestStaticsEndpoint);


        log.info(this.getClass().getName() + ".fireForestStatics End!");

        return null;
    }
}
