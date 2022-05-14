package vsu.javablog.db.entities;


import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "comments", schema = "tp_twitter")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "comment_date")
    private Date date;

    @Column(name = "content")
    @NotEmpty(message = "Comment content can not be empty")
    private String content;

    @ManyToOne()
    @JoinColumn(name = "post_id", referencedColumnName = "post_id", nullable=false)
    PostEntity postId;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable=false)
    UserEntity userId;
}
