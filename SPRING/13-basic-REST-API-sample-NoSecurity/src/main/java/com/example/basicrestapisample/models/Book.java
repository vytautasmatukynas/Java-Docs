package com.example.basicrestapisample.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

//    public Book(String author, String title, String isbn, int year) {
//        this.author = author;
//        this.title = title;
//        this.isbn = isbn;
//        this.year = year;
//    }

}
