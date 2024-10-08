package com.example.session16.model.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name",length = 100,unique = true,nullable = false)
    private String categoryName;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    @ColumnDefault("1")
    private boolean status;
    @OneToMany(mappedBy = "category")
    private Set<Book> books;

    public Category() {
    }

    public Category(int id, String categoryName, String description, boolean status, Set<Book> books) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.status = status;
        this.books = books;
    }


    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
