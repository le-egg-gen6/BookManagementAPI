package com.myproject.bookmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    List<Book> books;

}
