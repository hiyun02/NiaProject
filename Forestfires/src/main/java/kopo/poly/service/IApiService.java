package kopo.poly.service;

import java.util.List;
import java.util.Map;

public interface IApiService {
    List<Map<String, String>> fireForestForcast(String address) throws Exception;

    List<Map<String, String>> fireForestStatics(String searchStDt, String searchEdDt) throws Exception;

}
