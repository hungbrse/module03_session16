package com.example.session16.model.dao.book;

import com.example.session16.model.entity.Book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookImpl implements BookDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Book> findAll() {
        Session session = sessionFactory.openSession();
        List<Book> bookList = new ArrayList<>();
        try {
            bookList = session.createQuery("from Book").list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return bookList;
    }

    @Override
    public Book findById(int id) {
        Session session = sessionFactory.openSession();
        Book book = null;
        try {
            book = session.get(Book.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return book;

    }

    @Override
    public boolean save(Book book) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(Book book) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public void delete(Book book) {
           Session session = sessionFactory.openSession();
           try {
               session.beginTransaction();
               session.delete(book);
               session.getTransaction().commit();

           }catch (Exception e){
               e.printStackTrace();
           }finally {
               session.close();
           }
    }
}
