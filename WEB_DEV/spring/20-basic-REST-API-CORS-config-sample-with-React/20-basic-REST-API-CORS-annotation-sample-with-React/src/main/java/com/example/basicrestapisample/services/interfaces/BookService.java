package com.example.basicrestapisample.services.interfaces;

import com.example.basicrestapisample.models.Book;

import java.util.List;

public interface BookService extends BaseService<Book> {

    List<Book> searchBy(String text);

}
