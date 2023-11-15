package com.example.exceptionhandling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice is an annotation that allows you to handle exceptions globally
// across the whole application in a centralized way.
@ControllerAdvice
public class UserRestExceptionHandler {

    /*
    @ExceptionHandler is an annotation that declares a method as an exception handler
    for the specified exception type.

    @ExceptionHandler(UserNotFoundException.class) in a class annotated with @ControllerAdvice designates
    a method that handles exceptions of type UserNotFoundException globally, allowing custom responses, and
    it is invoked when this exception occurs during request processing in any controller of a Spring application.

    The method handles UserNotFoundException and returns a ResponseEntity with ApiErrorDTO and
    handles Exception and returns a ResponseEntity with ApiErrorDTO.
    */

    // Throws this if NOT_FOUND 404 error
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiErrorDTO> handleUserNotFoundException(UserNotFoundException exc) {
        // Creating an ApiErrorDTO using the createErrorResponse method.
        ApiErrorDTO error = createErrorResponse(HttpStatus.NOT_FOUND,
                                                exc.getMessage(),
                                                System.currentTimeMillis());

        // Returning a ResponseEntity with the ApiErrorDTO and HTTP status NOT_FOUND.
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Throws this if INTERNAL_SERVER_ERROR 500
    // Another exception handler method, handling generic Exception.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorDTO> handleGeneralException(Exception exc) {
        // Creating an ApiErrorDTO for the generic exception.
        ApiErrorDTO error = createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                                        "An unexpected error occurred",
                                                System.currentTimeMillis());

        // Returning a ResponseEntity with the ApiErrorDTO and HTTP status INTERNAL_SERVER_ERROR.
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Create an instance of ApiErrorDTO.
    private ApiErrorDTO createErrorResponse(HttpStatus status, String message, Long timeStamp) {
        ApiErrorDTO error = new ApiErrorDTO();

        error.setStatus(status.value());
        error.setMessage(message);
        error.setTimeStamp(timeStamp);

        // Returning the ApiErrorDTO.
        return error;
    }

}
