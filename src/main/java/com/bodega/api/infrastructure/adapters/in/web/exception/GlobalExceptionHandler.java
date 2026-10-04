package com.bodega.api.infrastructure.adapters.in.web.exception;

import com.bodega.api.domain.exceptions.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoriaNotFoundException.class)
    public ResponseEntity<ErrorResponse> CategoriaNotFoundException(CategoriaNotFoundException ex) {

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
                400,
                ex.getMessage(),
                LocalDateTime.now(),
                null);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(MetodoPagoNotFoundException.class)
    public ResponseEntity<ErrorResponse> MetodoPagoNotFoundException(MetodoPagoNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                404,
                ex.getMessage(),
                LocalDateTime.now(),
                null
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MetodoPagoDeletionNotAllowedException.class)
    public ResponseEntity<ErrorResponse> handleMetodoPagoDeletionNotAllowed(MetodoPagoDeletionNotAllowedException ex) {
        ErrorResponse error = new ErrorResponse(
                400,
                ex.getMessage(),
                LocalDateTime.now(),
                null
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RolNotFoundException.class)
    public ResponseEntity<ErrorResponse> RolNotFoundException(RolNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now(),
                null
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RolDeletionNotAllowedException.class)
    public ResponseEntity<ErrorResponse> handleRolDeletionNotAllowed(RolDeletionNotAllowedException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(), // 400 para reglas de negocio rotas
                ex.getMessage(),
                LocalDateTime.now(),
                null
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(TipoEntregaFoundException.class)
    public ResponseEntity<ErrorResponse> TipoEntregaNotFoundException(TipoEntregaFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now(),
                null
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TipoEntregaNotAllowedException.class)
    public ResponseEntity<ErrorResponse> handleTipoEntregaDeletionNotAllowed
            (TipoEntregaNotAllowedException ex) {
                ErrorResponse error = new ErrorResponse(
                        HttpStatus.BAD_REQUEST.value(), // 400 para reglas de negocio rotas
                        ex.getMessage(),
                        LocalDateTime.now(),
                        null
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
