package tma.interns.roomsharing.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "room_sharing")
public class RoomSharingEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name= "room_sharing_id", columnDefinition = "CHAR(36)")
    @Type(type="uuid-char")
    private UUID roomSharingId;
    @Column(name="room_id")
    @Type(type ="uuid-char")
    private UUID roomId;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_sharing_id", referencedColumnName = "room_sharing_id", insertable = false, updatable = false)
    private List<RoomShareDetailEntity> roomShareDetails;
}
