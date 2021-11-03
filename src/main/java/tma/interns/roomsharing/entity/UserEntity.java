package tma.interns.roomsharing.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import tma.interns.roomsharing.enumration.UserRole;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name= "user_id", columnDefinition = "CHAR(36)")
    @Type(type="uuid-char")
    private UUID userId;
    @Column(name="user_name")
    private String userName;
    private String password;
    private String name;
    private String email;
    private String address;
    @Column(name="number_phone")
    private String phone;
    @Column(name="date_of_birth")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;
    private boolean gender;
    @Column(name="avatar_url")
    private String avatarUrl;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
