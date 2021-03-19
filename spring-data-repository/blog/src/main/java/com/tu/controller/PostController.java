package com.tu.controller;

import com.tu.model.Category;
import com.tu.model.Post;
import com.tu.repository.CategoryRepository;
import com.tu.service.CategoryService;
import com.tu.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/post-list")
    public String show(Model model, @PageableDefault(size = 7,sort = "id",direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("post", postService.showAll(pageable));
        model.addAttribute("category",categoryRepository.findAll());
        return "post-list";
    }

    @GetMapping("/create-post")
    public String showPost(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("category", categoryRepository.findAll());
        return "create-post";
    }

    @PostMapping("/add")
    public String doAdd(Post post, RedirectAttributes redirectAttributes) {
        postService.save(post);
        redirectAttributes.addFlashAttribute("mess", "them moi thanh cong");
        return "redirect:/post-list";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("category", categoryRepository.findAll());
        return "edit-post";
    }

    @PostMapping("/update")
    public String doEdit(@ModelAttribute("post") Post post, RedirectAttributes redirectAttributes) {
        postService.save(post);
        redirectAttributes.addFlashAttribute("mess", "cap nhat thanh cong");
        return "redirect:/post-list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable long id, RedirectAttributes redirectAttributes) {
        postService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "xoa thanh cong");
        return "redirect:/post-list";
    }

    @PostMapping("/search")
    public String search(@RequestParam Optional<String> search, Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("post", postService.findAllByTitleContaining(search.get(), pageable));
        return "post-list";
    }
    @PostMapping("/search-cate-id")
    private String searchIdCategory(@RequestParam Optional<String> searchId, Model model, @PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("post",postService.findAllByCategory_IdContaining(searchId.get(),pageable));
        return "post-list";
    }
}
