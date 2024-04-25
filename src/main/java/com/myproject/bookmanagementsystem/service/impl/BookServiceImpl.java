package com.myproject.bookmanagementsystem.service.impl;

import com.myproject.bookmanagementsystem.config.exception.ResourceNotFoundException;
import com.myproject.bookmanagementsystem.model.Author;
import com.myproject.bookmanagementsystem.model.Book;
import com.myproject.bookmanagementsystem.payload.response.book.BookDetailsResponse;
import com.myproject.bookmanagementsystem.payload.response.book.BookResponse;
import com.myproject.bookmanagementsystem.repository.AuthorRepository;
import com.myproject.bookmanagementsystem.repository.BookRepository;
import com.myproject.bookmanagementsystem.repository.CategoryRepository;
import com.myproject.bookmanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

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
        List<Book> bookList = bookRepository.findByNameContainingIgnoreCase(
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
    public List<BookResponse> findByCategory(String category_code, Pageable pageable) {
        var category = Collections.singletonList(
                categoryRepository.findByCode(category_code).orElseThrow(
                        () -> new ResourceNotFoundException("Category not found")
                )
        );
        List<Book> bookList = bookRepository.findByCategories(
                category,
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
    public List<BookResponse> findByAuthorName(String author_name, Pageable pageable) {
        List<Author> authors = authorRepository.findByNameContainingIgnoreCase(author_name);
        List<Book> bookList = bookRepository.findByAuthorIn(
                authors,
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
    public List<BookResponse> findByCategoryAndName(String category_code, String name, Pageable pageable) {
        var category = Collections.singletonList(
                categoryRepository.findByCode(category_code).orElseThrow(
                        () -> new ResourceNotFoundException("Category not found")
                )
        );
        List<Book> bookList = bookRepository.findByCategoriesAndNameContainingIgnoreCase(
                category,
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
