package kopo.poly.controller;

import kopo.poly.service.IApiService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class ApiController {

    private final IApiService apiService;

    public ApiController(IApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping(value = "/forcast")
    public String fireForestForcast(HttpServletRequest request, ModelMap modelMap) throws Exception {

        log.info(this.getClass().getName() + ".fireForestForcast start!");

        String address = CmmUtil.nvl(request.getParameter("address"));

        log.info("address : " + address);

        List<Map<String, String>> rList = apiService.fireForestForcast(address);

        if (rList == null) {
            log.info("rList is null");
            rList = new ArrayList<>();
        }

        if (rList.size()!=0) {
            modelMap.addAttribute("rList", rList);
            modelMap.addAttribute("resultYn", "Y");
        } else {
            modelMap.addAttribute("resultYn", "");
        }

        log.info(this.getClass().getName() + ".fireForestForcast end!");

        return "/index";
    }

    @GetMapping(value = "/locate")
    public String locate(HttpServletRequest request, ModelMap modelMap) {

        log.info(this.getClass().getName() + ".locate Start!");

        String lat = (CmmUtil.nvl(request.getParameter("lat")));
        String lon = (CmmUtil.nvl(request.getParameter("lon")));
        String page = (CmmUtil.nvl(request.getParameter("page")));

        log.info("lat : "+lat);
        log.info("lon : "+lon);
        log.info("page : "+page);

        modelMap.addAttribute("lat", lat);
        modelMap.addAttribute("lon", lon);
        modelMap.addAttribute("locateYn", "Y");

        log.info(this.getClass().getName() + ".locate End!");

        return "/"+page;
    }

    @ResponseBody
    @GetMapping(value = "/statics")
    public List<Map<String,String>> fireForestStatics(HttpServletRequest request) throws Exception {
        log.info(this.getClass().getName() + ".fireForestStatics Start!");

        String searchStDt = CmmUtil.nvl(request.getParameter("searchStDt"));
        String searchEdDt = CmmUtil.nvl(request.getParameter("searchEdDt"));

        log.info("searchStDt :"+searchStDt);
        log.info("searchEdDt :"+searchEdDt);

        List<Map<String, String>> rList = apiService.fireForestStatics(searchStDt, searchEdDt);

        log.info(this.getClass().getName() + ".fireForestStatics End!");

        return rList;
    }
}
