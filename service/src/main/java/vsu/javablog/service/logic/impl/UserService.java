package vsu.javablog.service.logic.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import vsu.javablog.db.repositories.UserRepository;
import vsu.javablog.service.logic.IUserService;
import vsu.javablog.service.mapper.UserMapper;
import vsu.javablog.service.model.UserDto;

import java.util.List;

@Service
@Validated
//@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository rep;
    private final UserMapper map;

    @Autowired
    public UserService(UserRepository rep, UserMapper map) {
        this.rep = rep;
        this.map = map;
    }

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
