package com.myproject.bookmanagementsystem.controller;

import com.myproject.bookmanagementsystem.payload.request.book.BookRequest;
import com.myproject.bookmanagementsystem.payload.response.book.BookResponse;
import com.myproject.bookmanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("${api.prefix}" + "${api.version}" + "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/get/{bookId}")
    public ResponseEntity<BookResponse> getBook(
            @RequestParam Integer bookId
    ) {
        return ResponseEntity.ok(bookService.findById(bookId));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(
            @RequestBody BookRequest bookRequest
            ) {
        String location = "api.prefix" +
                "api.version" +
                "/book/get?id=" +
                bookService.save(bookRequest);
        return ResponseEntity.created(URI.create(location)).build();
    }

    @GetMapping("/get")
    public ResponseEntity<?> findAllBook() {
        return null;
    }

}
