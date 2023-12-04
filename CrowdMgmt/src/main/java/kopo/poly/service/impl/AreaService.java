package kopo.poly.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kopo.poly.dto.AreaDTO;
import kopo.poly.dto.ReportDTO;
import kopo.poly.repository.AreaRepository;
import kopo.poly.repository.entity.AreaEntity;
import kopo.poly.service.IApiService;
import kopo.poly.service.IAreaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AreaService implements IAreaService {

    private final AreaRepository repository;


    @Override
    public List<AreaDTO> getAresList() throws Exception {
        log.info(this.getClass().getName() + "지도 좌표 가져오기");

        List<AreaEntity> areaEntityList = repository.findAllByOrderByLocation();

        List<AreaDTO> areaDTOList = new ObjectMapper().convertValue(areaEntityList, new TypeReference<List<AreaDTO>>() {
        }) ;

        areaEntityList = null;
        return areaDTOList;

    }
}
