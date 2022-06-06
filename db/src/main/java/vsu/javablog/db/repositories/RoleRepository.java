package vsu.javablog.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vsu.javablog.db.entities.PostEntity;
import vsu.javablog.db.entities.RoleEntity;
import vsu.javablog.db.entities.TagEntity;

@Repository

public interface RoleRepository  extends CrudRepository<RoleEntity, Integer>, JpaRepository<RoleEntity, Integer>, JpaSpecificationExecutor<RoleEntity> {
    RoleEntity findById(int id);

}
