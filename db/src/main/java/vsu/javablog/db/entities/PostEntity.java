package vsu.javablog.db.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Entity(name = "posts")
@Table(name = "posts", schema = "tp_twitter")
@Getter
@Setter
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer id;

    @Column(name = "title")
    @NotEmpty(message = "Title can not be empty")
    private String title;

    @Column(name = "content")
    @NotEmpty(message = "Content can not be empty")
    private String content;

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
    List<TagEntity> tags;

    @OneToMany(mappedBy = "postId")
    private Set<CommentEntity> comments;

}
