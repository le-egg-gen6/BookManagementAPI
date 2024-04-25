package com.myproject.bookmanagementsystem.controller.user;

import com.myproject.bookmanagementsystem.payload.request.user.UserDetailsRequest;
import com.myproject.bookmanagementsystem.payload.response.user.UserDetailsResponse;
import com.myproject.bookmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends AbstractUserController {

    @Autowired
    private UserService userService;

    @PostMapping("/modify")
    public ResponseEntity<UserDetailsResponse> updateUserDetailsByUser(
            @RequestBody UserDetailsRequest request
    ) {
        return ResponseEntity.ok(userService.updateUserDetailsByUser(request));
    }

}
