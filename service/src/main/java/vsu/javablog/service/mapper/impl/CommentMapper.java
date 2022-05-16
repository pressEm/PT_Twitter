package vsu.javablog.service.mapper.impl;

import vsu.javablog.db.entities.CommentEntity;
import vsu.javablog.service.mapper.ICommentMapper;
import vsu.javablog.service.model.CommentDto;

import java.util.List;

public class CommentMapper implements ICommentMapper {
    @Override
    public CommentDto fromEntity(CommentEntity entity) {
        return null;
    }

    @Override
    public CommentEntity toEntity(CommentDto dto) {
        return null;
    }

    @Override
    public List<CommentDto> fromEntities(Iterable<CommentEntity> entities) {
        return null;
    }
}
