package com.example.session16.model.service.book;

import com.example.session16.model.entity.Book;

import java.util.List;

public interface BookServiceDao {
    List<Book> findAll();
    Book findById(int id);
    boolean save(Book book);
    boolean update(Book book);
    void delete(Book book);
}
