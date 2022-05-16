package vsu.javablog.service.mapper.impl;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import vsu.javablog.db.entities.CommentEntity;
import vsu.javablog.db.entities.PostEntity;
import vsu.javablog.db.entities.UserEntity;
import vsu.javablog.db.repositories.PostRepository;
import vsu.javablog.db.repositories.UserRepository;
import vsu.javablog.service.mapper.ICommentMapper;
import vsu.javablog.service.model.CommentDto;

import javax.annotation.ManagedBean;
import java.util.LinkedList;
import java.util.List;

@Component
public class CommentMapper implements ICommentMapper {
    private final UserRepository uR;
    private final PostRepository pR;

    @Autowired
    public CommentMapper(UserRepository uR, PostRepository pR) {
        this.uR = uR;
        this.pR = pR;
    }

    @Override
    public CommentDto fromEntity(CommentEntity entity) {
        if (entity == null)
            return null;

        CommentDto dto = new CommentDto();

        dto.setUserId(entity.getUser().getId());
        dto.setPostId(entity.getPost().getId());
        dto.setContent(entity.getContent());
        dto.setDate(entity.getDate());

        return dto;
    }

    @Override
    public CommentEntity toEntity(CommentDto dto) {
        if (dto == null)
            return null;

        CommentEntity e = new CommentEntity();
        e.setContent(dto.getContent());
        e.setDate(dto.getDate());

        UserEntity user = uR.getById(dto.getUserId());
        e.setUser(user);

        PostEntity post = pR.getById(dto.getPostId());
        e.setPost(post);

        return e;
    }

    @Override
    public List<CommentDto> fromEntities(Iterable<CommentEntity> entities) {
        List<CommentDto> l = new LinkedList<>();

        for (CommentEntity e :
            entities) {
            l.add(fromEntity(e));
        }
        return l;
    }
}
