package tma.interns.roomsharing.dto.review;

import lombok.Data;

import java.util.Date;

@Data
public class ReviewUpDto {
        private String content;
        private Date Date;
        private Integer evaluate;
}
