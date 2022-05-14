package vsu.javablog.db.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subscriptions", schema = "tp_twitter")
//@Validated
@Getter
@Setter
public class SubscriberEntity implements Serializable{

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
//
//    @Column(name = "accepted")
//    private boolean accepted;

//    public boolean isAccepted() {
//        return accepted;
//    }

//    public void setAccepted(boolean accepted) {
//        this.accepted = accepted;
//    }
//
//    public SubscriberEntity() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public UserEntity getUser() {
//        return user;
//    }
//
//    public void setUser(UserEntity user) {
//        this.user = user;
//    }
//
//    public UserEntity getFriend() {
//        return friend;
//    }
//
//    public void setFriend(UserEntity friend) {
//        this.friend = friend;
//    }
}
