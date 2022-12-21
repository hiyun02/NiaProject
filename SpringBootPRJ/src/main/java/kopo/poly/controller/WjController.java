package kopo.poly.controller;


import kopo.poly.dto.GoodsDTO;
import kopo.poly.dto.hospitalDTO;
import kopo.poly.service.IWjService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
public class WjController {

    @Resource(name = "WjService")
    private IWjService wjService;

    @GetMapping(value = "Temporary") // 임시 대피장소 hashmap으로 파싱
    public String Temporary(ModelMap model) throws Exception{
        log.info(getClass().getName()+"Temporary Start");

        List<HashMap>rList  = wjService.TemPasing();


        log.info("가져온 rList 크기 " + rList.size());

        model.addAttribute("rList",rList);

        log.info(getClass().getName()+"Temporary end");

        return null;
    }

    @GetMapping(value = "goods") // 구호물품 DTO로 csv 파싱
    public String goods(ModelMap model) throws Exception{
        log.info(getClass().getName() + "goods start");

        List<GoodsDTO> rList = wjService.GoodsPasing();

        log.info("가져온 rList 크기 " + rList.size());


        model.addAttribute("rList",rList);

        log.info(getClass().getName() + "goods end");
        return null;
    }

    @GetMapping(value = "hospital") // 병원 위치 DTO로 파싱
    public String hospital(ModelMap model) throws Exception{
        log.info(getClass().getName() + "hospital start");

        List<hospitalDTO> rList = wjService.HospitalPasing();

        log.info("가져온 rList 크기 " + rList.size());

        model.addAttribute("rList",rList);

        log.info(getClass().getName() + "hospital end");
        return null;
    }









}
