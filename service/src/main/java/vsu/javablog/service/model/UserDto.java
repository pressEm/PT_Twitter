package vsu.javablog.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

//@Getter
//@Setter
//@RequiredArgsConstructor
public class UserDto {
    @JsonProperty("username")
    @NotBlank(message = "username.is-blank")
    @Size(min = 1, max = 100, message = "username.out-of-range")
    private String username;

    @NotBlank(message = "password.is-blank")
    @Size(min = 8, message = "password.too-short")
    @Size(max = 60, message = "password.long")
    private String password;

    //@EmailUnique
    @Email(message = "email.invalid")
    @NotNull(message = "email.is-null")
    private String email;

    private List<PostDto> likedPosts;

    private List<CommentDto> comments;

    private List<PostDto> posts;

    public List<PostDto> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(List<PostDto> likedPosts) {
        this.likedPosts = likedPosts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public List<PostDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDto> posts) {
        this.posts = posts;
    }
}
