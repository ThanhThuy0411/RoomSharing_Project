package tma.interns.roomsharing.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import tma.interns.roomsharing.enumration.ShareRole;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name ="room_sharing_detail")
public class RoomShareDetailEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name= "room_sharings_id", columnDefinition = "CHAR(36)")
    @Type(type="uuid-char")
    private UUID roomShareDetailId;
    @Column(name= "room_sharing_id")
    @Type(type="uuid-char")
    private UUID roomSharingId;
    @Column(name="user_id")
    @Type(type="uuid-char")
    private UUID userId;
    @Enumerated(EnumType.STRING)
    private ShareRole role;
}
