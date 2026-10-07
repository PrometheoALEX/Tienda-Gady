package com.bodega.api.domain.exceptions;

public class PaymentMethodNotFoundException extends ResourceNotFoundException {
    public PaymentMethodNotFoundException(String message) {
        super(message);
    }
}
