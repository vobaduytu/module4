package com.tu.controller;

import com.tu.model.Province;
import com.tu.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/province")
    public String show(Model model, @PageableDefault(size = 5) Pageable pageable){
        Iterable<Province> provinces = provinceService.findAll(pageable);
        model.addAttribute("province",provinces);
        return "province";
    }

    @GetMapping("/add-province")
    public String showAdd(Model model){
        model.addAttribute("add",new Province());
        return "create-province";

    }

    @PostMapping("add-province")
    public String doAdd(@ModelAttribute("add") Province province){
        provinceService.save(province);
        return "redirect:/province";

    }

    @GetMapping("/{id}/edit-province")
    public String showEdit(@PathVariable long id, Model model){
        model.addAttribute("edit",provinceService.findById(id));
        return "edit-province";
    }

    @PostMapping("/edit-province")
    public String doEdit(@ModelAttribute("edit") Province province){
        provinceService.save(province);
        return "redirect:/province";
    }

    @GetMapping("/{id}/delete-province")
    public String delete(@PathVariable long id){
        provinceService.remove(id);
        return "redirect:/province";
    }
   @PostMapping("/search")
    public String search(@RequestParam Optional<String> search, Model model, @PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("province",provinceService.findAllByNameContaining(search.get(),pageable));
        return "province";
   }

}
