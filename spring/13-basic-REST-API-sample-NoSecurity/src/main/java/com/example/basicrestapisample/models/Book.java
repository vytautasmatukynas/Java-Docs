package com.example.basicrestapisample.models;

import jakarta.persistence.*;
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false)
    private String author;

    @Column(length = 150, nullable = false)
    private String title;

    @Column(length = 13, nullable = false)
    private String isbn;

    @Column(nullable = false)
    private int year;

    public Book() {}

    public Book(String author, String title, String isbn, int year) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
    }

    public Book(long id, String author, String title, String isbn, int year) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
