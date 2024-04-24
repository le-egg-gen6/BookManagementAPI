package com.myproject.bookmanagementsystem.repository;

import com.myproject.bookmanagementsystem.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>,
        PagingAndSortingRepository<Book, Integer> {

    @Query(
            value = "select b from Book b where b.name like %:name%"
    )
    Page<Book> findByNameContains(@Param("name") String name, Pageable pageable);

    @Query(
            value = "select b from Book b where b.author.name like %:name%"
    )
    Page<Book> findByAuthorName(String name, Pageable pageable);
}
