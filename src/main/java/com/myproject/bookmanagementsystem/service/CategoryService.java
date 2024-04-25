package com.myproject.bookmanagementsystem.service;

import com.myproject.bookmanagementsystem.payload.response.category.CategoryResponse;

import java.util.List;

public interface CategoryService {

    List<CategoryResponse> getAllCategory();

}
