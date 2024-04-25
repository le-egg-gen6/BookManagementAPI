package com.myproject.bookmanagementsystem.controller.manager;

import com.myproject.bookmanagementsystem.payload.request.author.AuthorDetailsRequest;
import com.myproject.bookmanagementsystem.payload.response.author.AuthorDetailsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController extends AbstractManagerController {

    @PostMapping("/create")
    public ResponseEntity<AuthorDetailsResponse> createAuthorDetails(
            @ResponseBody AuthorDetailsRequest authorDetailsRequest
    ) {

    }

    @PostMapping("/modify")
    public ResponseEntity<AuthorDetailsResponse> createAuthorDetails(
            @ResponseBody AuthorDetailsRequest authorDetailsRequest
    ) {

    }

}
