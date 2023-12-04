package kopo.poly.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportDTO {

    private Long reportSeq; // 제보 순서(PK)
    private String belong; // 소속
    private String name; //성명
    private String location; //위치
    private String phone; //전화번호
    private String density; //밀집도
    private String filePath; // 파일 경로
    private String reportDT; //제보일자


}
