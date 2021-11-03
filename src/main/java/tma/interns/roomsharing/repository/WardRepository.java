package tma.interns.roomsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tma.interns.roomsharing.entity.WardEntity;

import java.util.UUID;

public interface WardRepository extends JpaRepository<WardEntity, UUID> {
}
