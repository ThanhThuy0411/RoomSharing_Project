package tma.interns.roomsharing.mapper;

import org.mapstruct.Mapper;
import tma.interns.roomsharing.dto.room.RoomInfoBasicDto;
import tma.interns.roomsharing.dto.room.RoomInfoDetailDto;
import tma.interns.roomsharing.dto.room.RoomInfoCreateDto;
import tma.interns.roomsharing.entity.RoomInfoEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRoomInfoMapper {

    RoomInfoEntity fromCreateToEntity(RoomInfoCreateDto dto);
    RoomInfoBasicDto toBasicDto(RoomInfoEntity returnRoom);
    List<RoomInfoBasicDto> toBasicDtos(List<RoomInfoEntity> returnRoom);
    RoomInfoEntity fromBasicToEntity(RoomInfoDetailDto dto);
    RoomInfoDetailDto toDetailDto(RoomInfoEntity returnRoom);
    List<RoomInfoDetailDto> toDetailDtos(List<RoomInfoEntity> roomInfo);
    RoomInfoCreateDto toCreateDto(RoomInfoEntity returnRoom);
}
