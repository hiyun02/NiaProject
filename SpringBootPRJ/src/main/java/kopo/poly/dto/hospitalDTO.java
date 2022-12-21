package kopo.poly.dto;


import lombok.Data;

@Data
public class hospitalDTO {


    private String h_city; // 병원 시도
    private String h_name; // 병원이름
    private String h_kind; // 병원종류
    private String h_tel; // 전화번호
    private String h_adr; // 주소
    private String h_lat; //위도
    private String h_lon; //경도


}
