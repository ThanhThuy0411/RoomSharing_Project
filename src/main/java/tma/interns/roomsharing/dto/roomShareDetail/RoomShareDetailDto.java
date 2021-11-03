package tma.interns.roomsharing.dto.roomShareDetail;

import lombok.Builder;
import lombok.Data;
import tma.interns.roomsharing.enumration.ShareRole;

import java.util.UUID;

@Data
@Builder
public class RoomShareDetailDto {
    private UUID roomShareDetailId;
    private UUID roomSharingId;
    private UUID userId;
    private ShareRole role;

    public RoomShareDetailDto(UUID roomShareDetailId, UUID roomSharingId, UUID userId,ShareRole role){
        this.roomShareDetailId = roomShareDetailId;
        this.roomSharingId = roomSharingId;
        this.userId = userId;
        this.role = role;
    }

}
