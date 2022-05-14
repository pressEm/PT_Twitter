package vsu.javablog.db.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "tags", schema = "tp_twitter")
@Getter
@Setter
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer id;

    @Column(name = "tag_name")
    @NotEmpty(message = "Tag can not be empty")
    private String tag;
//    @ManyToMany
//    Set<PostEntity> posts;
}
