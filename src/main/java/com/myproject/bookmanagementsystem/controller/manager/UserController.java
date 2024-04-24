package com.myproject.bookmanagementsystem.controller.manager;

import com.myproject.bookmanagementsystem.payload.request.user.UserDetailsRequest;
import com.myproject.bookmanagementsystem.payload.response.user.UserDetailsResponse;
import com.myproject.bookmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends AbstractManagerController{

    @Autowired
    private UserService userService;

    @PostMapping("/user/modify")
    public ResponseEntity<UserDetailsResponse> updateUserDetailsBy(
            @RequestBody UserDetailsRequest request
    ) {
        return ResponseEntity.ok(userService.updateUserDetailsByUser(request));
    }

}
