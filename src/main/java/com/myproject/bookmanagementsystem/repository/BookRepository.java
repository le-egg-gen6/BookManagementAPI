package com.myproject.bookmanagementsystem.repository;

import com.myproject.bookmanagementsystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>,
        PagingAndSortingRepository<Book, Integer> {
}
