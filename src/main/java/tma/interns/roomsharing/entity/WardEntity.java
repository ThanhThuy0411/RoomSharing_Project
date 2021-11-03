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
@Table(name = "ward")
public class WardEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name= "ward_id", columnDefinition = "CHAR(36)")
    @Type(type="uuid-char")
    private UUID wardId;
    @Column(name="district_id")
    private UUID districtId;
    private String name;

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "ward_id", referencedColumnName = "ward_id", insertable = false, updatable = false)
//    private List<RoomInfoEntity> listRoomInfo;
}
