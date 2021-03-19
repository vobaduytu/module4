package com.tu.repository;

import com.tu.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findAllByTitleContaining(String s, Pageable pageable);
    Page<Post> findAllByCategory_IdContaining(String s,Pageable pageable);
    @Modifying
    @Query("update Post p set p.deleted = true where p.category.id = :categoryId")
    Integer softDeletePostByCategoryId(@Param("categoryId") long categoryId);

}
