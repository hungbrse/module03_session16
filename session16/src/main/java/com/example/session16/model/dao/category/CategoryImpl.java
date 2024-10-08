package com.example.session16.model.dao.category;

import com.example.session16.model.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryImpl implements CategoryDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> findAll() {
        Session session = sessionFactory.openSession();
        List<Category> categoryList = new ArrayList<>();
        try {
            categoryList = session.createQuery("from Category ",Category.class).list();
        } catch (Exception exception){
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return categoryList;
    }

    @Override
    public boolean create(Category category) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public Category findById(int id) {
        Session session = sessionFactory.openSession();
         Category category = null;
        try {
            category = session.get(Category.class, id);
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            session.close();
        }
        return category;

    }

    @Override
    public boolean update(Category category) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(category);
            session.getTransaction().commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            session.close();
        }
    }
}
