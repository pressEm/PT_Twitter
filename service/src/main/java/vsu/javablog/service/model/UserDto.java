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

@Getter
@Setter
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

    private List<CommentDto> comments;

    private List<PostDto> posts;
}
