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

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    List<Author> authors;

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    List<Category> categories;

}
