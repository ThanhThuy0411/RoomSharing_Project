package tma.interns.roomsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tma.interns.roomsharing.entity.RoomShareDetailEntity;

import java.util.List;
import java.util.UUID;
@Repository
public interface RoomShareDetailRepo extends JpaRepository <RoomShareDetailEntity, UUID> {
    RoomShareDetailEntity findFirstByRoomShareDetailId(UUID roomShareDetailId);
    void  deleteById (UUID roomShareDetailId);
    List<RoomShareDetailEntity> findFirstByRoomSharingId(UUID roomSharingId);
    RoomShareDetailEntity findFirstByUserId(UUID userId);
}
