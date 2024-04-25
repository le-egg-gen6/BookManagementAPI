package com.myproject.bookmanagementsystem.controller.user;

import com.myproject.bookmanagementsystem.payload.response.category.CategoryResponse;
import com.myproject.bookmanagementsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController extends AbstractUserController{

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<CategoryResponse>> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

}
