package tma.interns.roomsharing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tma.interns.roomsharing.dto.review.ReviewDto;
import tma.interns.roomsharing.dto.review.ReviewUpDto;
import tma.interns.roomsharing.service.Review.IReviewService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class ReviewController {
    private final IReviewService reviewService;

    public ReviewController(IReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/review")
    public ResponseEntity<ReviewDto> create (@RequestBody ReviewDto newReview) throws Exception {
        try {
            ReviewDto createdReview = reviewService.createReview(newReview);
            return new ResponseEntity<>(createdReview, HttpStatus.OK);
        }catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/review/{reviewId}")
    public ResponseEntity<ReviewDto> update (@RequestBody ReviewUpDto review, @PathVariable UUID reviewId) throws Exception {
        try {
            ReviewDto updatedRe = reviewService.updateReview(review,reviewId);
            return new ResponseEntity<>(updatedRe,HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("review/{reviewId}")
    public ResponseEntity<ReviewDto> get(@PathVariable UUID reviewId){
        try {
            ReviewDto rv = reviewService.getById(reviewId);
            return new ResponseEntity<>(rv,HttpStatus.OK);
        }catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("review")
    public ResponseEntity<List<ReviewDto>> list(){
        try {
            List<ReviewDto> reviews = reviewService.listAll();
            return new ResponseEntity<>(reviews,HttpStatus.OK);
        }catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping ("review/{reviewId}")
    public ResponseEntity<HttpStatus> delete (@PathVariable UUID reviewId){
        try {
            reviewService.delete(reviewId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
