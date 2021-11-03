package tma.interns.roomsharing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tma.interns.roomsharing.entity.ProvinceEntity;
import tma.interns.roomsharing.service.ProvinceService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class ProvinceController {

    @Autowired
    private ProvinceService provinceservice;

    @GetMapping("/province")
    public List<ProvinceEntity> list(){
        return provinceservice.listAll();
    }
    @GetMapping("/province/{province_id}")
    public ResponseEntity<ProvinceEntity>get(@PathVariable UUID province_id){
        try
        {
            ProvinceEntity provinceEntity = provinceservice.get(province_id);
            return  new ResponseEntity<>(provinceEntity, HttpStatus.OK);
        } catch (NoSuchElementException ex){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
