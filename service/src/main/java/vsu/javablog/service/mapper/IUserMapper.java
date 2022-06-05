package vsu.javablog.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import vsu.javablog.db.entities.UserEntity;
import vsu.javablog.service.model.UserDto;

import java.util.List;

public interface IUserMapper {
    UserDto fromEntity(UserEntity entity);

    UserEntity toEntity(UserDto dto);

    void merge(UserDto dto, @MappingTarget UserEntity entity);

    List<UserDto> fromEntities(Iterable<UserEntity> entities);
}
