package tma.interns.roomsharing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tma.interns.roomsharing.dto.comment.CommentDto;
import tma.interns.roomsharing.service.comment.ICommentService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class CommentController {
    private final ICommentService commentService;

    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    public ResponseEntity<CommentDto> create(@RequestBody CommentDto newComment) {
        try {
            CommentDto createComment = commentService.createComment(newComment);
            return new ResponseEntity<>(createComment, HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/comment/{commentId}")
    public  ResponseEntity<CommentDto> update(@RequestBody CommentDto comment, @PathVariable UUID commentId){
        try {
            CommentDto updatedComment = commentService.updateComment(comment,commentId);
            return new ResponseEntity<>(updatedComment,HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/comment/{comment_id}")
    public ResponseEntity<CommentDto> get(@PathVariable UUID comment_id){
        try {
            CommentDto comment = commentService.getById(comment_id);
            return new ResponseEntity<>(comment,HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<HttpStatus> delete (@PathVariable UUID commentId){
        try {
            commentService.delete(commentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/comment")
    public ResponseEntity<List<CommentDto>> list() {
        try {
            List<CommentDto> comment = commentService.listAll();
            return new ResponseEntity<>(comment, HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}