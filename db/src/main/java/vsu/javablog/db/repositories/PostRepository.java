package vsu.javablog.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vsu.javablog.db.entities.PostEntity;
import vsu.javablog.db.entities.TagEntity;
import vsu.javablog.db.entities.UserEntity;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Integer>, JpaRepository<PostEntity, Integer>, JpaSpecificationExecutor<PostEntity> {
    //List<PostEntity> findAllByTags(Set<TagEntity> tags);
    @Query("" +
        "SELECT p " +
        "FROM posts p " +
        "JOIN p.tags t " +
        "WHERE t.id = ?1"
    )
    List<PostEntity> findAllPostsByTagId(Integer tagId);

    PostEntity findByTitle(@NotEmpty(message = "Title can not be empty") String title);

    List<PostEntity> findByUser(UserEntity user);

    List<PostEntity> findAllByUserId(Integer userId);


}
