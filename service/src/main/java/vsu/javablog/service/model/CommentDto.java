package vsu.javablog.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
public class CommentDto {
    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("post_id")
    @NotBlank()
    private Integer postId;

    @JsonProperty("date")
    @NotBlank(message = "date.is-blank")
    private Instant date;

    @JsonProperty("content")
    @NotBlank(message = "content.is-blank")
    @Size(min = 1, max = 100, message = "content.out-of-range")
    private String content;
}
