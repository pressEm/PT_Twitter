package vsu.javablog.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vsu.javablog.db.entities.PostEntity;
import vsu.javablog.service.model.PostDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
//    @Mapping(target = "comments", ignore = true)
//    @Mapping(target = "tags", ignore = true)
//    @Mapping(target = "user", ignore = true)
    PostDto fromEntity(PostEntity entity);

//    @Mapping(target = "comments", ignore = true)
//    @Mapping(target = "tags", ignore = true)
//    @Mapping(target = "user", ignore = true)
    PostEntity toEntity(PostDto dto);

    List<PostDto> fromEntities(Iterable<PostEntity> entities);
}
