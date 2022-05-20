package vsu.javablog.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

//@Getter
//@Setter
public class CommentDto {
    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("post_id")
    private Integer postId;

    @JsonProperty("date")
    private Instant date;

    @JsonProperty("content")
    @NotBlank(message = "content.is-blank")
    @Size(min = 1, max = 100, message = "content.out-of-range")
    private String content;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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
}
