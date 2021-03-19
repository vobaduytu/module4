package com.tu.service.imlp;

import com.tu.model.Post;
import com.tu.repository.PostRepository;
import com.tu.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PostServiceImlp implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> showAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void save(Post post) {
      postRepository.save(post);
    }

    @Override
    public void delete(Long id) {
      postRepository.deleteById(id);
    }

    @Override
    public Page<Post> findAllByTitleContaining(String s, Pageable pageable) {
        return postRepository.findAllByTitleContaining(s,pageable);
    }

    @Override
    public Page<Post> findAllByCategory_IdContaining(String s, Pageable pageable) {
        return postRepository.findAllByCategory_IdContaining(s,pageable);
    }
}
