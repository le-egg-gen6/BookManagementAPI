package com.myproject.bookmanagementsystem.payload.response.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.bookmanagementsystem.model.Book;
import com.myproject.bookmanagementsystem.payload.response.author.AuthorDetailsResponse;
import com.myproject.bookmanagementsystem.payload.response.category.CategoryResponse;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Getter
@Setter
@Builder
public class BookDetailsResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("short_description")
    private String shortDescription;

    @JsonProperty("url")
    private String url;

    @JsonProperty("book_cover_image_dir")
    private String bookCoverImageDir;

    @JsonProperty("author")
    private AuthorDetailsResponse author;

    @JsonProperty("categories")
    List<CategoryResponse> categories;

    public static BookDetailsResponse buildFromBook(Book book) {
        return BookDetailsResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .shortDescription(book.getShortDescription())
                .url(book.getShortDescription())
                .bookCoverImageDir(book.getBookCoverImageDir())
                .author(
                        AuthorDetailsResponse.buildFromAuthor(book.getAuthor())
                )
                .categories(
                        book.getCategories().stream()
                                .map(CategoryResponse::buildFromCategory)
                                .collect(Collectors.toList())
                )
                .build();
    }

}
