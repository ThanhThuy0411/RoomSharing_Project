package tma.interns.roomsharing.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import tma.interns.roomsharing.enumration.RoomType;
import tma.interns.roomsharing.enumration.StatusType;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name ="rental_home")
public class RoomInfoEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name= "room_id", columnDefinition = "CHAR(36)")
    @Type(type="uuid-char")
    private UUID roomId;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Column(name="user_id")
    @Type(type="uuid-char")
    private UUID userId;

    @Column(name="province_id")
    @Type(type="uuid-char")
    private UUID provinceId;

    @Column(name="district_id")
    @Type(type="uuid-char")
    private UUID districtId;

    @Column(name= "ward_id")
    @Type(type="uuid-char")
    private UUID wardId;

    private String address;

    private Float acreage;

    @Column(name= "room_price")
    private Integer roomPrice = 0;

    private String roomDescribe;

    private String title;

    @Column(name= "statusHired")
    @Enumerated(EnumType.STRING)
    private StatusType statusHired;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user;
    @Transient
    private List<FileEntity> files;
}
