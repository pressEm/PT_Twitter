package vsu.javablog.service.logic.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.javablog.db.repositories.UserRepository;
import vsu.javablog.service.logic.IUserService;
import vsu.javablog.service.mapper.UserMapper;
import vsu.javablog.service.model.UserDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository rep;
    private final UserMapper map;

    @Override
    public UserDto createUser(UserDto dto) {
        return null;
    }

    @Override
    public void updateUser(UserDto dto, Integer id) {

    }

    @Override
    public UserDto getUserById(Integer id) {
        return null;
    }

    @Override
    public void deleteUserById(Integer id) {

    }

    @Override
    public List<UserDto> getAllUSers() {
        return null;
    }
}
