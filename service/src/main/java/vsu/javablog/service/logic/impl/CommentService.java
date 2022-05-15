package vsu.javablog.service.logic.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import vsu.javablog.db.repositories.CommentRepository;
import vsu.javablog.service.logic.ICommentService;
import vsu.javablog.service.mapper.CommentMapper;
import vsu.javablog.service.model.CommentDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public CommentDto createComment(@Valid CommentDto dto) {
        return Optional.of(dto)
            .map(map::toEntity)
            .map(rep::save)
            .map(map::fromEntity)
            .orElseThrow();
    }

    @Override
    public CommentDto getCommentById(Integer id) {
        return rep.findById(id)
            .map(map::fromEntity)
            .orElseThrow();
    }

    @Override
    public List<CommentDto> getAllCommentsByUserId(Integer id) {
        return map.fromEntities(rep.findAllByUserId(id));
    }

    @Override
    public List<CommentDto> getAllCommentsByPostId(Integer id) {
        return map.fromEntities(rep.findAllByPostId(id));
    }
}
