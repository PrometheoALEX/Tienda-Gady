package com.bodega.api.exception;

import com.bodega.api.exception.ErrorResponse;
import com.bodega.api.errors.CategoriaDeletionNotAllowedException;
import com.bodega.api.errors.CategoriaNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoriaNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCategoriaNotFound(CategoriaNotFoundException ex) {

        ErrorResponse error = new ErrorResponse(
                    404,
                    ex.getMessage(),
                    LocalDateTime.now(),
                    null);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(CategoriaDeletionNotAllowedException.class)
    public ResponseEntity<ErrorResponse> handleDeletionNotAllowed(CategoriaDeletionNotAllowedException ex) {
        ErrorResponse error = new ErrorResponse(
                404,
                ex.getMessage(),
                LocalDateTime.now(),
                null);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
