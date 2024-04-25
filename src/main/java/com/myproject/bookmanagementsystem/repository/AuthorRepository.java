package com.myproject.bookmanagementsystem.repository;

import com.myproject.bookmanagementsystem.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>,
        PagingAndSortingRepository<Author, Integer> {

    List<Author> findByNameContainingIgnoreCase(String author_name);

}
