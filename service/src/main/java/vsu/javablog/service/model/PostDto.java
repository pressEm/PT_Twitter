package vsu.javablog.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class PostDto {
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
}
