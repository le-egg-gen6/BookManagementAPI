package com.myproject.bookmanagementsystem.model;

import com.myproject.bookmanagementsystem.model.constant.NotificationType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "notifitation"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification extends BaseModel {

    @Column(name = "message")
    private String message;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private NotificationType type;

    @Column(name = "check")
    private boolean check;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
