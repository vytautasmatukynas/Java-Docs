import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    // Global exception handler for general exceptions
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        ApiError apiError = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getLocalizedMessage(),
                Collections.singletonList("A general error has occurred"));
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.status());
    }

    // Custom exception handler for a specific type of exception (e.g., CustomNotFoundException)
    @ExceptionHandler({CustomNotFoundException.class})
    public ResponseEntity<Object> handleCustomNotFoundException(CustomNotFoundException ex, WebRequest request) {
        ApiError apiError = new ApiError(
                HttpStatus.NOT_FOUND,
                ex.getLocalizedMessage(),
                Collections.singletonList("Resource not found"));
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.status());
    }
}
