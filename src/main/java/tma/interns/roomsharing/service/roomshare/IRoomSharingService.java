package tma.interns.roomsharing.service.roomshare;

import tma.interns.roomsharing.dto.roomshare.RoomSharingDto;

import java.util.List;
import java.util.UUID;

public interface IRoomSharingService {
    RoomSharingDto newRoomSharing (RoomSharingDto roomSharing) throws Exception;
    List<RoomSharingDto> listAll();
    RoomSharingDto getById(UUID roomSharingId);
    boolean delete(UUID roomSharingId);
}
