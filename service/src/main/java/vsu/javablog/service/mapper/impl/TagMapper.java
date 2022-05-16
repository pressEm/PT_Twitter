package vsu.javablog.service.mapper.impl;

import vsu.javablog.db.entities.TagEntity;
import vsu.javablog.service.mapper.ITagMapper;
import vsu.javablog.service.model.TagDto;

import java.util.List;

public class TagMapper implements ITagMapper {
    @Override
    public TagDto fromEntity(TagEntity entity) {
        return null;
    }

    @Override
    public TagEntity toEntity(TagDto dto) {
        return null;
    }

    @Override
    public List<TagDto> fromEntities(Iterable<TagEntity> entities) {
        return null;
    }
}
