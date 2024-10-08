package com.example.session16.model.service.category;

import com.example.session16.model.entity.Category;
import com.example.session16.model.dao.category.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryServiceDao{

    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Category> findAll() {
         return categoryDao.findAll();
    }

    @Override
    public boolean create(Category category) {
        return categoryDao.create(category);
    }

    @Override
    public Category findById(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public boolean update(Category category) {
        return categoryDao.update(category);
    }

    @Override
    public boolean delete(int id) {
         categoryDao.delete(id);
        return false;
    }
}
