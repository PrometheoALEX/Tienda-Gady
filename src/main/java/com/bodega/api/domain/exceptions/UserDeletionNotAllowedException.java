package com.bodega.api.domain.exceptions;

public class UserDeletionNotAllowedException extends DomainRuleException {
    public UserDeletionNotAllowedException(String message) {
        super(message);
    }
}