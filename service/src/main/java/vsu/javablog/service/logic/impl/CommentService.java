package vsu.javablog.service.logic.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import vsu.javablog.db.repositories.CommentRepository;
import vsu.javablog.service.logic.ICommentService;
import vsu.javablog.service.mapper.CommentMapper;
import vsu.javablog.service.model.CommentDto;

import java.util.List;

@Service
@Validated
//@RequiredArgsConstructor
public class CommentService implements ICommentService {
    private final CommentRepository rep;
    private final CommentMapper map;

    @Autowired
    public CommentService(CommentRepository rep, CommentMapper map) {
        this.rep = rep;
        this.map = map;
    }

    @Override
    public CommentDto createComment(CommentDto dto) {
        //return map.fromEntity(rep.save(map.toEntity(dto)));
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
