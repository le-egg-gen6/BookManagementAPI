package com.myproject.bookmanagementsystem.controller.user;

import com.myproject.bookmanagementsystem.payload.response.notification.NotificationResponse;
import com.myproject.bookmanagementsystem.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationController extends AbstractUserController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification")
    public ResponseEntity<List<NotificationResponse>> getAllNotificationResponse(
            Pageable pageable
    ) {
        return ResponseEntity.ok((notificationService.getAllNotification(pageable)));
    }

}
