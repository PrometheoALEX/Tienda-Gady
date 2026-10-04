package com.bodega.api.errors;

public class CategoriaDeletionNotAllowedException extends RuntimeException {

    public CategoriaDeletionNotAllowedException(String message) {
        super(message);
    }
}
