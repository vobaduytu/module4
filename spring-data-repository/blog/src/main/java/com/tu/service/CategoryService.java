package com.tu.service;

import com.tu.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {

    Page<Category> findAll(Pageable pageable);
    Page<Category> findAllByNameContaining(String s, Pageable pageable);
    Optional<Category> findById(Long id);
    void save(Category category);
    void delete(Long id);
}
