package kopo.poly.service;

import java.util.Map;

public interface IApiService {

    Map<String, String> checkEmergency(String regionCode) throws Exception;

}
