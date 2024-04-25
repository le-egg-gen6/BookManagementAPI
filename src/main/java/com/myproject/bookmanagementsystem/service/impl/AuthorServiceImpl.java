package com.myproject.bookmanagementsystem.service.impl;

import com.myproject.bookmanagementsystem.config.exception.ResourceNotFoundException;
import com.myproject.bookmanagementsystem.model.Author;
import com.myproject.bookmanagementsystem.payload.response.author.AuthorDetailsResponse;
import com.myproject.bookmanagementsystem.repository.AuthorRepository;
import com.myproject.bookmanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<AuthorDetailsResponse> getAllAuthor(Pageable pageable) {
        List<Author> authorList = authorRepository.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "id"))
                )
        ).getContent();
        return authorList.stream()
                .map(AuthorDetailsResponse::buildFromAuthor)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDetailsResponse getAuthor(Integer id) {
        var author = authorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Author not found")
        );
        return AuthorDetailsResponse.buildFromAuthor(author);
    }


}
