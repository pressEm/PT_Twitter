package vsu.javablog.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vsu.javablog.db.entities.PostEntity;
import vsu.javablog.db.entities.TagEntity;

@Repository
public interface TagRepository extends CrudRepository<TagEntity, Integer>, JpaRepository<TagEntity, Integer>, JpaSpecificationExecutor<TagEntity> {
}
