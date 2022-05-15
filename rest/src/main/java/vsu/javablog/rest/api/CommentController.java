package vsu.javablog.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import vsu.javablog.service.logic.impl.CommentService;
import vsu.javablog.service.model.CommentDto;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService service;
//todo: внести изменения в сваггер
    @Autowired
    public CommentController(CommentService service) {
        this.service = service;
    }

    @PostMapping()
    public CommentDto createComment(@RequestBody CommentDto dto){
        return service.createComment(dto);
    }

    @GetMapping("/{commId}")
    public CommentDto getCommById(@PathVariable Integer commId){
        return service.getCommentById(commId);
    }
}
