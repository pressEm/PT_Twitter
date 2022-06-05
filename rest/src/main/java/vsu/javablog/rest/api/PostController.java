package vsu.javablog.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vsu.javablog.service.logic.impl.PostService;
import vsu.javablog.service.model.PostDto;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @PostMapping
    public PostDto createPost(@RequestBody PostDto dto){
        return service.createPost(dto);
    }

    @GetMapping
    public List<PostDto> getAllPosts(){
        return service.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostDto getPostById(@PathVariable Integer postId){

    }

    @PutMapping("/{postId}")
    public PostDto updatePostById(Integer postId){
        //Todo: createupdateinpostservice
        return null;
    }

    @DeleteMapping("/{postId}")
    public void deletePostById(@PathVariable Integer postId){
        service.deletePostById(postId);
    }

    @GetMapping("/tag/{tagId}")
    public List<PostDto> getAllPostsByTagId(@PathVariable Integer tagId){
        return service.getAllPostsByTagId(tagId);
    }
}
