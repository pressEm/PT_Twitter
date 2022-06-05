package vsu.javablog.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsu.javablog.db.entities.PostEntity;
import vsu.javablog.db.entities.TagEntity;
import vsu.javablog.db.repositories.CommentRepository;
import vsu.javablog.db.repositories.PostRepository;
import vsu.javablog.db.repositories.TagRepository;
import vsu.javablog.db.repositories.UserRepository;
import vsu.javablog.service.logic.IPostService;
import vsu.javablog.service.mapper.IPostMapper;
import vsu.javablog.service.mapper.impl.CommentMapper;
import vsu.javablog.service.mapper.impl.PostMapper;
import vsu.javablog.service.mapper.impl.TagMapper;
import vsu.javablog.service.model.PostDto;
import vsu.javablog.service.model.TagDto;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@Service
//@Validated
//@RequiredArgsConstructor
public class PostService implements IPostService {
    private final PostRepository rep;
    private final IPostMapper map;
    private final TagRepository tRep;
    private final CommentRepository cRep;
    private final UserRepository uRep;

    @Autowired
    public PostService(PostRepository rep, UserRepository uR, TagRepository tRep, CommentRepository cRep, UserRepository uRep) {
        this.rep = rep;
        this.tRep = tRep;
        this.cRep = cRep;
        this.uRep = uRep;
        this.map = new PostMapper(new CommentMapper(uR, rep), new TagMapper(), uR);
    }

    @Override
    public PostDto createPost(@Valid PostDto dto) {
        PostEntity e = map.toEntity(dto);

        List<TagEntity> tags = new LinkedList<>();
        for (TagDto t :
            dto.getTags()) {
            TagEntity entity = tRep.findByTag(t.getTag());
            tags.add(entity);
        }
        rep.save(e);
        return dto;
    }

    @Override
    public void deletePostById(Integer id) {
        rep.deleteById(id);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<PostDto> l = new LinkedList<>();
        for (PostEntity e :
            rep.findAll()) {
            PostDto dto = map.fromEntity(e);
            dto.setPostId(e.getId());
            l.add(dto);
        }
        return l;
    }

    @Override
    public List<PostDto> getAllPostsByUserId(Integer id) {
        List<PostEntity> l = rep.findAllByUserId(id);
        List<PostDto> res = new LinkedList<>();
        for (PostEntity entity:
             l) {
            PostDto dto = map.fromEntity(entity);
            dto.setPostId(entity.getId());
            res.add(dto);
        }
        return res;
//        return map.fromEntities(rep.findAllByUserId(id));
    }

    @Override
    public List<PostDto> getAllPostsByTagId(Integer id) {
//        return map.fromEntities(rep.findAllPostsByTagId(id));
        List<PostEntity> l = rep.findAllPostsByTagId(id);
        List<PostDto> res = new LinkedList<>();
        for (PostEntity entity:
            l) {
            PostDto dto = map.fromEntity(entity);
            dto.setPostId(entity.getId());
            res.add(dto);
        }
        return res;
    }

    @Override
    public PostDto getPost(Integer postId) {
        PostEntity e = rep.getById(postId);
        PostDto dto = map.fromEntity(e);
        dto.setPostId(e.getId());
        return dto;
    }
}
