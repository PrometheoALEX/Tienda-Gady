package com.bodega.api.domain.exceptions;

public class CategoriaDeletionNotAllowedException extends RuntimeException {

    public CategoriaDeletionNotAllowedException(String message) {
        super(message);
    }
}
