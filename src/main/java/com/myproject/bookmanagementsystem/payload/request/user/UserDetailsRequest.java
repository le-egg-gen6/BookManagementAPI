package com.myproject.bookmanagementsystem.payload.request.user;

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
public class UserDetailsRequest {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("first_name")
    private String firstname;

    @JsonProperty("last_name")
    private String lastname;

    @JsonProperty("email")
    private String email;

    @JsonProperty("address")
    private String address;

    @JsonProperty("address")
    private Role role;

}
