package com.bodega.api.domain.exceptions;

public class PaymentMethodDeletionNotAllowedException extends DomainRuleException {
    public PaymentMethodDeletionNotAllowedException(String message) {
        super(message);
    }
}
