package vsu.javablog.db.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Entity
@Table(name = "tags", schema = "tp_twitter")
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    @Column(name = "tag_name")
    @NotEmpty(message = "Tag can not be empty")
    private String tag;

    @ManyToMany
    Set<PostEntity> posts;
}
