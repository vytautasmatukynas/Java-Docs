package com.example.basicrestapisampewithsecurity.repositories;

import com.example.basicrestapisampewithsecurity.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Book entities in the database.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * Custom query method to find books by author or title, ignoring case.
     *
     * @param author Author's name (case-insensitive).
     * @param title  Title of the book (case-insensitive).
     * @return List of books matching the criteria.
     */
    List<Book> findByAuthorContainingIgnoreCaseOrTitleContainingIgnoreCase(String author, String title);

}
