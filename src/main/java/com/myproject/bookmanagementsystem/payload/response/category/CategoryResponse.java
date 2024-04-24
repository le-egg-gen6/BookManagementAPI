package com.myproject.bookmanagementsystem.payload.response.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.bookmanagementsystem.model.Category;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class CategoryResponse {

    @JsonProperty("id")
    private  Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("code")
    private String code;

    public static CategoryResponse buildFromCategory(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .code(category.getCode())
                .build();
    }

}
