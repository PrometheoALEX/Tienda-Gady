package com.bodega.api.domain.exceptions;

public class MetodoPagoNotFoundException extends RuntimeException {
    public MetodoPagoNotFoundException(String message) {
        super(message);
    }
}
