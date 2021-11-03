package tma.interns.roomsharing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tma.interns.roomsharing.entity.DistrictEntity;
import tma.interns.roomsharing.entity.ProvinceEntity;
import tma.interns.roomsharing.service.DistrictService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class DistrictController {

    @Autowired
    private DistrictService service;
    @GetMapping("/district")
    public List<DistrictEntity> list(){
        return service.listAll();
    }
    @GetMapping("/district/{district_id}")
    public ResponseEntity<DistrictEntity> get(@PathVariable UUID district_id){
        try
        {
            DistrictEntity districtEntity = service.get(district_id);
            return  new ResponseEntity<>(districtEntity, HttpStatus.OK);
        } catch (NoSuchElementException ex){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
