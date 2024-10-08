package com.example.session16.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;


@Entity
@Table(name = "BookDatabase")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private int bookId;

    @Column(name = "bookName",length = 100,unique = true,nullable = true)
    private String bookName;

    @Min(value = 1,message = "giá sách phải lớn hơn 1 nhé bạn iu ")
    @Column(name = "bookPrice")
    private double bookPrice;

    @Column(name = "bookDescription" )
   private String bookDescription;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @Column(name = "bookStatus")
    private String bookStatus;

    @Column(name = "img")
    private String img;

    public Book() {
    }

    public Book(int bookId, String bookName, double bookPrice, String bookDescription, Category category, String bookStatus, String img) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookDescription = bookDescription;
        this.category = category;
        this.bookStatus = bookStatus;
        this.img = img;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Min(value = 1, message = "giá sách phải lớn hơn 1 nhé bạn iu ")
    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(@Min(value = 1, message = "giá sách phải lớn hơn 1 nhé bạn iu ") double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
