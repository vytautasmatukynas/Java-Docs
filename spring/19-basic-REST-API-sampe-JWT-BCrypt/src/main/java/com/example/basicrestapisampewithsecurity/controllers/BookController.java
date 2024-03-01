package com.example.basicrestapisampewithsecurity.controllers;


import com.example.basicrestapisampewithsecurity.models.Book;
import com.example.basicrestapisampewithsecurity.services.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Controller class for handling Book-related operations through REST endpoints.
 */
@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    // Injecting BookService dependency through constructor
    private final BookService bookService;

    /**
     * Endpoint to retrieve all books.
     *
     * @return ResponseEntity with a list of all books.
     */
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        // Retrieve all books from the service
        List<Book> books = bookService.getAll();
        // Return a response with the list of books
        return ResponseEntity.ok(books);
    }

    /**
     * Endpoint to retrieve a specific book by ID.
     *
     * @param id The ID of the book to retrieve.
     * @return ResponseEntity with the retrieved book or a not found exception.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable long id) {
        // Retrieve the book by ID and return it in the response
        return bookService.get(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No book with this ID: " + id));
    }

    /**
     * Endpoint to search for books by text.
     *
     * @param text The text to search for in book titles or authors.
     * @return ResponseEntity with a list of matching books or a not found exception.
     */
    @GetMapping("search/{text}")
    public ResponseEntity<List<Book>> searchBook(@PathVariable String text) {
        // Get the current authentication details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if the user has ADMIN or USER role
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN") ||
                r.getAuthority().equals("USER"))) {

            // Search for books based on the provided text
            List<Book> books = bookService.searchBy(text);

            // If no books are found, throw a not found exception
            if (books.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No book that you are searching. Please try again.");

            // Return a response with the list of matching books
            return ResponseEntity.ok(books);

        } else {
            // If the user doesn't have sufficient privileges, throw a forbidden exception
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied. Insufficient privileges.");
        }
    }

    /**
     * Endpoint to delete a book by ID.
     *
     * @param id The ID of the book to delete.
     * @return ResponseEntity with a success message or a not found exception.
     */
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable long id) {
        // Get the current authentication details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if the user has ADMIN role
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN"))) {

            // Retrieve the book by ID, delete it, and return a success message
            return bookService.get(id)
                    .map(book -> {
                        bookService.delete(id);
                        return ResponseEntity.ok(String.format(
                                "Message: Book \"%s - %s\" deleted successfully.",
                                book.getAuthor(), book.getTitle()));
                    })
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "There is no Book with this ID: " + id));

        } else {
            // If the user doesn't have sufficient privileges, throw a forbidden exception
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied. Insufficient privileges.");
        }
    }

    /**
     * Endpoint to add a new book.
     *
     * @param book The Book object to be added.
     * @return ResponseEntity with the added book or an internal server error exception.
     */
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        // Get the current authentication details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if the user has ADMIN role
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN"))) {

            try {
                // Attempt to add the new book and return a response with the added book
                Book addedBook = bookService.add(book);
                return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);

            } catch (Exception e) {
                // If an error occurs during the addition, throw an internal server error
                throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR, "Error adding new Book", e);
            }

        } else {
            // If the user doesn't have sufficient privileges, throw a forbidden exception
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied. Insufficient privileges.");
        }
    }

    /**
     * Endpoint to update an existing book.
     *
     * @param id The ID of the book to update.
     * @param bookUpdate The updated Book object.
     * @return ResponseEntity with the updated book or a not found exception.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book bookUpdate) {
        // Get the current authentication details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if the user has ADMIN role
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN"))) {

            // Retrieve the existing book by ID, update its details, and return the updated book
            return bookService.get(id)
                    .map(existingBook -> {
                        existingBook.setTitle(bookUpdate.getTitle());
                        existingBook.setAuthor(bookUpdate.getAuthor());
                        existingBook.setIsbn(bookUpdate.getIsbn());
                        existingBook.setYear(bookUpdate.getYear());

                        Book updatedBook = bookService.update(existingBook);

                        return ResponseEntity.ok(updatedBook);
                    })
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "There is no Book with this ID: " + id));

        } else {
            // If the user doesn't have sufficient privileges, throw a forbidden exception
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied. Insufficient privileges.");
        }
    }

}
