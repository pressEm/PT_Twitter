package vsu.javablog.service.mapper.impl;

import vsu.javablog.db.entities.TagEntity;
import vsu.javablog.service.mapper.ITagMapper;
import vsu.javablog.service.model.TagDto;

import java.util.LinkedList;
import java.util.List;

public class TagMapper implements ITagMapper {
    @Override
    public TagDto fromEntity(TagEntity entity) {
        TagDto dto = new TagDto();
        dto.setTag(entity.getTag());
        return dto;
    }

    @Override
    public TagEntity toEntity(TagDto dto) {
        TagEntity e = new TagEntity();
        e.setTag(dto.getTag());
        return e;
    }

    @Override
    public List<TagDto> fromEntities(Iterable<TagEntity> entities) {
        List<TagDto> l = new LinkedList<>();
        for (TagEntity e :
            entities) {
            l.add(fromEntity(e));
        }
        return l;
    }
}
