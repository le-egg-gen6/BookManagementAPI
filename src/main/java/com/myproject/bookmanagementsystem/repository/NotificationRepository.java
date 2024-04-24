package com.myproject.bookmanagementsystem.repository;

import com.myproject.bookmanagementsystem.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer>,
        PagingAndSortingRepository<Notification, Integer> {
}
