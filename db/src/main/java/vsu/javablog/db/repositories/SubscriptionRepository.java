package vsu.javablog.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vsu.javablog.db.entities.SubscriptionEntity;
import vsu.javablog.db.entities.UserEntity;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Integer> {

    boolean existsByUserAndFriend(UserEntity user, UserEntity friend);

    List<SubscriptionEntity> findByUserAndAccepted(UserEntity user, boolean accepted);

    SubscriptionEntity findByUserAndFriend(UserEntity user, UserEntity friend);

    @Transactional
    @Modifying
    @Query(value = "UPDATE SubscriptionEntity SET is_accepted = :is_accepted WHERE subscription_id = :subscription_id")
    void updateStatus(@Param("subscription_id") Integer subscription_id, @Param("is_accepted") boolean is_accepted);

    @Transactional
    @Modifying
    @Query(value = "DELETE from SubscriptionEntity WHERE subscription_id = :subscription_id")
    void deleteById(@Param("subscription_id") Integer subscription_id);
}
