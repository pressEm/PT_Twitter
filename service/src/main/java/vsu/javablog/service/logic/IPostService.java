package vsu.javablog.service.logic;

import vsu.javablog.service.model.PostDto;

import javax.validation.Valid;
import java.util.List;

public interface IPostService {
    PostDto createPost(@Valid PostDto dto);

    void deletePostById(Integer id);

    List<PostDto> getAllPosts();

    List<PostDto> getAllPostsByUserId(Integer id);

    List<PostDto> getAllPostsByTagId(Integer id);
}
