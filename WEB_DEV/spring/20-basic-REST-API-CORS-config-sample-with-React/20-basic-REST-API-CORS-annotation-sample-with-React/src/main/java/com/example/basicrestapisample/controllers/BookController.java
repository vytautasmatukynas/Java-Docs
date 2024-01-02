package com.example.basicrestapisample.controllers;

import com.example.basicrestapisample.models.Book;
import com.example.basicrestapisample.services.interfaces.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Controller class for managing Book entities through RESTful APIs.
 * Utilizes CrossOrigin annotations to handle CORS configuration.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private static final String CORS_URL = "http://localhost:3000";

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @CrossOrigin(origins = CORS_URL, methods = RequestMethod.GET)
    @GetMapping("/getall")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAll();
        return ResponseEntity.ok(books);
    }

    @CrossOrigin(origins = CORS_URL, methods = RequestMethod.GET)
    @GetMapping("/get/{id}")
    public ResponseEntity<Book> getBook(@PathVariable long id) {
        return bookService.get(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No book with this ID: " + id));
    }

    @CrossOrigin(origins = CORS_URL, methods = RequestMethod.GET)
    @GetMapping("/search/{text}")
    public ResponseEntity<List<Book>> searchBook(@PathVariable String text) {
        List<Book> books = bookService.searchBy(text);

        if (books.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No book that you are searching. Please try again.");

        return ResponseEntity.ok(books);
    }

    @CrossOrigin(origins = CORS_URL, methods = RequestMethod.DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable long id) {
        return bookService.get(id)
                .map(book -> {
                    bookService.delete(id);
                    return ResponseEntity.ok(String.format(
                            "Message: Book \"%s - %s\" deleted successfully.",
                            book.getAuthor(), book.getTitle()));
                })
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "There is no Book with this ID: " + id));
    }

    @CrossOrigin(origins = CORS_URL, methods = RequestMethod.POST)
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        try {
            Book addedBook = bookService.add(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error adding new Book", e);
        }
    }

    @CrossOrigin(origins = CORS_URL, methods = RequestMethod.PUT)
    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book bookUpdate) {
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
    }

}
