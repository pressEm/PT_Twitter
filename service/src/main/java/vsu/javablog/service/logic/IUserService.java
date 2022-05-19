package vsu.javablog.service.logic;

import org.springframework.security.core.userdetails.UserDetailsService;
import vsu.javablog.service.model.UserDto;

import javax.validation.Valid;
import java.util.List;

public interface IUserService{
    UserDto createUser(@Valid UserDto dto);

    void updateUser(@Valid UserDto dto, Integer id);

    UserDto getUserById(Integer id);

    void deleteUserById(Integer id);

    List<UserDto> getAllUSers();
}
