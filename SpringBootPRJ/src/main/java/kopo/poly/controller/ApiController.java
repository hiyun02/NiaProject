package kopo.poly.controller;

import kopo.poly.dto.ForestFireForcastDTO;
import kopo.poly.service.IApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@Controller
public class ApiController {

    @Resource(name = "ApiService")
    private IApiService apiService;

    @ResponseBody
    @GetMapping(value = "/current")
    public Map<String, String> fireForestForcast(HttpServletRequest request) throws Exception {

        log.info(this.getClass().getName() + ".fireforestforcast start!");

        String regionCode = (String) request.getParameter("regionCode");
        log.info("regionCode : " + regionCode);

        Map<String, String> rMap = apiService.checkEmergency(regionCode);

        log.info(this.getClass().getName() + ".fireforestforcast end!");

        return rMap;
    }
}
