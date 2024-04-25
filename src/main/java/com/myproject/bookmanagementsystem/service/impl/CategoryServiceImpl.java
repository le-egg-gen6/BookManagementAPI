package com.myproject.bookmanagementsystem.service.impl;

import com.myproject.bookmanagementsystem.model.Category;
import com.myproject.bookmanagementsystem.payload.response.category.CategoryResponse;
import com.myproject.bookmanagementsystem.repository.CategoryRepository;
import com.myproject.bookmanagementsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryResponse::buildFromCategory)
                .collect(Collectors.toList());
    }

}
