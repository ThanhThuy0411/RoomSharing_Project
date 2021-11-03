package tma.interns.roomsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tma.interns.roomsharing.entity.RoomSharingEntity;

import java.util.UUID;

@Repository
public interface RoomSharingRepo extends JpaRepository<RoomSharingEntity, UUID> {
    RoomSharingEntity findFirstByRoomSharingId (UUID roomSharingId);
    void  deleteById (UUID roomSharingId);
}
