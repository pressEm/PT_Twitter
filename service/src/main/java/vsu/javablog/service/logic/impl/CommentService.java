package vsu.javablog.service.logic.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.javablog.db.repositories.CommentRepository;
import vsu.javablog.service.logic.ICommentService;
import vsu.javablog.service.mapper.CommentMapper;
import vsu.javablog.service.model.CommentDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentService {
    private final CommentRepository rep;
    private final CommentMapper map;

    @Override
    public CommentDto createComment(CommentDto dto) {
        return null;
    }

    @Override
    public CommentDto getCommentById(Integer id) {
        return null;
    }

    @Override
    public List<CommentDto> getAllCommentsByUserId() {
        return null;
    }

    @Override
    public List<CommentDto> getAllCommentsByPostId() {
        return null;
    }
}
