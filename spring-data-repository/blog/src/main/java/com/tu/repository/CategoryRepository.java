package com.tu.repository;

import com.tu.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Page<Category> findAllByNameContaining(String s, Pageable pageable);

    @Modifying
    @Query("update Category c set c.deleted = true where c.id = :id")
    Integer softDeleteCategory(@Param("id") long id);

    Page<Category> findAllByDeletedIsFalse(Pageable pageable);



}
