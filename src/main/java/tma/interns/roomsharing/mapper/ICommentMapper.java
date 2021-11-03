package tma.interns.roomsharing.mapper;

import org.mapstruct.Mapper;
import tma.interns.roomsharing.dto.comment.CommentDto;
import tma.interns.roomsharing.entity.CommentEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICommentMapper {
    CommentEntity fromCreateToEntity(CommentDto dto);
    CommentDto toBasicDto(CommentEntity commentEntity);
    CommentEntity fromBasicToEntity(CommentDto dto);
    List<CommentDto> toBasicDtos(List<CommentEntity> comment);
}
