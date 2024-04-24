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
public class AuthorResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    public static AuthorResponse buildFromAuthor(Author author) {
        return AuthorResponse.builder()
                .id(author.getId())
                .name(author.getName())
                .build();
    }

}
