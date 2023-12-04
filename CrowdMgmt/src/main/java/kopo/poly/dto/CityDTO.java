package kopo.poly.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CityDTO {

    private String AREA_NM; //장소명명
    private String AREA_CD; //핫스팟 코드명
    private String LIVE_PPLTN_STTS; //실시간 인구현황
    private String AREA_CONGEST_LVL; //장소 혼잡도 지표
    private String AREA_CONGEST_MSG; //장소 혼잡도 지표 관련 메세지
    private String AREA_PPLTN_MIN; //실시간 인구 지표 최소값
    private String AREA_PPLTN_MAX; //실시간 인구 지표 최대값
    private String FEMALE_PPLTN_RATE; //여성 인구 비율(여성)AREA_CONGEST_MSG
    private String PPLTN_RATE_0; //0~10세 인구 비율
    private String PPLTN_RATE_10; // 10대 실시간 인구 비율
    private String PPLTN_RATE_20; // 20대 실시간 인구 비율
    private String PPLTN_RATE_30; // 30대 실시간 인구 비율
    private String PPLTN_RATE_40; // 40대 실시간 인구 비율
    private String PPLTN_RATE_50; // 50대 실시간 인구 비율
    private String PPLTN_RATE_60; // 60대 실시간 인구 비율
    private String PPLTN_RATE_70; // 70대 실시간 인구 비율
    private String RESNT_PPLTN_RATE; // 상주 인구 비율
    private String NON_RESNT_PPLTN_RATE; // 비상주 인구 비율
    private String REPLACE_YN; // 대체 데이터 여부
    private String PPLTN_TIME; // 실시간 인구 데이터 업데이트 시간
    private String FCST_YN; // 예측값 제공 여부
    private List<RowCityDTO> FCST_PPLTN; // 인구 예측 오브젝트
    private String MALE_PPLTN_RATE; //남성 인구 비율(남성)

//    private String area_CD;
//    private String area_CONGEST_LVL;
//    private String area_CONGEST_MSG;
//    private String area_PPLTN_MAX;
//    private String area_PPLTN_MIN;
//    private List<RowCityDTO> fcst_PPLTN;
//    private String fcst_YN;
//    private String female_PPLTN_RATE;
//    private String live_PPLTN_STTS;
//    private String male_PPLTN_RATE;
//    private String non_RESNT_PPLTN_RATE;
//    private String ppltn_RATE_0;
//    private String ppltn_RATE_10;
//    private String ppltn_RATE_20;
//    private String ppltn_RATE_30;
//    private String ppltn_RATE_40;
//    private String ppltn_RATE_50;
//    private String ppltn_RATE_60;
//    private String ppltn_RATE_70;
//    private String ppltn_TIME;
//    private String replace_YN;
//    private String resnt_PPLTN_RATE;

    private String location;
    private String lat;
    private String lng;

}
