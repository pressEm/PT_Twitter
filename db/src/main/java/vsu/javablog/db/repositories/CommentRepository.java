package vsu.javablog.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import vsu.javablog.db.entities.CommentEntity;
import vsu.javablog.db.entities.PostEntity;
import vsu.javablog.db.entities.UserEntity;

import java.util.List;

public interface CommentRepository  extends CrudRepository<CommentEntity, Integer>, JpaRepository<CommentEntity, Integer>, JpaSpecificationExecutor<CommentEntity> {
    List<CommentEntity> findAllByUserId(UserEntity userId);
    List<CommentEntity> findAllByPostId(PostEntity postId);
}
