package kopo.poly.service;

import kopo.poly.dto.CityDTO;
import kopo.poly.dto.ReportDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IApiService {

    /* 인구밀집 업로드 */
    int insertReport(ReportDTO reportDTO, MultipartFile mf, String saveFileName) throws Exception;

    String getHourReportList(String title) throws Exception;

    List<ReportDTO> getReportList(String locationName)throws Exception;

    /* 서울시 인구밀집 데이터 가져오기 */
    CityDTO getSeoulData(String city) throws Exception;

    /* 서울시 인구밀집 데이터 전체 가져오기 */
    List<CityDTO> allSeoulData() throws Exception;
}
