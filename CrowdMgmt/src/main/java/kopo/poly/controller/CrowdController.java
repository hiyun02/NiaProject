package kopo.poly.controller;

import kopo.poly.dto.AreaDTO;
import kopo.poly.dto.CityDTO;
import kopo.poly.dto.ReportDTO;
import kopo.poly.service.IApiService;
import kopo.poly.service.IAreaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.logging.Handler;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/crowd")
@Controller
public class CrowdController {


    private String title = "";
    private String state = "";
    private String msg = "";
    private String url = "";


    private final IApiService apiService;
    private final IAreaService areaService;
    private final RestTemplate restTemplate;

    /* 메인 페이지 시작!*/
    @GetMapping("crowd")
    public String crowd(Model model) throws Exception {


//        String maxReport = apiService.getHourReportList("국립중앙박물관·용산가족공원");
        List<CityDTO> cityDTOList = apiService.allSeoulData();

//        List<ReportDTO> reportDTOList = apiService.getReportList();



        model.addAttribute("cityDTOList", cityDTOList);
//        model.addAttribute("reportDTOList", reportDTOList);

        cityDTOList = null;

        return "crowd";
    }

    @PostMapping("uploadReport")
    public String uploadReport(ReportDTO reportDTO, @RequestParam(value = "file") MultipartFile mf, Model model) throws Exception {
        log.info(this.getClass().getName() + "인구밀집 제보 시작!");

        String orgFileName = mf.getOriginalFilename();

        int res = apiService.insertReport(reportDTO, mf, orgFileName);

        log.info("결과는 ? " + res);
        if (res == 1) {
            title = "인구 밀집 상황등록";
            state = "success";
            msg = "인구 밀집 상황등록 성공!";
            url = "/crowd/crowd";   //controller 주소 작성
        } else {
            title = "인구 밀집 상황등록";
            state = "false";
            msg = "인구 밀집 상황등록 실패 :(";
            url = "/crowd/crowd";   //controller 주소 작성

        }

        model.addAttribute("title", title);
        model.addAttribute("state", state);
        model.addAttribute("msg", msg);
        model.addAttribute("url", url);
        log.info(this.getClass().getName() + "인구밀집 제보 종료!");

        return "redirect";
    }

    @ResponseBody
    @PostMapping("getSeoulApi")
    public CityDTO getSeoulAPi(@RequestParam String title) throws Exception {
        log.info(this.getClass().getName() + "실시간 인구밀집도 가져오기 ");

        log.info(title);

        return apiService.getSeoulData(title);
    }

    @ResponseBody
    @PostMapping("getMaxReport")
    public String getMaxReport(@RequestParam String title) throws Exception {
        log.info(this.getClass().getName() + "마커 클릭시 해당하는 장소 제보중 가장 인구밀집도 가져오기 ");

        log.info("title : " + title);
        return apiService.getHourReportList(title);
    }

    @ResponseBody
    @PostMapping("getReportList")
    public List<ReportDTO> getReportList(@RequestParam String title) throws Exception {
        log.info(this.getClass().getName() + "실시간 인구밀집도 가져오기 ");

        return apiService.getReportList(title);
    }



}
