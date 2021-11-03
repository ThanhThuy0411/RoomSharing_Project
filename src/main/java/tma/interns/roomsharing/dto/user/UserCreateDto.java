package tma.interns.roomsharing.dto.user;

import lombok.Data;
import tma.interns.roomsharing.enumration.UserRole;

import java.util.Date;

@Data
public class UserCreateDto {
    private String userName;
    private String password;
    private String name;
    private String email;
    private String address;
    private String phone;
    private Date birthDate;
    private boolean gender;
    private String avatarUrl;
    private UserRole role;
}
