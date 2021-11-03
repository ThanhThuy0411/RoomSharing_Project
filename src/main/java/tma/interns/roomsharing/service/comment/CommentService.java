package tma.interns.roomsharing.service.comment;

import org.springframework.stereotype.Service;
import tma.interns.roomsharing.dto.comment.CommentDto;
import tma.interns.roomsharing.entity.CommentEntity;
import tma.interns.roomsharing.mapper.ICommentMapper;
import tma.interns.roomsharing.repository.CommentRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CommentService implements ICommentService{
    private final CommentRepository commentRepo;
    private final ICommentMapper commentMapper;
    public CommentService(CommentRepository commentRepo, ICommentMapper commentMapper) {
        this.commentRepo = commentRepo;
        this.commentMapper = commentMapper;
    }
    @Override
    public CommentDto createComment (CommentDto comment){
        CommentEntity commentEntity = commentMapper.fromCreateToEntity(comment);
        if(commentEntity.getContent()==null)
            throw new IllegalArgumentException("Content must not be null");
        CommentEntity returnComment = commentRepo.save(commentEntity);
        return commentMapper.toBasicDto(returnComment);
    }
    @Override
    public CommentDto updateComment (CommentDto commentDto, UUID commentID){
        CommentEntity commentEntity = commentMapper.fromBasicToEntity(commentDto);
        if(commentEntity.getContent()==null)
            throw new IllegalArgumentException("Content must not be null");
        commentEntity.setCommentId(commentID);
        CommentEntity returnComment = commentRepo.save(commentEntity);
        return commentMapper.toBasicDto(returnComment);
    }
    @Override
    public boolean delete(UUID commentId) {
        CommentEntity commentEntity = commentRepo.findFirstByCommentId(commentId);
        if(commentEntity != null){
            commentRepo.deleteById(commentId);
            return true;
        }
        return false;
    }

    @Override
    public List<CommentDto> listAll() {
        List<CommentEntity> comment = commentRepo.findAll();
        if(comment != null && comment.size() >0){
            return commentMapper.toBasicDtos(comment);
        }
        return new ArrayList<>();
    }

    @Override
    public CommentDto getById (UUID comment_id){
        CommentEntity commentEntity = commentRepo.findFirstByCommentId(comment_id);
        if(commentEntity != null){
            return commentMapper.toBasicDto(commentEntity);
        }
        return  null;
    }



}