package tma.interns.roomsharing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tma.interns.roomsharing.entity.DistrictEntity;
import tma.interns.roomsharing.entity.WardEntity;
import tma.interns.roomsharing.service.WardService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class WardController {
    @Autowired
    private WardService wardservice;

    @GetMapping("/ward")
    public List<WardEntity> lis(){
        return wardservice.listAll();
    }

    @GetMapping("/ward/{ward_id}")
    public ResponseEntity<WardEntity> get(@PathVariable UUID ward_id){
        try
        {
            WardEntity wardEntity = wardservice.get(ward_id);
            return  new ResponseEntity<>(wardEntity, HttpStatus.OK);
        } catch (NoSuchElementException ex){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
