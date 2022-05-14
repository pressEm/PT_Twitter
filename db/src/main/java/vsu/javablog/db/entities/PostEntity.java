package vsu.javablog.db.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "posts", schema = "tp_twitter")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "title")
    @NotEmpty(message = "Title can not be empty")
    private String title;

    @Column(name = "content")
    @NotEmpty(message = "Content can not be empty")
    private String content;

    //    @Column(name = "likes")
    //    private int likes;

    @ManyToOne
    @JoinColumn(
        name = "user_id",
        referencedColumnName = "user_id",
        updatable = false
    )
    private UserEntity user;

    @ManyToMany
    @JoinTable(
        joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "post_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "tag_id"),
        name = "posts_tags",
        schema = "tp_twitter"
    )
    Set<TagEntity> tags;

    @OneToMany(mappedBy = "postId")
    private Set<CommentEntity> comments;

}
