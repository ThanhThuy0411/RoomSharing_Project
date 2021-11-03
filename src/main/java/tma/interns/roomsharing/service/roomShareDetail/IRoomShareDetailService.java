package tma.interns.roomsharing.service.roomShareDetail;

import tma.interns.roomsharing.dto.roomShareDetail.RoomShareCreateDetailDto;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareDetailDto;

import java.util.List;
import java.util.UUID;

public interface IRoomShareDetailService {
    boolean delete (UUID roomShareDetailId);
    RoomShareDetailDto createDetail(RoomShareCreateDetailDto roomShareCreateDetailDto) throws Exception;
    List<RoomShareDetailDto> listAllByRoomSharingId(UUID roomSharingId);
    RoomShareDetailDto joinByRoomSharingId (RoomShareCreateDetailDto roomShareCreateDetailDto, UUID roomSharingId) throws Exception;
}
