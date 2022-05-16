package vsu.javablog.service.mapper.impl;

import vsu.javablog.db.entities.PostEntity;
import vsu.javablog.service.mapper.IPostMapper;
import vsu.javablog.service.model.PostDto;

import java.util.List;

public class PostMapper implements IPostMapper {
    @Override
    public PostDto fromEntity(PostEntity entity) {
        PostDto dto = new PostDto();
        return null;
    }

    @Override
    public PostEntity toEntity(PostDto dto) {
        return null;
    }

    @Override
    public List<PostDto> fromEntities(Iterable<PostEntity> entities) {
        return null;
    }
}
