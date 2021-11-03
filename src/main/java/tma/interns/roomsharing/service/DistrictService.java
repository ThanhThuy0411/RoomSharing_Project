package tma.interns.roomsharing.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tma.interns.roomsharing.entity.DistrictEntity;
import tma.interns.roomsharing.repository.DistrictRepository;

import java.util.List;
import java.util.UUID;

@Service
public class DistrictService implements IDistrictService {
    private final DistrictRepository districtRepo;
    @Autowired

    public DistrictService(DistrictRepository districtRepo, DistrictRepository repo) {
        this.districtRepo = districtRepo;
    }

    public List<DistrictEntity> listAll(){
        return districtRepo.findAll();
    }
    public void save(DistrictEntity districtEntity){
        districtRepo.save(districtEntity);
    }
    public DistrictEntity get(UUID districs_id){
        return districtRepo.findById(districs_id).get();
    }
}
