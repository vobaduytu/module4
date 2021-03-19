package com.tu.service.imlp;

import com.tu.model.Category;
import com.tu.repository.CategoryRepository;
import com.tu.repository.PostRepository;
import com.tu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CategoryServiceImlp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAllByDeletedIsFalse(pageable);
    }

    @Override
    public Page<Category> findAllByNameContaining(String s, Pageable pageable) {
        return categoryRepository.findAllByNameContaining(s, pageable);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        boolean result = categoryRepository.softDeleteCategory(id) > 0;
        if (!result)
            throw new RuntimeException("category not found");
        postRepository.softDeletePostByCategoryId(id);
    }
}
