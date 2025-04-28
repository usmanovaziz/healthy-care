package com.usmanov.pushyourself.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> notFound(UserNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
