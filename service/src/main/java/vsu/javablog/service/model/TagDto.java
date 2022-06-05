package vsu.javablog.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//@Getter
//@Setter
public class TagDto {
    @JsonProperty("tag_name")
    @NotBlank(message = "tag.is-blank")
    private String tag;

    @JsonProperty("tag_id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
