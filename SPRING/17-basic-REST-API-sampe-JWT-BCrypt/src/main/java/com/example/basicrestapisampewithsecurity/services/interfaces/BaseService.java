package com.example.basicrestapisampewithsecurity.services.interfaces;

import java.util.List;
import java.util.Optional;

/**
 * Base service interface for common CRUD operations on entities.
 *
 * @param <T> The type of entity.
 */
public interface BaseService<T> {

    /**
     * Retrieves all entities of type T.
     *
     * @return List of all entities.
     */
    List<T> getAll();

    /**
     * Retrieves an entity by its unique identifier.
     *
     * @param id The unique identifier of the entity to retrieve.
     * @return Optional containing the retrieved entity (if present).
     */
    Optional<T> get(long id);

    /**
     * Deletes an entity by its unique identifier.
     *
     * @param id The unique identifier of the entity to delete.
     */
    void delete(long id);

    /**
     * Adds a new entity to the system.
     *
     * @param item The entity to be added.
     * @return The added entity.
     */
    T add(T item);

    /**
     * Updates an existing entity in the system.
     *
     * @param item The updated entity.
     * @return The updated entity.
     */
    T update(T item);

}
