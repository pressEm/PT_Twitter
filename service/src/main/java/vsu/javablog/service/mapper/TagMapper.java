package vsu.javablog.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vsu.javablog.db.entities.TagEntity;
import vsu.javablog.service.model.TagDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagDto fromEntity(TagEntity entity);

    TagEntity toEntity(TagDto dto);

    List<TagDto> fromEntities(Iterable<TagEntity> entities);
}
