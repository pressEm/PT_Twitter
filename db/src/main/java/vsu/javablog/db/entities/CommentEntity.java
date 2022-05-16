package vsu.javablog.db.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "comments", schema = "tp_twitter")
//@Getter
//@Setter
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer id;

    @Column(name = "comment_date")
    private Instant date;

    @Column(name = "content")
    @NotEmpty(message = "Comment content can not be empty")
    private String content;

    @ManyToOne()
    @JoinColumn(name = "post_id", referencedColumnName = "post_id", nullable=false)
    PostEntity post;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable=false)
    UserEntity user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
