package com.myproject.bookmanagementsystem.controller.user;

import com.myproject.bookmanagementsystem.payload.response.book.BookDetailsResponse;
import com.myproject.bookmanagementsystem.payload.response.book.BookResponse;
import com.myproject.bookmanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController extends AbstractUserController{

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public ResponseEntity<List<BookResponse>> getAll(
            Pageable pageable
    ) {
        return ResponseEntity.ok(bookService.findAll(pageable));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookDetailsResponse> getBook(
            @PathVariable(name = "id") Integer id
    ) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @GetMapping("/book/property")
    public ResponseEntity<List<BookResponse>> findByName(
            @RequestParam(name = "name") String name,
            Pageable pageable
    ) {
        return ResponseEntity.ok(bookService.findByName(name, pageable));
    }

    @GetMapping("/book/property")
    public ResponseEntity<List<BookResponse>> findByAuthorName(
            @RequestParam(name = "author_name") String name,
            Pageable pageable
    ) {
        return ResponseEntity.ok(bookService.findByAuthorName(name, pageable));
    }

    @GetMapping("/book/property")
    public ResponseEntity<List<BookResponse>> findByCategoryAndName(
            @RequestParam(name = "category") String category,
            @RequestParam(name = "name") String name,
            Pageable pageable
    ) {
        return ResponseEntity.ok(bookService.findByCategoryAndName(category, name, pageable));
    }
}
