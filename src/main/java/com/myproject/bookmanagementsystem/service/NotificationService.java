package com.myproject.bookmanagementsystem.service;

import com.myproject.bookmanagementsystem.payload.response.notification.NotificationResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NotificationService {

    List<NotificationResponse> getAllNotification(Pageable pageable);

}
