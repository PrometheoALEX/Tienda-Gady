package com.bodega.api.domain.exceptions;

public class CategoryDeletionNotAllowedException extends DomainRuleException {

    public CategoryDeletionNotAllowedException(String message) {
        super(message);
    }
}
