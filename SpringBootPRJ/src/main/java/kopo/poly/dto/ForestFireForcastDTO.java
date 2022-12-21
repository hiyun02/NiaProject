package kopo.poly.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForestFireForcastDTO {

    //요청변수
    private String numOfRows1;
    private String pageNo1;
    private String excludeForecast; // 0
    private String localAreas; // 지역코드(시도일 땐 2자리 시군구일 땐 5자리 읍면동일 땐 8자리)
    private String upplocalcd1; // 시도코드(시군구일 때 지역코드 2자리)
    //private String ServiceKey;
    //private String _type;

    //응답변수
    private String numOfRows2;
    private String pageNo2;
    private String totalCount;
    private String resultCode;
    private String resultMsg;
    private String analdate;
    private String area;
    private String d1;
    private String d2;
    private String d3;
    private String d4;
    private String doname;
    private String maxi;
    private String meanavg;
    private String mini;
    private String regioncode;
    private String sigucode;
    private String sigun;
    private String searchcd;
    private String std;
    private String upplocalcd2;
    private String codeemd;
    private String emd;
    private String gungu;

    private String level;
}
