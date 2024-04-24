package com.myproject.bookmanagementsystem.payload.response.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("message")
    private String message;

    @JsonProperty("type")
    private NotificationType type;

}
