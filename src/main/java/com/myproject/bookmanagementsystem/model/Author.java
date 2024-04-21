package com.myproject.bookmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author extends BaseModel {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    List<Book> books;

}
