package kopo.poly.service.impl;

import kopo.poly.dto.ChartDTO;
import kopo.poly.dto.GoodsDTO;
import kopo.poly.dto.TemporaryDTO;
import kopo.poly.dto.hospitalDTO;
import kopo.poly.service.IWjService;
import kopo.poly.util.XmlPasingUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service("WjService")
public class WJService implements IWjService {
    @Override
    public List<TemporaryDTO> TemPasing() throws Exception {


        List<TemporaryDTO> rList = null;
        try {
            // parsing할 url 지정(API 키 포함해서)
            String url = "http://223.130.129.189:9191/getTsunamiShelter1List/numOfRows=999&pageNo=1&type=xml";

            DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
            Document doc = dBuilder.parse(url);

            // 제일 첫번째 태그
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("row");
            log.info("row 크기 " + nList.getLength());
            rList = new ArrayList<>();

            // 파싱할 tag
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                Element eElement = (Element) nNode;

                try {
                    TemporaryDTO tDTO = new TemporaryDTO();

                    tDTO.setT_name(XmlPasingUtil.getTagValue("shel_nm",eElement));
                    tDTO.setT_addr(XmlPasingUtil.getTagValue("address",eElement));
                    tDTO.setT_pernum(XmlPasingUtil.getTagValue("shel_av",eElement));
                    tDTO.setT_lat(XmlPasingUtil.getTagValue("lat",eElement));
                    tDTO.setT_lon(XmlPasingUtil.getTagValue("lon",eElement));

                    rList.add(tDTO);
                } catch (NullPointerException e) {
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rList;
    }

    @Override
    public List<GoodsDTO> GoodsPasing()throws Exception{

        File f = new File("/usr/local/goods.csv");

        FileReader fileReader = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<GoodsDTO> rList = new ArrayList<>();


        String line = "";


        while((line = bufferedReader.readLine()) != null) {
//            log.info(line);
            GoodsDTO gDTO;
            if (line.contains("\"")) {
                String[] splitLine = line.split(",");
                String[] splitgoods = line.split("\"");
                String adr = line.substring(line.lastIndexOf("\"") +2 ,line.lastIndexOf(","));
                String tel = line.substring(line.lastIndexOf(",")+1);
                gDTO = new GoodsDTO();

                gDTO.setG_se_na(splitLine[0]);
                gDTO.setG_go_na(splitgoods[1]);
//                log.info(splitgoods[1]);
                gDTO.setG_adr(adr);
//                log.info(adr);
                gDTO.setG_tel(tel);
//                log.info(tel);


            } else {
                String[] splitLine = line.split(",");
                gDTO = new GoodsDTO();

                gDTO.setG_se_na(splitLine[0]);
                gDTO.setG_go_na(splitLine[1]);
                gDTO.setG_adr(splitLine[2]);
                gDTO.setG_tel(splitLine[3]);

            }


            rList.add(gDTO);
        }
        bufferedReader.close();

        return rList;
    }

    @Override
    public List<hospitalDTO> HospitalPasing()throws Exception{
        File f = new File("/usr/local/hos.txt");

        FileReader fileReader = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<hospitalDTO> rList = new ArrayList<>();

        String line = "";
        while((line = bufferedReader.readLine()) != null) {
//            log.info(line);
            String [] splitLine = line.split(",");

            hospitalDTO hDTO = new hospitalDTO();

            hDTO.setH_city(splitLine[0]);
            hDTO.setH_kind(splitLine[1]);
            hDTO.setH_name(splitLine[2]);
            hDTO.setH_tel(splitLine[3]);
            hDTO.setH_adr(splitLine[4]);
            hDTO.setH_lat(splitLine[5]);
            hDTO.setH_lon(splitLine[6]);
            rList.add(hDTO);
        }
        bufferedReader.close();

        return rList;
    }

    @Override
    public List<ChartDTO> chartPasing()throws Exception {

        List<ChartDTO> rList = null;
        try {
            String url = "http://223.130.129.189:9191/getfirestatsservice/numOfRows=999&pageNo=1&searchStDt=20200601";

            DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
            Document doc = dBuilder.parse(url);

            // 제일 첫번째 태그
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("item");
            log.info("item 크기 " + nList.getLength());
            rList = new ArrayList<>();

            // 파싱할 tag
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                Element eElement = (Element) nNode;

                try {
                    ChartDTO tDTO = new ChartDTO();

                    String pasing = XmlPasingUtil.getTagValue("locsi", eElement);

                    log.info("지역  : " + pasing);


                   if (pasing.equals("경남")){
                       tDTO.setGyeongsang("1");
                   } else if (pasing.equals("경북")) {
                       tDTO.setGyeongsang("1");
                   }else if (pasing.equals("대구")){
                       tDTO.setGyeongsang("1");
                   } else if (pasing.equals("울산")) {
                       tDTO.setGyeongsang("1");
                   } else if (pasing.equals("부산")) {
                       tDTO.setGyeongsang("1");
                   }else if (pasing.equals("충남")){
                       tDTO.setChungcheong("1");
                   } else if (pasing.equals("충북")) {
                       tDTO.setChungcheong("1");
                   } else if (pasing.equals("인천")) {
                       tDTO.setSeoul("1");
                   } else if (pasing.equals("경기")) {
                       tDTO.setSeoul("1");
                   } else if (pasing.equals("서울")) {
                       tDTO.setSeoul("1");
                   } else if (pasing.equals("전남")) {
                       tDTO.setJeolla("1");
                   } else if (pasing.equals("전북")) {
                       tDTO.setJeolla("1");
                   }else {
                       log.info("지역에 없음 특이");
                       continue;
                   }

                    rList.add(tDTO);

                } catch (NullPointerException e) {
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rList;
    }


}
