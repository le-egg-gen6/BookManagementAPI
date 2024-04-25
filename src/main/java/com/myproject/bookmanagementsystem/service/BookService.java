package com.myproject.bookmanagementsystem.service;

import com.myproject.bookmanagementsystem.payload.response.book.BookDetailsResponse;
import com.myproject.bookmanagementsystem.payload.response.book.BookResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    BookDetailsResponse findById(Integer id);

    List<BookResponse> findAll(Pageable pageable);

    List<BookResponse> findByName(String name, Pageable pageable);

    List<BookResponse> findByCategory(String category_code, Pageable pageable);

    List<BookResponse> findByAuthorName(String author_name, Pageable pageable);

    List<BookResponse> findByCategoryAndName(String category_code, String name, Pageable pageable);

}
