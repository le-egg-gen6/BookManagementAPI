package com.myproject.bookmanagementsystem.payload.response.author;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.bookmanagementsystem.model.Author;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class AuthorDetailsResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("avatar_dir")
    private String avatarDir;

    public static AuthorDetailsResponse buildFromAuthor(Author author) {
        return AuthorDetailsResponse.builder()
                .id(author.getId())
                .name(author.getName())
                .avatarDir(author.getAvatarDir())
                .build();
    }

}
