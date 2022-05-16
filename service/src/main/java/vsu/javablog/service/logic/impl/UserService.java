package vsu.javablog.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import vsu.javablog.db.entities.UserEntity;
import vsu.javablog.db.repositories.PostRepository;
import vsu.javablog.db.repositories.UserRepository;
import vsu.javablog.service.logic.IUserService;
import vsu.javablog.service.mapper.IUserMapper;
import vsu.javablog.service.mapper.impl.CommentMapper;
import vsu.javablog.service.mapper.impl.PostMapper;
import vsu.javablog.service.mapper.impl.TagMapper;
import vsu.javablog.service.mapper.impl.UserMapper;
import vsu.javablog.service.model.UserDto;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Validated
//@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository rep;
    private final IUserMapper map;

    @Autowired
    public UserService(UserRepository rep, PostRepository pR) {//, UserMapper map) {
        this.rep = rep;
        CommentMapper m = new CommentMapper(rep, pR);
        this.map = new UserMapper(new PostMapper(m, new TagMapper(), rep),
            m);
    }

    @Override
    public UserDto createUser(@Valid UserDto dto) {
        return Optional.of(dto)
            .map(map::toEntity)
            .map(rep::save)
            .map(map::fromEntity)
            .orElseThrow();
        //return null;
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
//        return null;
    }

    @Override
    public void deleteUserById(Integer id) {
        rep.deleteById(id);
    }

    @Override
    public List<UserDto> getAllUSers() {
//        List<UserEntity> l = rep.findAll();
//        List<UserDto> dtos = new LinkedList<>();
//        for (UserEntity e :
//            l) {
//            UserDto dto = new UserDto();
//
//            dto.setUsername(e.getUsername());
//            dto.setEmail(e.getEmail());
//            dto.setPassword(e.getPassword());
////            List<PostEntity> posts= e.getPosts();
////            List<CommentEntity> comments = e.getComments();
//            dtos.add(dto);
//        }

        return map.fromEntities(rep.findAll());
//        return dtos;
    }
}
