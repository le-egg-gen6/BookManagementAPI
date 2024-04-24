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
public class UserResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("full_name")
    private String fullname;

    @JsonProperty("email")
    private String email;

    @JsonProperty("address")
    private Role role;

    public static UserResponse buildFromUser(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .fullname(user.getFirstname() + " " + user.getLastname())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }


}
