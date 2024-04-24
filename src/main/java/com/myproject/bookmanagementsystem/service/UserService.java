package com.myproject.bookmanagementsystem.service;

import com.myproject.bookmanagementsystem.payload.request.user.UserDetailsRequest;
import com.myproject.bookmanagementsystem.payload.response.user.UserDetailsResponse;
import com.myproject.bookmanagementsystem.payload.response.user.UserResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    Integer getauthenticatedUserId();

    UserResponse findById(Integer id);

    List<UserResponse> findByUsername(String username, Pageable pageable);

    List<UserResponse> findByEmail(String email, Pageable pageable);

    List<UserResponse> findAll(Pageable pageable);

    UserDetailsResponse updateUserDetailsByUser(UserDetailsRequest request);

    UserDetailsResponse updateUserDetailsByAdmin(UserDetailsRequest request);

}
