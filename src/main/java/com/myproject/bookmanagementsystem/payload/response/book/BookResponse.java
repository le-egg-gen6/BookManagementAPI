package com.myproject.bookmanagementsystem.payload.response.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.bookmanagementsystem.model.Book;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class BookResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("name")
    private String shortDescription;

    @JsonProperty("book_cover_image_dir")
    private String bookCoverImageDir;

    public static BookResponse buildFromBook(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .shortDescription(book.getShortDescription())
                .bookCoverImageDir(book.getBookCoverImageDir())
                .build();
    }

}
