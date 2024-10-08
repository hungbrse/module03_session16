package com.example.session16.model.service.category;

import com.example.session16.model.entity.Category;

import java.util.List;

public interface CategoryServiceDao {
    List<Category> findAll();
    boolean create(Category category);
    Category findById(int id);
    boolean update(Category category);
    boolean delete(int id);
}
