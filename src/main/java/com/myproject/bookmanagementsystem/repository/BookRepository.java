package com.myproject.bookmanagementsystem.repository;

import com.myproject.bookmanagementsystem.model.Author;
import com.myproject.bookmanagementsystem.model.Book;
import com.myproject.bookmanagementsystem.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>,
        PagingAndSortingRepository<Book, Integer> {

    Page<Book> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<Book> findByAuthorIn(List<Author> authors, Pageable pageable);

    Page<Book> findByCategories(List<Category> categories, Pageable pageable);

    Page<Book> findByCategoriesAndNameContainingIgnoreCase(List<Category> categories, String name, Pageable pageable);
}
