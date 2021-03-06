package vsu.javablog.db.entities;

//import org.hibernate.mapping.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users", schema = "tp_twitter")
@Validated
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "login")
    @NotEmpty(message = "Username can not be empty")
    @Size(min = 4, max = 20, message = "Username length should be between 4 an 20 characters")
    private String username;

    @Column(name = "email")
    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Email is not valid")
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "Password can not be empty")
    private String password;


    @ManyToOne()
    @JoinColumn(name = "role")
//    @NotEmpty(message = "Roles can not be null")
    private RoleEntity role;

    @OneToMany(mappedBy= "user")
    private List<CommentEntity> comments;

    @OneToMany(mappedBy = "user")
    private List<PostEntity> posts;

    @ManyToMany
    @JoinTable(
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "post_id", referencedColumnName = "post_id"),
        name = "likes",
        schema = "tp_twitter"
    )
    private List<PostEntity> likedPosts;

//    public UserEntity() {
//    }


    public List<PostEntity> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(List<PostEntity> likedPosts) {
        this.likedPosts = likedPosts;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public List<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntity> posts) {
        this.posts = posts;
    }
}
