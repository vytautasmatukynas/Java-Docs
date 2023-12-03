package com.example.basicrestapisampewithsecurity.services.interfaces;



import com.example.basicrestapisampewithsecurity.models.Book;

import java.util.List;

/**
 * Service interface for managing Book entities, extending the BaseService.
 */
public interface BookService extends BaseService<Book> {

    /**
     * Searches for books by author or title, ignoring case.
     *
     * @param text The text to search for in author or title.
     * @return List of books matching the search criteria.
     */
    List<Book> searchBy(String text);

}
