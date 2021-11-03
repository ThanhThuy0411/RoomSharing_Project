package tma.interns.roomsharing.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "review")
public class ReviewEntity{
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name= "review_Id", columnDefinition = "CHAR(36)")
    @Type(type="uuid-char")
    private UUID reviewId;

    @Column(name="user_id")
    @Type(type="uuid-char")
    private UUID userId;
    private String content;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private Integer evaluate;
    @Column(name = "parent_type")
    private int parentType;
    @Column(name="parent_id")
    @Type(type="uuid-char")
    private UUID parentId;
}
