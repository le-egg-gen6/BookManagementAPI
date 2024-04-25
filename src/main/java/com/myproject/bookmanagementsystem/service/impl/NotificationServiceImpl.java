package com.myproject.bookmanagementsystem.service.impl;

import com.myproject.bookmanagementsystem.model.Notification;
import com.myproject.bookmanagementsystem.payload.response.notification.NotificationResponse;
import com.myproject.bookmanagementsystem.repository.NotificationRepository;
import com.myproject.bookmanagementsystem.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;


    @Override
    public List<NotificationResponse> getAllNotification(Pageable pageable) {
        List<Notification> notifications = notificationRepository.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.DESC, "id"))
                )
        ).getContent();
        return notifications.stream()
                .map(NotificationResponse::buildFromNotification)
                .collect(Collectors.toList());
    }
}
