package tma.interns.roomsharing.dto.comment;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class CommentDto {
    private UUID commentId;
    private UUID userId;
    private UUID reviewId;
    private String content;
    private Date date;
}
