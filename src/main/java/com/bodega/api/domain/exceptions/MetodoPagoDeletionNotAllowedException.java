package com.bodega.api.domain.exceptions;

public class MetodoPagoDeletionNotAllowedException extends RuntimeException {
    public MetodoPagoDeletionNotAllowedException(String message) {
        super(message);
    }
}
