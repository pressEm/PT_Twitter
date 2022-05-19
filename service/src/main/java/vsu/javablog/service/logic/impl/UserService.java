package vsu.javablog.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import vsu.javablog.db.entities.RoleEntity;
import vsu.javablog.db.entities.UserEntity;
import vsu.javablog.db.repositories.PostRepository;
import vsu.javablog.db.repositories.RoleRepository;
import vsu.javablog.db.repositories.UserRepository;
import vsu.javablog.service.logic.IUserService;
import vsu.javablog.service.mapper.IUserMapper;
import vsu.javablog.service.mapper.impl.CommentMapper;
import vsu.javablog.service.mapper.impl.PostMapper;
import vsu.javablog.service.mapper.impl.TagMapper;
import vsu.javablog.service.mapper.impl.UserMapper;
import vsu.javablog.service.model.UserDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Validated
//@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository rep;
    private final IUserMapper map;
    private final RoleRepository roleRepository;


    @Autowired
    public UserService(UserRepository rep, PostRepository pR, RoleRepository repository) {//, UserMapper map) {
        this.rep = rep;
        this.roleRepository = repository;
        CommentMapper m = new CommentMapper(rep, pR);
        this.map = new UserMapper(new PostMapper(m, new TagMapper(), rep),
            m);
    }

    @Override
    public UserDto createUser(UserDto dto) {
        UserEntity entity = map.toEntity(dto);
        RoleEntity role = roleRepository.findById(2);
        entity.setRole(role);
        rep.save(entity);
        return dto;
//        entity.setId(2);
//        return Optional.of(dto)
//            .map(map::toEntity)
//            .map(rep::save)
//            .map(map::fromEntity)
//            .orElseThrow();
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

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserEntity user = rep.findByUsername(username);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return user;
//    }
}
