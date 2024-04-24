package com.myproject.bookmanagementsystem.service.impl;

import com.myproject.bookmanagementsystem.config.exception.ResourceNotFoundException;
import com.myproject.bookmanagementsystem.model.Book;
import com.myproject.bookmanagementsystem.payload.response.book.BookDetailsResponse;
import com.myproject.bookmanagementsystem.payload.response.book.BookResponse;
import com.myproject.bookmanagementsystem.repository.BookRepository;
import com.myproject.bookmanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDetailsResponse findById(Integer id) {
        var book = bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Book Not Found")
        );
        return BookDetailsResponse.buildFromBook(book);
    }

    @Override
    public List<BookResponse> findAll(Pageable pageable) {
        List<Book> bookList = bookRepository.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "id"))
                )
        ).getContent();
        return bookList.stream().map(
                BookResponse::buildFromBook
        ).collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> findByName(String name, Pageable pageable) {
        List<Book> bookList = bookRepository.findByNameContains(
                name,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "id"))
                )
        ).getContent();
        return bookList.stream().map(
                BookResponse::buildFromBook
        ).collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> findByAuthorName(String name, Pageable pageable) {
        List<Book> bookList = bookRepository.findByAuthorName(
                name,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "id"))
                )
        ).getContent();
        return bookList.stream().map(
                BookResponse::buildFromBook
        ).collect(Collectors.toList());
    }

}
