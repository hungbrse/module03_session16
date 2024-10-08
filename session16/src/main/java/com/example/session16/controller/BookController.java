package com.example.session16.controller;

import com.example.session16.File.UploadService;
import com.example.session16.model.entity.Book;
import com.example.session16.model.entity.Category;
import com.example.session16.model.service.book.BookServiceDao;
import com.example.session16.model.service.category.CategoryServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController  {
    @Autowired
    BookServiceDao bookServiceDao;

    @Autowired
    CategoryServiceDao categoryServiceDao;

    @Autowired
    private UploadService uploadService;

    @GetMapping
    public String index(Model model) {
        List<Book> bookList = bookServiceDao.findAll();
        model.addAttribute("bookList", bookList);
        return "book/index";
    }

    @GetMapping("/add")
    public String add(Model model,Book book) {
        List<Category> categoryList = categoryServiceDao.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("book", book);
        return "book/add";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("book") Book book, @RequestParam("img") MultipartFile file) {

        if (file != null) {
            String bookImg = uploadService.upload(file);
            book.setImg(bookImg);
        }

        if (bookServiceDao.save(book)) {
            return "redirect:/book/index";
        }
        return "redirect:/book/add";
    }


}
