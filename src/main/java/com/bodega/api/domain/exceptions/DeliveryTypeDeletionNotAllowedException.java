package com.bodega.api.domain.exceptions;

public class DeliveryTypeDeletionNotAllowedException extends DomainRuleException {
    public DeliveryTypeDeletionNotAllowedException(String message) {
        super(message);
    }
}
