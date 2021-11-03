package tma.interns.roomsharing.service.room;

import tma.interns.roomsharing.dto.room.RoomInfoBasicDto;
import tma.interns.roomsharing.dto.room.RoomInfoDetailDto;
import tma.interns.roomsharing.dto.room.RoomInfoCreateDto;

import java.util.List;
import java.util.UUID;

public interface IRoomInfoService {
    RoomInfoDetailDto getById(UUID roomId);
    boolean delete(UUID room_id);
    RoomInfoDetailDto updateRoomInfo (RoomInfoDetailDto dto, UUID roomId) throws Exception;
    List<RoomInfoBasicDto> listAll();
    RoomInfoDetailDto createRoomInfo(RoomInfoCreateDto newRoomInfo) throws Exception;
}
