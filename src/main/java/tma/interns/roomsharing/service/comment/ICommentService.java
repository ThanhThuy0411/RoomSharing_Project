package tma.interns.roomsharing.service.comment;

import tma.interns.roomsharing.dto.comment.CommentDto;

import java.util.List;
import java.util.UUID;

public interface ICommentService {
    CommentDto createComment (CommentDto comment);
    CommentDto updateComment (CommentDto comment, UUID comment_id);
    CommentDto getById (UUID comment_id);
    boolean delete(UUID comment_id);
    List<CommentDto> listAll();
}
