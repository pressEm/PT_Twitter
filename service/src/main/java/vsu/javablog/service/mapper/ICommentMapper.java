package vsu.javablog.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vsu.javablog.db.entities.CommentEntity;
import vsu.javablog.db.entities.PostEntity;
import vsu.javablog.service.model.CommentDto;
import vsu.javablog.service.model.PostDto;

import java.util.List;

public interface ICommentMapper {
    CommentDto fromEntity(CommentEntity entity);

    CommentEntity toEntity(CommentDto dto);

    List<CommentDto> fromEntities(Iterable<CommentEntity> entities);
}
