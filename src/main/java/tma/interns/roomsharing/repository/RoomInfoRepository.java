package tma.interns.roomsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tma.interns.roomsharing.dto.room.SearchRoomDto;
import tma.interns.roomsharing.entity.RoomInfoEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoomInfoRepository extends JpaRepository<RoomInfoEntity, UUID> {

    RoomInfoEntity findFirstByRoomId(UUID roomId);
    void deleteByRoomId(UUID rooms);
    @Query("SELECT u FROM RoomInfoEntity u"+
            " WHERE (:#{#search.provinceId} is null OR u.provinceId = :#{#search.provinceId})"+
            " AND (:#{#search.wardId} is null OR u.wardId =:#{#search.wardId})"+
            " AND (:#{#search.districtId} is null OR u.districtId = :#{#search.districtId})"+
            " AND (:#{#search.fromAcreage} is null OR u.acreage >= :#{#search.fromAcreage})"+
            " AND (:#{#search.toAcreage} is null OR u.acreage <= :#{#search.toAcreage})" +
            " AND (:#{#search.fromRoomPrice} is null OR u.roomPrice >= :#{#search.fromRoomPrice})"+
            " AND (:#{#search.toRoomPrice} is null OR u.roomPrice <= :#{#search.toRoomPrice})"+
            " AND (:#{#search.getValueStatusHired()} is null OR u.statusHired = :#{#search.getValueStatusHired()})"
    )
    List<RoomInfoEntity> findRoomInfo(@Param("search") SearchRoomDto searchRoomDto);
}
