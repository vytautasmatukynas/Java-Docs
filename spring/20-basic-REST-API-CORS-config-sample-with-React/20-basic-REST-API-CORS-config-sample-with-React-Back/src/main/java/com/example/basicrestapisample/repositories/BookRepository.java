package com.example.basicrestapisample.repositories;

import com.example.basicrestapisample.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthorContainingIgnoreCaseOrTitleContainingIgnoreCase(String author, String title);


}
