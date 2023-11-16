package com.example.basicrestapisample.services.interfaces;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {

    List<T> getAll();

    Optional<T> get(long number);

    void delete(long number);

    T add(T item);

    T update(T item);

}
