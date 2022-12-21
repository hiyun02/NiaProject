package kopo.poly.dto;

import lombok.Data;

@Data
public class TemporaryDTO {

    private String t_name; // 대피장소명
    private String t_addr; // 도로명주소
    private String t_pernum; // 수용가능인원수
    private String t_lat;// 위도
    private String t_lon; //경도
}
