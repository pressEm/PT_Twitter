package vsu.javablog.service.logic;

import vsu.javablog.service.model.CommentDto;

import javax.validation.Valid;
import java.util.List;

public interface ICommentService {
    CommentDto createComment(@Valid CommentDto dto);

    CommentDto getCommentById(Integer id);

    List<CommentDto> getAllCommentsByUserId(Integer id);

    List<CommentDto> getAllCommentsByPostId(Integer id);
}
