package com.example.basicrestapisampewithsecurity.services.impl;


import com.example.basicrestapisampewithsecurity.models.Book;
import com.example.basicrestapisampewithsecurity.repositories.BookRepository;
import com.example.basicrestapisampewithsecurity.services.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing Book entities.
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    // Injecting BookRepository dependency through constructor
    private final BookRepository bookRepository;

    /**
     * Retrieves all books from the database.
     *
     * @return List of all books.
     */
    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    /**
     * Retrieves a book by its ID.
     *
     * @param id The ID of the book to retrieve.
     * @return Optional containing the retrieved book (if present).
     */
    @Override
    public Optional<Book> get(long id) {
        return bookRepository.findById(id);
    }

    /**
     * Deletes a book by its ID.
     *
     * @param id The ID of the book to delete.
     */
    @Override
    public void delete(long id) {
        bookRepository.deleteById(id);
    }

    /**
     * Adds a new book to the database.
     *
     * @param book The book to be added.
     * @return The added book.
     */
    @Override
    public Book add(Book book) {
        bookRepository.save(book);
        return book;
    }

    /**
     * Updates an existing book in the database.
     *
     * @param book The updated book.
     * @return The updated book.
     */
    @Override
    public Book update(Book book) {
        bookRepository.save(book);
        return book;
    }

    /**
     * Searches for books by author or title, ignoring case.
     *
     * @param text The text to search for in author or title.
     * @return List of books matching the search criteria.
     */
    @Override
    public List<Book> searchBy(String text) {
        return bookRepository.findByAuthorContainingIgnoreCaseOrTitleContainingIgnoreCase(text, text);
    }

}
