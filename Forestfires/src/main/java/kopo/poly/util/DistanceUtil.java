package kopo.poly.util;

import kopo.poly.dto.GoodsDTO;
import kopo.poly.dto.TemporaryDTO;
import kopo.poly.dto.hospitalDTO;

import java.util.List;

public class DistanceUtil {

    private static double distance(double lat1, double lon1, double lat2, double lon2) {

        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;


        dist = dist * 1.609344;


        return Math.round(dist*100)/100.00;
    }


    //10진수를 radian(라디안)으로 변환
    private static double deg2rad(double deg){
        return (deg * Math.PI/180.0);
    }
    //radian(라디안)을 10진수로 변환
    private static double rad2deg(double rad){
        return (rad * 180 / Math.PI);
    }

    public static List<hospitalDTO> sortByLatLonH(List<hospitalDTO> pList, double lat, double lon) {

        System.out.println("입력받은 리스트의 크기 : " + pList.size());
        System.out.println("입력받은 현위치 lat : "+lat+" , lon : "+lon);

        int len = pList.size();
        for (int i = 0; i < len; i++) {
            hospitalDTO hDTO = pList.get(i);
            double hDistance = distance(lat, lon, Double.parseDouble(hDTO.getH_lon()),Double.parseDouble(hDTO.getH_lat()) );
            System.out.println(hDistance);
            pList.get(i).setH_dis(hDistance);
        }

        for(int i=0;i<len-1;i++) {
            for(int j=i+1;j<len;j++) {
                hospitalDTO iDTO = pList.get(i);
                hospitalDTO jDTO = pList.get(j);
                //장렬 기준 : 입력받은 위치와의 거리
                if(iDTO.getH_dis()>jDTO.getH_dis()) {
                    hospitalDTO tmpDTO = iDTO;
                    pList.set(i,jDTO);
                    pList.set(j, tmpDTO);
                }
            }
        }

        return pList;
    }

    public static List<GoodsDTO> sortByLatLonG(List<GoodsDTO> pList, double lat, double lon) {

        System.out.println("입력받은 리스트의 크기 : " + pList.size());
        System.out.println("입력받은 현위치 lat : "+lat+" , lon : "+lon);

        int len = pList.size();
        for (int i = 0; i < len; i++) {
            GoodsDTO hDTO = pList.get(i);
            double distance = distance(lat, lon, Double.parseDouble(hDTO.getLat()),Double.parseDouble(hDTO.getLon()) );
            System.out.println(distance);
            pList.get(i).setDist(distance);
        }

        for(int i=0;i<len-1;i++) {
            for(int j=i+1;j<len;j++) {
                GoodsDTO iDTO = pList.get(i);
                GoodsDTO jDTO = pList.get(j);
                //장렬 기준 : 입력받은 위치와의 거리
                if(iDTO.getDist()>jDTO.getDist()) {
                    GoodsDTO tmpDTO = iDTO;
                    pList.set(i, jDTO);
                    pList.set(j, tmpDTO);
                }
            }
        }

        return pList;
    }

    public static List<TemporaryDTO> sortByLatLonT(List<TemporaryDTO> pList, double lat, double lon) {

        System.out.println("입력받은 리스트의 크기 : " + pList.size());
        System.out.println("입력받은 현위치 lat : "+lat+" , lon : "+lon);

        int len = pList.size();
        for (int i = 0; i < len; i++) {
            TemporaryDTO hDTO = pList.get(i);
            double distance = distance(lat, lon, Double.parseDouble(hDTO.getT_lat()),Double.parseDouble(hDTO.getT_lon()) );
            System.out.println(distance);
            pList.get(i).setDist(distance);
        }

        for(int i=0;i<len-1;i++) {
            for(int j=i+1;j<len;j++) {
                TemporaryDTO iDTO = pList.get(i);
                TemporaryDTO jDTO = pList.get(j);
                //장렬 기준 : 입력받은 위치와의 거리
                if(iDTO.getDist()>jDTO.getDist()) {
                    TemporaryDTO tmpDTO = iDTO;
                    pList.set(i, jDTO);
                    pList.set(j, tmpDTO);
                }
            }
        }

        return pList;
    }

}
