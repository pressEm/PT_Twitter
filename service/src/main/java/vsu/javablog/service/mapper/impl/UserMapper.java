package vsu.javablog.service.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import vsu.javablog.db.entities.CommentEntity;
import vsu.javablog.db.entities.PostEntity;
import vsu.javablog.db.entities.RoleEntity;
import vsu.javablog.db.entities.UserEntity;
import vsu.javablog.db.repositories.RoleRepository;
import vsu.javablog.service.mapper.IUserMapper;
import vsu.javablog.service.model.CommentDto;
import vsu.javablog.service.model.PostDto;
import vsu.javablog.service.model.UserDto;

import java.util.LinkedList;
import java.util.List;

@Component
public class UserMapper implements IUserMapper {
    private final PostMapper pM;
    private final CommentMapper cM;

    @Autowired
    public UserMapper(PostMapper pM, CommentMapper cM) {
        this.pM = pM;
        this.cM = cM;
    }

    @Override
    public UserDto fromEntity(UserEntity entity) {
        if(entity == null){
            return null;
        }
        UserDto dto = new UserDto();
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());

        List<PostDto> posts = new LinkedList<>();
        List<CommentDto> comments = new LinkedList<>();
        List<PostDto> likedPosts = new LinkedList<>();

        for (PostEntity p :
            entity.getPosts()) {
            PostDto dto1 =pM.fromEntity(p);
            dto1.setPostId(p.getId());
            posts.add(dto1);
        }

        for (CommentEntity c :
            entity.getComments()) {
            comments.add(cM.fromEntity(c));
        }
        for (PostEntity p :
            entity.getLikedPosts()) {
            likedPosts.add(pM.fromEntity(p));
        }

        dto.setPosts(posts);
        dto.setComments(comments);
        dto.setLikedPosts(likedPosts);

        return dto;
    }

    @Override
    public UserEntity toEntity(UserDto dto) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(dto == null){
            return null;
        }

        UserEntity e = new UserEntity();

        e.setUsername(dto.getUsername());
        e.setEmail(dto.getEmail());
        e.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));

        List<PostEntity> posts = new LinkedList<>();
        List<CommentEntity> comments = new LinkedList<>();
        List<PostEntity> likedPosts = new LinkedList<>();

        for (PostDto p :
            dto.getPosts()) {
            posts.add(pM.toEntity(p));
        }

        for (CommentDto c :
            dto.getComments()) {
            comments.add(cM.toEntity(c));
        }

        for (PostDto p :
            dto.getLikedPosts()) {
            likedPosts.add(pM.toEntity(p));
        }

        e.setPosts(posts);
        e.setComments(comments);
        e.setLikedPosts(likedPosts);

        return e;
    }

    @Override
    public void merge(UserDto dto, UserEntity entity) {
        if (dto != null || entity != null){
            assert dto != null;
            if (!entity.getUsername().equals(dto.getUsername()))
                entity.setUsername(dto.getUsername());

            if(!entity.getEmail().equals(dto.getEmail()))
                entity.setEmail(dto.getEmail());

            if(!entity.getPassword().equals(dto.getPassword()))
                entity.setPassword(dto.getPassword());

            UserEntity e = toEntity(dto);
            if (!e.getComments().equals(entity.getComments()))
                entity.setComments(e.getComments());

            if (!e.getPosts().equals(entity.getPosts()))
                entity.setPosts(e.getPosts());

            if(!e.getLikedPosts().equals(entity.getLikedPosts()))
                entity.setLikedPosts(e.getLikedPosts());
        }
    }

    @Override
    public List<UserDto> fromEntities(Iterable<UserEntity> entities) {
        List<UserDto> result = new LinkedList<>();
        for (UserEntity e :
            entities) {
            result.add(fromEntity(e));
        }
        return result;
    }
}
