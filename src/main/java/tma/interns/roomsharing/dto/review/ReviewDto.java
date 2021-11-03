package tma.interns.roomsharing.dto.review;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ReviewDto {
    private UUID userId;
    private String content;
    private Date date;
    private Integer evaluate;
    private int parentType;
    private UUID parentId;
}
