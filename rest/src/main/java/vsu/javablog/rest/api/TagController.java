package vsu.javablog.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vsu.javablog.service.logic.impl.TagService;
import vsu.javablog.service.model.TagDto;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    private final TagService service;

    @Autowired
    public TagController(TagService service) {
        this.service = service;
    }

    @GetMapping
    public List<TagDto> getAllTags(){
        return service.getAllTags();
    }
}
