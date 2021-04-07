package com.example.demo.service;

import com.example.demo.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> findAll();

    Optional<Post> findById(Long id);
    Post save(Post post);
    void delele(Long id);

}
