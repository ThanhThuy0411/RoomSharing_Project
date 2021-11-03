package tma.interns.roomsharing.service.user;

import org.springframework.security.core.userdetails.UserDetails;
import tma.interns.roomsharing.dto.authentication.AuthenticationRequestDto;
import tma.interns.roomsharing.dto.user.UserBasicDto;
import tma.interns.roomsharing.dto.user.UserCreateDto;
import tma.interns.roomsharing.dto.user.UserInfoDto;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    UserBasicDto createUser(UserCreateDto user) throws Exception;
    UserBasicDto getById(UUID userId);
    boolean delete(UUID userId);
    UserBasicDto updateUser(UserBasicDto dto, UUID userId) throws Exception;
    List<UserBasicDto> listAll();
    UserInfoDto login(AuthenticationRequestDto authenticationRequestDto);
    UserDetails loadUserByUsername(String userName);
}
