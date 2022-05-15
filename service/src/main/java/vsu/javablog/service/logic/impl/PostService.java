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
import java.util.Optional;

@Service
//@Validated
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
        return Optional.of(dto)
            .map(map::toEntity)
            .map(rep::save)
            .map(map::fromEntity)
            .orElseThrow();
    }

    @Override
    public void deletePostById(Integer id) {
        rep.deleteById(id);
    }

    @Override
    public List<PostDto> getAllPosts() {
        return map.fromEntities(rep.findAll());
    }

    @Override
    public List<PostDto> getAllPostsByUserId(Integer id) {
        return map.fromEntities(rep.findAllByUserId(id));
    }

    @Override
    public List<PostDto> getAllPostsByTagId(Integer id) {
        return map.fromEntities(rep.findAllPostsByTagId(id));
    }
}
