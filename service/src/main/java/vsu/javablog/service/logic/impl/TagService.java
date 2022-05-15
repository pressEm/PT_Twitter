package vsu.javablog.service.logic.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import vsu.javablog.db.entities.TagEntity;
import vsu.javablog.db.repositories.TagRepository;
import vsu.javablog.service.logic.ITagService;
import vsu.javablog.service.mapper.TagMapper;
import vsu.javablog.service.model.TagDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Validated
//@RequiredArgsConstructor
public class TagService implements ITagService {
    private final TagRepository rep;
    private final TagMapper map;

    @Autowired
    public TagService(TagRepository rep, TagMapper map) {
        this.rep = rep;
        this.map = map;
    }

    @Override
    public TagDto createTag(@Valid TagDto dto) {
        return Optional.of(dto)
            .map(map::toEntity)
            .map(rep::save)
            .map(map::fromEntity)
            .orElseThrow();
//        TagEntity e = map.toEntity(dto);
//        rep.save(e);
//        return map.fromEntity(e);
    }

    @Override
    public TagDto findById(Integer id) {
        return rep.findById(id).map(map::fromEntity).orElseThrow();
    }

    @Override
    public TagDto findByName(String name) {
        return map.fromEntity(rep.findByTag(name));
    }

    @Override
    public List<TagDto> getAllTags() {
        return map.fromEntities(rep.findAll());
    }
}
