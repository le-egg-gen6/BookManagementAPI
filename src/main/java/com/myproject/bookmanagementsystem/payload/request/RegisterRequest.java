package com.myproject.bookmanagementsystem.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.bookmanagementsystem.model.constant.Role;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class RegisterRequest {

    @JsonProperty("first_name")
    private String firstname;

    @JsonProperty("last_name")
    private String lastname;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("role")
    private Role role;

}
