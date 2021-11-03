package tma.interns.roomsharing.mapper;

import org.mapstruct.Mapper;
import tma.interns.roomsharing.dto.roomshare.RoomSharingDto;
import tma.interns.roomsharing.entity.RoomSharingEntity;

import java.util.List;

@Mapper(componentModel = "spring")

public interface IRoomSharingMapper {
    RoomSharingEntity fromSharingDtoToEntity(RoomSharingDto dto);
    RoomSharingDto toRoomSharingDto(RoomSharingEntity roomSharingEntity);
    List<RoomSharingDto> toRoomSharingDtos (List<RoomSharingEntity> roomSharingEntities);
}
