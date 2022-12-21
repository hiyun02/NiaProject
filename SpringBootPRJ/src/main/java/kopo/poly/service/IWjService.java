package kopo.poly.service;

import kopo.poly.dto.GoodsDTO;
import kopo.poly.dto.TemporaryDTO;
import kopo.poly.dto.hospitalDTO;

import java.util.HashMap;
import java.util.List;

public interface IWjService {
    List<HashMap> TemPasing() throws Exception;


    List<GoodsDTO> GoodsPasing()throws Exception;

    List<hospitalDTO> HospitalPasing()throws Exception;
}
