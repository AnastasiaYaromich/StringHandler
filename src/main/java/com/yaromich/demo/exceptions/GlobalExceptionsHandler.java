package com.yaromich.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsHandler {
    @ExceptionHandler
    public ResponseEntity<AppError> handleResourceNotFoundException(StringFormatException e) {
        return new ResponseEntity<>(new AppError("INVALID_STRING_FORMAT", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
