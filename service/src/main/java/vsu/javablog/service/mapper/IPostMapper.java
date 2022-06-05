package vsu.javablog.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vsu.javablog.db.entities.PostEntity;
import vsu.javablog.service.model.PostDto;

import java.util.List;

public interface IPostMapper {
    PostDto fromEntity(PostEntity entity);

    PostEntity toEntity(PostDto dto);

    List<PostDto> fromEntities(Iterable<PostEntity> entities);
}
