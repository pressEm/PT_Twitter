package vsu.javablog.service.logic.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.javablog.db.repositories.TagRepository;
import vsu.javablog.service.logic.ITagService;
import vsu.javablog.service.mapper.TagMapper;
import vsu.javablog.service.model.TagDto;

@Service
@RequiredArgsConstructor
public class TagService implements ITagService {
    private final TagRepository rep;
    private final TagMapper map;

    @Override
    public TagDto createTag(TagDto dto) {
        return null;
    }

    @Override
    public TagDto findById(Integer id) {
        return null;
    }

    @Override
    public TagDto findByName(String name) {
        return null;
    }
}
