package vsu.javablog.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import vsu.javablog.db.entities.UserEntity;
import vsu.javablog.service.model.UserDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    //@Mapping(target = "role", ignore = true)
    //@Mapping(target = "comments", ignore = true)
//    @Mapping(target = "posts", ignore = true)
    UserDto fromEntity(UserEntity entity);

//    @Mapping(target = "password", ignore = true)
//    @Mapping(target = "role", ignore = true)
//    @Mapping(target = "comments", ignore = true)
//    @Mapping(target = "posts", ignore = true)
    UserEntity toEntity(UserDto dto);

    void merge(UserDto dto, @MappingTarget UserEntity entity);

    List<UserDto> fromEntities(Iterable<UserEntity> entities);
}
