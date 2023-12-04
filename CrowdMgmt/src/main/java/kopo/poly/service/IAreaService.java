package kopo.poly.service;

import kopo.poly.dto.AreaDTO;

import java.util.List;

public interface IAreaService {

    /* 최초 지도 로딩시 좌표 가져오기 */
    List<AreaDTO> getAresList() throws Exception;


}
