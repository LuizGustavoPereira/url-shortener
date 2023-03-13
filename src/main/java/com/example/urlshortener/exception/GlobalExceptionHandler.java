package com.example.urlshortener.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidUrlException.class)
    public ResponseEntity<String> handleMyException(InvalidUrlException ex) {
        // log the error
        log.error("An error occurred: {}", ex.getMessage());

        // return an error response
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .header("X-Error-Message", ex.getMessage())
                .body("An error occurred: " + ex.getMessage());
    }
}
