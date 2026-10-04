package com.bodega.api.errors;

public class MetodoPagoDeletionNotAllowedException extends RuntimeException {
    public MetodoPagoDeletionNotAllowedException(String message) {
        super(message);
    }
}
