package tma.interns.roomsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tma.interns.roomsharing.entity.ReviewEntity;

import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, UUID> {
    ReviewEntity findFirstByReviewId (UUID reviewId);
    ReviewEntity findByParentTypeAndParentId(int parentType,UUID parentId);
    void deleteById (UUID reviewId);
}
