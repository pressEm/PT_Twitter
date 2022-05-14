package vsu.javablog.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import vsu.javablog.db.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>, JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity> {
    UserEntity findByUsernameEquals(String login);
    boolean existsByUsername(String login);
    boolean existsByEmail(String email);
}
