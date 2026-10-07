package com.bodega.api.domain.exceptions;

public class DeliveryTypeNotFoundException extends ResourceNotFoundException {
    public DeliveryTypeNotFoundException(String message) {
        super(message);
    }
}
