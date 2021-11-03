package tma.interns.roomsharing.service.Review;

import org.springframework.stereotype.Service;
import tma.interns.roomsharing.dto.review.ReviewDto;
import tma.interns.roomsharing.dto.review.ReviewUpDto;
import tma.interns.roomsharing.entity.ReviewEntity;
import tma.interns.roomsharing.mapper.IReviewMapper;
import tma.interns.roomsharing.repository.ReviewRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ReviewService implements IReviewService {
    private final ReviewRepository reviewRepo;
    private final IReviewMapper reviewMapper;

    public ReviewService(ReviewRepository reviewRepo, IReviewMapper reviewMapper) {
        this.reviewRepo = reviewRepo;
        this.reviewMapper = reviewMapper;
    }

    /**
     * create review
     *
     * @author tt0411
     * @param review
     * @return new review
     */
    public ReviewDto createReview(ReviewDto review) {
        review.setDate(new Date());
        ReviewEntity reviewEntity = reviewMapper.fromReDtoToReEntity(review);
        //check null
        if(reviewEntity.getEvaluate()==null) throw new IllegalArgumentException ("Evaluate must not be null");
        ReviewEntity returnReview = reviewRepo.save(reviewEntity);
        return reviewMapper.toReDto(returnReview);
    }

    /**
     * update review
     *
     * @author tt0411
     * @param reviewUp
     * @param reviewId
     * @return updated review with new content and evaluate
     */
    public ReviewDto updateReview(ReviewUpDto reviewUp, UUID reviewId) {
        reviewUp.setDate(new Date());
        ReviewEntity oldReview = reviewRepo.findFirstByReviewId(reviewId);
        ReviewEntity reviewEntity = reviewMapper.fromReUpDtoToReEntity(reviewUp);
        reviewEntity.setReviewId(reviewId);
        //check null
        if(reviewEntity.getEvaluate()==null) throw new IllegalArgumentException ("Evaluate must not be null");

        reviewEntity.setReviewId(reviewId);
        reviewEntity.setUserId(oldReview.getUserId());
        reviewEntity.setParentId(oldReview.getParentId());
        reviewEntity.setParentType(oldReview.getParentType());
        ReviewEntity returnReview =reviewRepo.save(reviewEntity);
        return reviewMapper.toReDto(returnReview);
    }

    /**
     * Get review
     *
     * @author tt0411
     * @param reviewId
     * @return a review
     */
    public ReviewDto getById(UUID reviewId) {
        ReviewEntity reviewEntity = reviewRepo.findFirstByReviewId(reviewId);
        if(reviewEntity != null){
            return reviewMapper.toReDto(reviewEntity);
        }
        return null;
    }

    /**
     * list review
     *
     * @author tt0411
     * @return list review
     */
    public List <ReviewDto> listAll(){
        List<ReviewEntity> reviews = reviewRepo.findAll();
        if( reviews.size()>0){
            return reviewMapper.toReviewDto(reviews);
        }
        return new ArrayList<>();
    }

    /**
     * delete a review
     *
     * @author tt0411
     * @param reviewId
     * @return status 200 OK
     */
    public boolean delete(UUID reviewId) {
        ReviewEntity reviewEntity=reviewRepo.findFirstByReviewId(reviewId);
        if(reviewEntity != null){
            reviewRepo.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
