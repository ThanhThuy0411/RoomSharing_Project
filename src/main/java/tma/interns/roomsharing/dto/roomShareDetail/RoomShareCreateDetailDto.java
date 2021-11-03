package tma.interns.roomsharing.dto.roomShareDetail;

import lombok.Builder;
import lombok.Data;
import tma.interns.roomsharing.enumration.ShareRole;

import java.util.UUID;
@Data
@Builder
public class RoomShareCreateDetailDto {
    private UUID roomSharingId;
    private UUID userId;
    private ShareRole role;
}
