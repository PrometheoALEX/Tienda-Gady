package com.bodega.api.domain.exceptions;

public class ProductDeletionNotAllowedException extends DomainRuleException {

    public ProductDeletionNotAllowedException(String message) {
        super(message);
    }
}