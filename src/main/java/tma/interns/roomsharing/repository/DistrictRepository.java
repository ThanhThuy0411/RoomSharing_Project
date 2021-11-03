package tma.interns.roomsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tma.interns.roomsharing.entity.DistrictEntity;

import java.util.UUID;

public interface DistrictRepository extends JpaRepository<DistrictEntity, UUID> {
}
