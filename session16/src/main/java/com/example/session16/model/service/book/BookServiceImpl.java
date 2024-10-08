package com.example.session16.model.service.book;

import com.example.session16.model.dao.book.BookDao;
import com.example.session16.model.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookServiceDao{
    @Autowired
    BookDao bookDao;
    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookDao.findById(id);
    }

    @Override
    public boolean save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public void delete(Book book) {
       bookDao.delete(book);
    }
}
