package kopo.poly.controller;


import kopo.poly.dto.ChartDTO;
import kopo.poly.dto.GoodsDTO;
import kopo.poly.dto.TemporaryDTO;
import kopo.poly.dto.hospitalDTO;
import kopo.poly.service.IWjService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class WjController {

    @Resource(name = "WjService")
    private IWjService wjService;

    @GetMapping(value = "Temporary") // 임시 대피장소 hashmap으로 파싱 + 이재민 해일
    public String Temporary(ModelMap model, HttpSession session) throws Exception {
        log.info(getClass().getName() + "Temporary Start");

        List<TemporaryDTO> rList = wjService.TemPasing();


        log.info("가져온 rList 크기 " + rList.size());

        session.setAttribute("tList", rList);

        for (int i = 0; i < rList.size(); i++) {
            TemporaryDTO tDTO = rList.get(i);

            log.info(tDTO.getT_lon());
            log.info(tDTO.getT_name());

        }

        log.info(getClass().getName() + "Temporary end");

        return "/TemporaryMap";
    }

    @GetMapping(value = "goods") // 구호물품 DTO로 csv 파싱
    public String goods(ModelMap model, HttpSession session) throws Exception {
        log.info(getClass().getName() + "goods start");

        List<GoodsDTO> rList = wjService.GoodsPasing();

        log.info("가져온 rList 크기 " + rList.size());


        session.setAttribute("gList", rList);

        log.info(getClass().getName() + "goods end");
        return "/goodsMap";

    }

    @GetMapping(value = "hospital") // 병원 위치 DTO로 파싱,
    public String hospital(ModelMap model, HttpSession session) throws Exception {

        log.info(getClass().getName() + "hospital start");

        List<hospitalDTO> rList = wjService.HospitalPasing();

        log.info("가져온 rList 크기 " + rList.size());

        for (int i = 0; i < rList.size(); i++) {
            hospitalDTO tDTO = rList.get(i);
            log.info(tDTO.getH_lon() + ", " + tDTO.getH_lat());
        }

        session.setAttribute("hList", rList);

        log.info(getClass().getName() + "hospital end");
        return "/indexHospital";
    }

    @GetMapping(value = "chart")
    public String chart() throws Exception {

        log.info(getClass().getName() + "chart start");

        List<ChartDTO> rList = wjService.chartPasing();

        log.info("가져온 rList 크기 " + rList.size());


        for (int i = 0; i < rList.size(); i++) {
            ChartDTO tDTO = rList.get(i);

            if (tDTO.getChungcheong() != null) {
                log.info("충청도 있음");
            }

        }

        log.info(getClass().getName() + "chart end");

        return null;
    }
}
