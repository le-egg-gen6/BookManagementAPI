package com.myproject.bookmanagementsystem.payload.response.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.bookmanagementsystem.model.Notification;
import com.myproject.bookmanagementsystem.model.constant.NotificationType;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class NotificationResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("message")
    private String message;

    @JsonProperty("type")
    private NotificationType type;

    public static NotificationResponse buildFromNotification(Notification notification) {
        return NotificationResponse.builder()
                .id(notification.getId())
                .message(notification.getMessage())
                .type(notification.getType())
                .build();
    }

}
