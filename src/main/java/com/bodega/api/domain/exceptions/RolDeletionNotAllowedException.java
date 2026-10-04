package com.bodega.api.domain.exceptions;

public class RolDeletionNotAllowedException extends RuntimeException {
    public RolDeletionNotAllowedException(String message) {
        super(message);

    }
}
