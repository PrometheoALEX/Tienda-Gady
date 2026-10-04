package com.bodega.api.domain.exceptions;

public class TipoEntregaNotAllowedException extends RuntimeException {
    public TipoEntregaNotAllowedException(String message) {
        super(message);
    }
}
