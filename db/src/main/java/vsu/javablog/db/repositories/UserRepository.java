package vsu.javablog.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vsu.javablog.db.entities.PostEntity;
import vsu.javablog.db.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>, JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity> {
    UserEntity findByUsername(String login);
    UserEntity findByEmail(String email);
    boolean existsByUsername(String login);
    boolean existsByEmail(String email);
}
