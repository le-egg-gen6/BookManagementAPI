package com.myproject.bookmanagementsystem.controller.admin;

import com.myproject.bookmanagementsystem.payload.request.user.UserDetailsRequest;
import com.myproject.bookmanagementsystem.payload.response.user.UserDetailsResponse;
import com.myproject.bookmanagementsystem.payload.response.user.UserResponse;
import com.myproject.bookmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController extends AbstractAdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<UserResponse>> getAllUser(
            Pageable pageable
    ) {
        return ResponseEntity.ok(userService.findAll(pageable));
    }

    @GetMapping("/user/property")
    public ResponseEntity<UserResponse> findUserById(
            @RequestParam(name = "id") Integer id
    ) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/user/property")
    public ResponseEntity<List<UserResponse>> findUserByUsername(
            @RequestParam(name = "username") String username,
            Pageable pageable
    ) {
        return ResponseEntity.ok(userService.findByUsername(username, pageable));
    }

    @GetMapping("/user/property")
    public ResponseEntity<List<UserResponse>> findUSerByEmail(
            @RequestParam(name = "email") String email,
            Pageable pageable
    ) {
        return ResponseEntity.ok(userService.findByEmail(email, pageable));
    }

    @PostMapping("/user/modify")
    public ResponseEntity<UserDetailsResponse> updateUserDetailsByAdmin(
            @RequestBody UserDetailsRequest request
    ) {
        return ResponseEntity.ok(userService.updateUserDetailsByAdmin(request));
    }

}
