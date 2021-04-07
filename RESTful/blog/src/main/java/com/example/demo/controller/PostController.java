package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "post")
public class PostController {
    @Autowired
    private PostService postService;
  @Autowired
  private PostRepository postRepository;

    @GetMapping("/")
    public ResponseEntity<?> show(){
        List<Post>posts =postService.findAll();
        if (posts.isEmpty()){
            return new ResponseEntity<List<Post>>( HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Post>>( posts, HttpStatus.OK);
     }
      @GetMapping("/{id}")
    public ResponseEntity<?> showId(@PathVariable long id){
        List<Post> posts = postRepository.findAllById(id);
        return new ResponseEntity<>(posts,HttpStatus.OK);
      }
}
