package vsu.javablog.service.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vsu.javablog.db.entities.CommentEntity;
import vsu.javablog.db.entities.PostEntity;
import vsu.javablog.db.entities.TagEntity;
import vsu.javablog.db.entities.UserEntity;
import vsu.javablog.db.repositories.UserRepository;
import vsu.javablog.service.mapper.IPostMapper;
import vsu.javablog.service.model.CommentDto;
import vsu.javablog.service.model.PostDto;
import vsu.javablog.service.model.TagDto;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
public class PostMapper implements IPostMapper {
    private final CommentMapper cM;
    private final TagMapper tM;
    private final UserRepository rep;

    @Autowired
    public PostMapper(CommentMapper cM, TagMapper tM, UserRepository rep) {
        this.cM = cM;
        this.tM = tM;
        this.rep = rep;
    }

    @Override
    public PostDto fromEntity(PostEntity entity) {
        if (entity == null)
            return null;
        PostDto dto = new PostDto();

        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setUserId(entity.getUser().getId());

        if (entity.getTags()!=null){
            List<TagDto> tags = new LinkedList<>();
            for (TagEntity e :
                entity.getTags()) {
                tags.add(tM.fromEntity(e));
            }
            dto.setTags(tags);
        }

        if (entity.getComments()!=null){
            List<CommentDto> comments = new LinkedList<>();
            for (CommentEntity e :
                entity.getComments()) {
                comments.add(cM.fromEntity(e));
            }
            dto.setComments(comments);
        }
        return dto;
    }

    @Override
    public PostEntity toEntity(PostDto dto) {
        if (dto == null)
            return null;

        PostEntity e = new PostEntity();

        e.setContent(dto.getContent());
        e.setTitle(dto.getTitle());

        UserEntity user = rep.getById(dto.getUserId());
        e.setUser(user);

        if (dto.getTags() != null) {
            List<TagEntity> tags = new LinkedList<>();
            for (TagDto t :
                dto.getTags()) {
                tags.add(tM.toEntity(t));
            }
            e.setTags(tags);
        }
        if (dto.getComments() != null) {
            Set<CommentEntity> comments = new HashSet<>();
            for (CommentDto c :
                dto.getComments()) {
                comments.add(cM.toEntity(c));
            }
            e.setComments(comments);
        }
        return e;
    }

    @Override
    public List<PostDto> fromEntities(Iterable<PostEntity> entities) {
        List<PostDto> l = new LinkedList<>();
        for (PostEntity e :
            entities) {
            l.add(fromEntity(e));
        }

        return l;
    }
}
