package com.myproject.bookmanagementsystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "url")
    private String url;

    @Column(name = "book_cover_image_dir")
    private String bookCoverImageDir;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
    List<Category> categories;

}
