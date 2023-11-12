package lt.codeacademy.javau7.Biblioteka.errorHandler;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ApiError(HttpStatus status, String message, List<String> errors) { }

