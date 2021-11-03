package tma.interns.roomsharing.mapper;

import org.mapstruct.Mapper;
import tma.interns.roomsharing.dto.review.ReviewDto;
import tma.interns.roomsharing.dto.review.ReviewUpDto;
import tma.interns.roomsharing.entity.ReviewEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IReviewMapper {
    ReviewEntity fromReDtoToReEntity(ReviewDto dto);
    ReviewDto toReDto (ReviewEntity reviewEntity);
    List<ReviewDto> toReviewDto(List<ReviewEntity> reviews);
    ReviewEntity fromReUpDtoToReEntity (ReviewUpDto upDto);
}
