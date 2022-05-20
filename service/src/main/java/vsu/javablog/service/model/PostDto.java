package vsu.javablog.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

//@Getter
//@Setter
public class PostDto {
    @JsonProperty("post_id")
    private Integer postId;

    @JsonProperty("title")
    @NotBlank(message = "title.is-blank")
    @Size(min = 1, max = 50, message = "title.out-of-range")
    private String title;

    @JsonProperty("content")
    @NotBlank(message = "content.is-blank")
    @Size(min = 1, max = 1000, message = "content.out-of-range")
    private String content;

    @JsonProperty("user_id")
    private Integer userId;

    private List<TagDto> tags;
    private List<CommentDto> comments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<TagDto> getTags() {
        return tags;
    }

    public void setTags(List<TagDto> tags) {
        this.tags = tags;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }
}
