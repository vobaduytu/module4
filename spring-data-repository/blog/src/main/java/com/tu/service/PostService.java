package com.tu.service;

import com.tu.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface PostService {
    Page<Post> showAll(Pageable pageable);

    Optional<Post> findById(Long id);

    void save(Post post);

    void delete(Long id);

    Page<Post> findAllByTitleContaining(String s, Pageable pageable);
    Page<Post> findAllByCategory_IdContaining(String s,Pageable pageable);
}
