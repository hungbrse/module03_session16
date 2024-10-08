package com.example.session16.controller;

import com.example.session16.model.entity.Category;
import com.example.session16.model.service.category.CategoryServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServiceDao categoryServiceDao;

    @GetMapping()
    public  String index(Model model){
        List<Category> categoryList = categoryServiceDao.findAll();
        model.addAttribute("categoryList", categoryList);
        return "category/index";
    }

    @GetMapping("/add")
    public  String add(Model model,Category category){
         model.addAttribute("category", category);
         return "category/add";
    }

    @PostMapping("/add")
    public  String create(@ModelAttribute Category category){
        if (categoryServiceDao.create(category) ){
            return "redirect:/category";
        }
        return "redirect:/category/add";

    }

    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable("id") int id){
        if (categoryServiceDao.delete(id)) {
            return "redirect:/category";
        }
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public  String edit(@PathVariable("id") int id,Model model){
        Category updataCategory = categoryServiceDao.findById(id);
        model.addAttribute("updataCategory", updataCategory);
        return "category/edit";
    }

    @PostMapping("/edit/{id}")
    public  String update(@ModelAttribute("updataCategory") Category category){
        if (categoryServiceDao.update(category) ){
            return "redirect:/category";
        }
        return "redirect:/category/edit";
    }

}
