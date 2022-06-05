package vsu.javablog.service.mapper.impl;

import org.springframework.stereotype.Component;
import vsu.javablog.db.entities.TagEntity;
import vsu.javablog.service.mapper.ITagMapper;
import vsu.javablog.service.model.TagDto;

import java.util.LinkedList;
import java.util.List;

@Component
public class TagMapper implements ITagMapper {
    public TagMapper() {
    }

    @Override
    public TagDto fromEntity(TagEntity entity) {
        if (entity == null)
            return null;
        TagDto dto = new TagDto();
        dto.setTag(entity.getTag());
        return dto;
    }

    @Override
    public TagEntity toEntity(TagDto dto) {
        if (dto == null)
            return null;
        TagEntity e = new TagEntity();
        e.setTag(dto.getTag());
        e.setId(dto.getId());
        return e;
    }

    @Override
    public List<TagDto> fromEntities(Iterable<TagEntity> entities) {
        if (entities == null)
            return null;

        List<TagDto> l = new LinkedList<>();
        for (TagEntity e :
            entities) {
            if (e == null)
                l.add(null);
            else
                l.add(fromEntity(e));
        }
        return l;
    }
}
