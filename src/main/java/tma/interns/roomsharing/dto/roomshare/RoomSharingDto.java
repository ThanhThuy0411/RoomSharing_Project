package tma.interns.roomsharing.dto.roomshare;

import lombok.Data;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareDetailDto;

import java.util.List;
import java.util.UUID;
@Data
public class RoomSharingDto {
    private UUID roomSharingId;
    private UUID roomId;
    private List<RoomShareDetailDto> roomShareDetails;
}
