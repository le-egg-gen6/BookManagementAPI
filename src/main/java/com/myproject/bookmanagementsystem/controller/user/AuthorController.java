package com.myproject.bookmanagementsystem.controller.user;

import com.myproject.bookmanagementsystem.payload.request.author.AuthorDetailsRequest;
import com.myproject.bookmanagementsystem.payload.response.author.AuthorDetailsResponse;
import com.myproject.bookmanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController extends AbstractUserController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/create")
    public ResponseEntity<AuthorDetailsResponse> createAuthorDetails(
            @ResponseBody AuthorDetailsRequest authorDetailsRequest
    ) {

    }

    @GetMapping("/author")
    public ResponseEntity<List<AuthorDetailsResponse>> getAllAuthor(
            Pageable pageable
    ) {
        return ResponseEntity.ok(authorService.getAllAuthor(pageable));
    }

}
