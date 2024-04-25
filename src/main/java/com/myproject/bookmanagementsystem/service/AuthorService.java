package com.myproject.bookmanagementsystem.service;

import com.myproject.bookmanagementsystem.payload.response.author.AuthorDetailsResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService {

    List<AuthorDetailsResponse> getAllAuthor(Pageable pageable);

    AuthorDetailsResponse getAuthor(Integer id);

}
