package com.controller;

import com.model.Products;
import com.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    ProductService productService = new ProductService();

    @GetMapping("/index")
    public String index(Model model) {
        List<Products> products = productService.findAll();
        model.addAttribute("product", products);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Products());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Products products) {
        products.setId((int)(Math.random() * 10000));
        productService.save(products);
        return "redirect:/index";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product",productService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(Products products) {
        productService.update(products.getId(), products);
        return "redirect:/index";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model,Products products, RedirectAttributes redirect) {
        model.addAttribute("product", productService.findById(id));
        productService.remove(products.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/index";

    }
}
