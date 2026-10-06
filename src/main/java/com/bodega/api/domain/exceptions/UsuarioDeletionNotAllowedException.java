package com.bodega.api.domain.exceptions;

public class UsuarioDeletionNotAllowedException extends RuntimeException {
    public UsuarioDeletionNotAllowedException(String message) {
        super(message);
    }
}