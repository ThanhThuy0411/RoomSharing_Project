package tma.interns.roomsharing.dto.user;

import lombok.Data;

import java.util.UUID;

@Data
public class UserInfoDto {
    private UUID userId;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String token;
}
