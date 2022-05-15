package vsu.javablog.service.logic.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import vsu.javablog.db.repositories.PostRepository;
import vsu.javablog.service.logic.IPostService;
import vsu.javablog.service.mapper.PostMapper;
import vsu.javablog.service.model.PostDto;

import java.util.List;

@Service
@Validated
//@RequiredArgsConstructor
public class PostService implements IPostService {
    private final PostRepository rep;
    private final PostMapper map;

    @Autowired
    public PostService(PostRepository rep, PostMapper map) {
        this.rep = rep;
        this.map = map;
    }

    @Override
    public PostDto createPost(PostDto dto) {
        return null;
    }

    @Override
    public void deletePostById(Integer id) {

    }

    @Override
    public List<PostDto> getAllPosts() {
        return null;
    }

    @Override
    public List<PostDto> getAllPostsByUserId(Integer id) {
        return null;
    }

    @Override
    public List<PostDto> getAllPostsByTagId(Integer id) {
        return null;
    }
}
