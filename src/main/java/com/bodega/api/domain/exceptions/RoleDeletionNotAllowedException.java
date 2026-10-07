package com.bodega.api.domain.exceptions;

public class RoleDeletionNotAllowedException extends DomainRuleException {
    public RoleDeletionNotAllowedException(String message) {
        super(message);

    }
}
