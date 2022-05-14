package vsu.javablog.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import vsu.javablog.db.entities.PostEntity;
import vsu.javablog.db.entities.TagEntity;
import vsu.javablog.db.entities.UserEntity;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

public interface PostRepository  extends CrudRepository<PostEntity, Integer>, JpaRepository<PostEntity, Integer>, JpaSpecificationExecutor<PostEntity> {
    List<PostEntity> findAllByTags(Set<TagEntity> tags);
    PostEntity findByTitle(@NotEmpty(message = "Title can not be empty") String title);
    List<PostEntity> findByUser(UserEntity user);
}