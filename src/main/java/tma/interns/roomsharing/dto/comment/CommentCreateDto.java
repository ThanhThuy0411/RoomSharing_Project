package tma.interns.roomsharing.dto.comment;

import java.util.Date;
import java.util.UUID;

public class CommentCreateDto {
    private String content;
    private UUID userId;
    private UUID reviewId;
    private Date date;
}
