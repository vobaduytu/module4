package com.tu.controller;

import com.tu.model.Category;
import com.tu.service.CategoryService;
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
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category-list")
    public String show(Model model, @PageableDefault(size = 5,sort = "id",direction = Sort.Direction.DESC)Pageable pageable) {
        model.addAttribute("cate", categoryService.findAll(pageable));
        return "cate-list";
    }
    @GetMapping("/create-cate")
    public String showAdd(Model model){
        model.addAttribute("cate", new Category());
        return "create-cate";
    }
    @PostMapping("/add-cate")
    public String doAdd(@ModelAttribute("cate") Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess","them thanh cong");
        return "redirect:/category-list";
    }
    @GetMapping("/{id}/edit-cate")
    public String showedit(@PathVariable long id, Model model){
        model.addAttribute("cate", categoryService.findById(id));
        return "edit-cate";
    }
    @PostMapping("/edit-cate")
    public String doEdit(@ModelAttribute("cate") Category c , RedirectAttributes redirectAttributes){
        categoryService.save(c);
        redirectAttributes.addFlashAttribute("mess", "cap nhat thanh cong");
        return "redirect:/category-list";

    }
    @GetMapping("/{id}/delete-cate")
    public String delete(@PathVariable long id, RedirectAttributes redirectAttributes){
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "xoa thanh cong");
        return "redirect:/category-list";
    }

    @PostMapping("/search-cate")
    public String search(@RequestParam Optional<String> s , Model model,@PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("cate", categoryService.findAllByNameContaining(s.get(),pageable));
        return "cate-list";
    }



}
