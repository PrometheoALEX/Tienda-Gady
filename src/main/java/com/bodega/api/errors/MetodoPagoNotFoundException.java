package com.bodega.api.errors;

public class MetodoPagoNotFoundException extends RuntimeException {
    public MetodoPagoNotFoundException(String message) {
        super(message);
    }
}
