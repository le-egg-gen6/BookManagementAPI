package com.myproject.bookmanagementsystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author extends BaseModel {

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

}
