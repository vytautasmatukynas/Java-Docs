package com.example.basicrestapisampewithsecurity.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a book.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    // Primary key for the book entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Author of the book, with a maximum length of 100 characters and not nullable
    @Column(length = 100, nullable = false)
    private String author;

    // Title of the book, with a maximum length of 150 characters and not nullable
    @Column(length = 150, nullable = false)
    private String title;

    // ISBN (International Standard Book Number) of the book, with a length of 13 characters and not nullable
    @Column(length = 13, nullable = false)
    private String isbn;

    // Year of publication for the book, not nullable
    @Column(nullable = false)
    private int year;

//    /**
//     * Parameterized constructor for creating a book with specified details.
//     *
//     * @param author Author of the book.
//     * @param title  Title of the book.
//     * @param isbn   ISBN of the book.
//     * @param year   Year of publication.
//     */
//    public Book(String author, String title, String isbn, int year) {
//        this.author = author;
//        this.title = title;
//        this.isbn = isbn;
//        this.year = year;
//    }

}
