package com.myproject.bookmanagementsystem.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class LoginRequest {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

}
