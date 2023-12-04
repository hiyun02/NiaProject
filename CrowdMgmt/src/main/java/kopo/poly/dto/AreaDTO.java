package kopo.poly.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AreaDTO {

    /* 주요지역 150개 좌표 DTO*/
    private String location; // 지역 명
    private String lat; //x좌표
    private String lng; //y좌표


}
