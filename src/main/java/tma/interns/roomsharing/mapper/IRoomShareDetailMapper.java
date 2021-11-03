package tma.interns.roomsharing.mapper;

import org.mapstruct.Mapper;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareCreateDetailDto;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareDetailDto;
import tma.interns.roomsharing.entity.RoomShareDetailEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRoomShareDetailMapper {
    RoomShareDetailEntity fromCreateDtoToEntity (RoomShareCreateDetailDto roomShareCreateDetailDto);
    RoomShareDetailDto toDetailDto (RoomShareDetailEntity roomShareDetailEntity);
    List<RoomShareDetailDto> toDetailDtos(List<RoomShareDetailEntity> roomShareDetailEntities);
}
