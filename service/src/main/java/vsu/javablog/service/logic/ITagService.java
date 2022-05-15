package vsu.javablog.service.logic;

import vsu.javablog.service.model.TagDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface ITagService {
    TagDto createTag(@Valid TagDto dto);

    TagDto findById(@NotNull Integer id);

    TagDto findByName(@NotNull String name);
}
