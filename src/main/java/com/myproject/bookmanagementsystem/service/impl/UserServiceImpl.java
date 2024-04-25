package com.myproject.bookmanagementsystem.service.impl;

import com.myproject.bookmanagementsystem.config.exception.InvalidArgumentException;
import com.myproject.bookmanagementsystem.config.exception.ResourceNotFoundException;
import com.myproject.bookmanagementsystem.model.User;
import com.myproject.bookmanagementsystem.model.constant.Role;
import com.myproject.bookmanagementsystem.payload.request.user.UserDetailsRequest;
import com.myproject.bookmanagementsystem.payload.response.user.UserDetailsResponse;
import com.myproject.bookmanagementsystem.payload.response.user.UserResponse;
import com.myproject.bookmanagementsystem.repository.UserRepository;
import com.myproject.bookmanagementsystem.service.TokenService;
import com.myproject.bookmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    public Integer getAuthenticatedUserId() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (Objects.isNull(username)) {
            throw new AccessDeniedException("Access Denied");
        }
        var user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        return user.getId();
    }

    @Override
    public UserResponse findById(Integer id) {
        var user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found"));
        return UserResponse.buildFromUser(user);
    }

    @Override
    public List<UserResponse> findByUsername(String username, Pageable pageable) {
        List<User> userResponseList = userRepository.findByUsernameContains(
                username,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "id"))
                )
        ).getContent();
        return userResponseList.stream().map(
                UserResponse::buildFromUser
        ).collect(Collectors.toList());
    }

    @Override
    public List<UserResponse> findByEmail(String email, Pageable pageable) {
        List<User> userResponseList = userRepository.findByEmailContains(
                email,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "id"))
                )
        ).getContent();
        return userResponseList.stream().map(
                UserResponse::buildFromUser
        ).collect(Collectors.toList());
    }

    @Override
    public UserDetailsResponse updateUserDetailsByAdmin(UserDetailsRequest request) {
        var user = userRepository.findById(request.getId()).orElseThrow(
                () -> new InvalidArgumentException("User not found")
        );
        if (user.getRole() == Role.ADMIN && request.getRole() != Role.ADMIN) {
            throw new InvalidArgumentException("Downgrades authority are not allowed");
        }
        user.setRole(request.getRole());
        var saved_user = userRepository.save(user);
        tokenService.revokeAllUserTokens(saved_user);
        return UserDetailsResponse.buildFromUser(saved_user);
    }

    @Override
    public List<UserResponse> findAll(Pageable pageable) {
        List<User> userList = userRepository.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "id"))
                )
        ).getContent();
        return userList.stream().map(UserResponse::buildFromUser).collect(Collectors.toList());
    }

    @Override
    public UserDetailsResponse updateUserDetailsByUser(UserDetailsRequest request) {
        var user = userRepository.findById(getAuthenticatedUserId()).orElse(null);
        if (user == null) {
            throw new ResourceNotFoundException("User not found!");
        }
        if (request.getRole() != user.getRole()) {
            throw new InvalidArgumentException("You are not allowed to change your rule");
        }
        user.setEmail(request.getEmail());
        user.setFirstname(request.getFirstname());
        user.setEmail(request.getEmail());
        user.setAddress(request.getAddress());
        var saved_user = userRepository.save(user);
        return UserDetailsResponse.buildFromUser(saved_user);
    }
}
