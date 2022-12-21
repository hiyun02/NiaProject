package kopo.poly.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import kopo.poly.service.IApiService;
import kopo.poly.util.UrlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Service("ApiService")
public class ApiService implements IApiService {

    private final String ForestFireForcastSigunguEndpoint="http://223.130.129.189:9191/getForestPointListSigunguSearch/";

    @Override
    public Map<String, String> checkEmergency(String regionCode) throws Exception {

        log.info(this.getClass().getName() + ".checkEmergency Start!!");

        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(ForestFireForcastSigunguEndpoint);
        urlBuilder.append("localAreas=");
        urlBuilder.append(regionCode);
        urlBuilder.append("&_type=");
        urlBuilder.append("json");
        String url = urlBuilder.toString();
        log.info("request url : " + url);

        UrlUtil uu = new UrlUtil();
        String json = uu.urlReadforString(url);
        log.info("response : " + json);

        Map<String, Object> rMap = new ObjectMapper().readValue(json, LinkedHashMap.class);
        Map<String, Object> responseMap = (Map<String, Object>) rMap.get("response");
        Map<String, Object> bodyMap = (Map<String, Object>) responseMap.get("body");
        Map<String, Object> itemsMap = (Map<String, Object>) bodyMap.get("items");
        Map<String, Object> item = (Map<String, Object>) itemsMap.get("item");

        String analdate = (String)item.get("analdate");
        String area = String.valueOf(item.get("area"));
        String d1 = String.valueOf(item.get("d1"));
        String d2 = String.valueOf(item.get("d2"));
        String d3 = String.valueOf(item.get("d3"));
        String d4 = String.valueOf(item.get("d4"));
        String doname = (String)item.get("doname");
        String maxi = String.valueOf(item.get("maxi"));
        String meanavg = String.valueOf(item.get("meanavg"));
        String mini = String.valueOf(item.get("mini"));
        String regioncode = (String)item.get("regioncode");
        String sigucode = (String)item.get("sigucode");
        String sigun = (String)item.get("sigun");
        String sid = String.valueOf(item.get("sid"));
        String upplocalcd = String.valueOf(item.get("upplocalcd"));

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
        log.info("sid : " + sid);
        log.info("upplocalcd : " + upplocalcd);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("analdate", analdate);
        resultMap.put("area", area);
        resultMap.put("d1", d1);
        resultMap.put("d2", d2);
        resultMap.put("d3", d3);
        resultMap.put("doname", doname);
        resultMap.put("maxi", maxi);
        resultMap.put("meanavg", meanavg);
        resultMap.put("mini", mini);
        resultMap.put("regioncode", regioncode);
        resultMap.put("sigucode", sigucode);
        resultMap.put("sigun", sigun);
        resultMap.put("sid", sid);
        resultMap.put("upplocalcd", upplocalcd);

        log.info(this.getClass().getName() + ".checkEmergency End!!");

        return resultMap;
    }
}
