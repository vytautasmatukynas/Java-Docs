package com.example.exceptionhandling.exceptions;

import org.springframework.http.HttpStatus;

/**
 * This class represents a custom runtime exception that is thrown when a user is not found.
 */
public class UserNotFoundException extends RuntimeException{

    private final HttpStatus status;

    /**
     * Constructs a new UserNotFoundException with the specified HTTP status and message.
     * @param status The HTTP status code associated with the exception.
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     */
    public UserNotFoundException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    /**
     * Constructs a new UserNotFoundException with the specified HTTP status, message, and cause.
     * @param status The HTTP status code associated with the exception.
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     * @param cause The cause (which is saved for later retrieval by the getCause() method).
     */
    public UserNotFoundException(HttpStatus status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    /**
     * Constructs a new UserNotFoundException with the specified HTTP status and cause.
     * @param status The HTTP status code associated with the exception.
     * @param cause The cause (which is saved for later retrieval by the getCause() method).
     */
    public UserNotFoundException(HttpStatus status, Throwable cause) {
        super(cause);
        this.status = status;
    }
}