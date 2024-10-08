package com.example.session16.model.dao.category;

import com.example.session16.model.entity.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll();
    boolean create(Category category);
    Category findById(int id);
    boolean update(Category category);
    void delete(int id);
}
