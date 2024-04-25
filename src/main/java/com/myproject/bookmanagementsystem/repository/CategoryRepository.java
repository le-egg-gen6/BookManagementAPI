package com.myproject.bookmanagementsystem.repository;

import com.myproject.bookmanagementsystem.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findByCode(String code);

}
