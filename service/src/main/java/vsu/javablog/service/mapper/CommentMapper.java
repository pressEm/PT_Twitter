package vsu.javablog.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vsu.javablog.db.entities.CommentEntity;
import vsu.javablog.db.entities.PostEntity;
import vsu.javablog.service.model.CommentDto;
import vsu.javablog.service.model.PostDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
//    @Mapping(target = "postId", ignore = true)
//    @Mapping(target = "userId", ignore = true)
    CommentDto fromEntity(CommentEntity entity);

//    @Mapping(target = "post_id", ignore = true)
//    @Mapping(target = "userId", ignore = true)
    CommentEntity toEntity(CommentDto dto);

    List<CommentDto> fromEntities(Iterable<CommentEntity> entities);
}
