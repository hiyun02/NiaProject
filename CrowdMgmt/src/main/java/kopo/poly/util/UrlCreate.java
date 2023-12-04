package kopo.poly.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
public class UrlCreate {

    private static String appKey = "57664b6748666c6f38327252535158";

    public static String getSeoulCityDat(){
        StringBuilder url = new StringBuilder();
        url.append(" http://openapi.seoul.go.kr:8088/")
                .append(appKey).append("/json").append("citydata_ppltn").append("1").append("100")
                .append("");

        return url.toString();

    }
}
