package kopo.poly.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RowCityDTO {

    private String fcst_time; // 인구 예측시점
    private String fcst_congest_lvl; // 장소 예측 혼잡도 지표
    private String fcst_ppltn_min; // 예측 실시간 인구 지표 최소값
    private String fcst_ppltn_max; // 예측 실시간 인구 지표 최대값

}
