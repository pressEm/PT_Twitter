package vsu.javablog.db.entities;

import javax.persistence.*;

@Entity
@Table(name="subscriptions", schema = "tp_twitter")
public class SubscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    UserEntity user;

    @ManyToOne()
    @JoinColumn(name = "subscriber_id", referencedColumnName = "user_id")
    UserEntity friend;

    @Column(name = "is_accepted")
    private boolean accepted;

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public SubscriptionEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public UserEntity getFriend() {
        return friend;
    }

    public void setFriend(UserEntity friend) {
        this.friend = friend;
    }
}
