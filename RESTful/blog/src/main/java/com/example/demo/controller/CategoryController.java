package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
 @Autowired
 private PostRepository postRepository;
    @GetMapping("/")
    public ResponseEntity<?> showAll(){
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()){
            return new ResponseEntity<List<Category>>( HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>( categories, HttpStatus.OK);
    }
    @GetMapping("/{id}/posts")
    public ResponseEntity<?> showPostCategory(@PathVariable long id){
        List<Post> posts =  postRepository.findAllByCategory_Id(id);

        return new ResponseEntity<>(posts,HttpStatus.OK);
    }


}
