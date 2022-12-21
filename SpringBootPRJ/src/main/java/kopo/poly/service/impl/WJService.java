package kopo.poly.service.impl;

import kopo.poly.dto.GoodsDTO;
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
import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service("WjService")
public class WJService implements IWjService {
    @Override
    public List<HashMap> TemPasing() throws Exception {


        HashMap<String, String> rMap = null;
        List<HashMap> rList = null;
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
                    rMap = new HashMap<>();
                    rMap.put("t_name", XmlPasingUtil.getTagValue("shel_nm", eElement));
                    rMap.put("t_adr", XmlPasingUtil.getTagValue("address", eElement));
                    rMap.put("t_pername", XmlPasingUtil.getTagValue("shel_av", eElement));
                    rMap.put("t_lat", XmlPasingUtil.getTagValue("lat", eElement));
                    rMap.put("t_lon", XmlPasingUtil.getTagValue("lon", eElement));

                    rList.add(rMap);
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

        File f = new File("src/main/resources/static/file/goods.csv");

        FileReader fileReader = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<GoodsDTO> rList = new ArrayList<>();


        String line = "";


        while((line = bufferedReader.readLine()) != null) {
            log.info(line);
            GoodsDTO gDTO = new GoodsDTO();
            if (line.contains("\"")) {
                String[] splitLine = line.split(",");
                String[] splitgoods = line.split("\"");
                String adr = line.substring(line.lastIndexOf(","));
                String tel = line.substring(line.lastIndexOf(","));
                gDTO = new GoodsDTO();

                gDTO.setG_se_na(splitLine[0]);
                gDTO.setG_go_na(splitgoods[1]);
                log.info(splitgoods[1]);
                gDTO.setG_adr(adr);
                log.info(adr);
                gDTO.setG_tel(tel);
                log.info(tel);


            } else {
                String[] splitLine = line.split(",");
                gDTO = new GoodsDTO();

                gDTO.setG_se_na(splitLine[0]);
                gDTO.setG_go_na(splitLine[1]);
                log.info(splitLine[1]);
                gDTO.setG_adr(splitLine[2]);
                gDTO.setG_tel(splitLine[3]);
                rList.add(gDTO);

            }


            rList.add(gDTO);
        }
        bufferedReader.close();

        return rList;
    }

    @Override
    public List<hospitalDTO> HospitalPasing()throws Exception{
        File f = new File("src/main/resources/static/file/hos.txt");

        FileReader fileReader = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<hospitalDTO> rList = new ArrayList<>();

        String line = "";
        while((line = bufferedReader.readLine()) != null) {
            log.info(line);
            String [] splitLine = line.split(",");

            hospitalDTO hDTO = new hospitalDTO();

            hDTO.setH_city(splitLine[0]);
            hDTO.setH_kind(splitLine[1]);
            hDTO.setH_name(splitLine[2]);
            hDTO.setH_tel(splitLine[3]);
            hDTO.setH_adr(splitLine[4]);
            hDTO.setH_lat(splitLine[5]);
            hDTO.setH_lon(splitLine[5]);
            rList.add(hDTO);
        }
        bufferedReader.close();

        return rList;
    }


}
