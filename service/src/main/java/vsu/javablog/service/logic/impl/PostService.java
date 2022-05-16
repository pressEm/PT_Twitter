package vsu.javablog.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsu.javablog.db.repositories.PostRepository;
import vsu.javablog.db.repositories.UserRepository;
import vsu.javablog.service.logic.IPostService;
import vsu.javablog.service.mapper.IPostMapper;
import vsu.javablog.service.mapper.impl.CommentMapper;
import vsu.javablog.service.mapper.impl.PostMapper;
import vsu.javablog.service.mapper.impl.TagMapper;
import vsu.javablog.service.model.PostDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
//@Validated
//@RequiredArgsConstructor
public class PostService implements IPostService {
    private final PostRepository rep;
    private final IPostMapper map;

    @Autowired
    public PostService(PostRepository rep, UserRepository uR) {
        this.rep = rep;
        this.map = new PostMapper(new CommentMapper(uR, rep), new TagMapper(), uR);
    }

    @Override
    public PostDto createPost(@Valid PostDto dto) {
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
