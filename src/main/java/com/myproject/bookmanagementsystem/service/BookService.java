package com.myproject.bookmanagementsystem.service;

import com.myproject.bookmanagementsystem.payload.request.book.BookRequest;
import com.myproject.bookmanagementsystem.payload.response.book.BookResponse;

public interface BookService {

    BookResponse findById(Integer id);

    Integer save(BookRequest request);

}
