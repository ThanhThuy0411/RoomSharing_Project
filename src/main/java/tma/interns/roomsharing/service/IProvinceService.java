package tma.interns.roomsharing.service;

import tma.interns.roomsharing.entity.ProvinceEntity;

import java.util.List;
import java.util.UUID;

public interface IProvinceService {

    List<ProvinceEntity> listAll();
    void save(ProvinceEntity provinceEntity);
    ProvinceEntity get(UUID Province_id);
}
