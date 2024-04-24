package com.myproject.bookmanagementsystem.payload.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.bookmanagementsystem.model.User;
import com.myproject.bookmanagementsystem.model.constant.Role;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UserDetailsResponse {

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

    public static UserDetailsResponse buildFromUser(User user) {
        return UserDetailsResponse.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .address(user.getAddress())
                .role(user.getRole())
                .build();
    }

}
