package vsu.javablog.service.logic.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import vsu.javablog.db.entities.UserEntity;
import vsu.javablog.db.repositories.UserRepository;
import vsu.javablog.service.logic.IUserService;
import vsu.javablog.service.mapper.UserMapper;
import vsu.javablog.service.model.UserDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public UserDto createUser(@Valid UserDto dto) {
        return Optional.of(dto)
            .map(map::toEntity)
            .map(rep::save)
            .map(map::fromEntity)
            .orElseThrow();
    }

    @Override
    public void updateUser(UserDto dto, Integer id) {
        UserEntity e = rep.findById(id).orElseThrow();
        map.merge(dto, e);
        rep.save(e);
    }

    @Override
    public UserDto getUserById(Integer id) {
        return rep.findById(id)
            .map(map::fromEntity)
            .orElseThrow();
    }

    @Override
    public void deleteUserById(Integer id) {
        rep.deleteById(id);
    }

    @Override
    public List<UserDto> getAllUSers() {
        return map.fromEntities(rep.findAll());
    }
}
