package com.bodega.api.domain.model;

import com.bodega.api.domain.exceptions.DomainRuleException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void shouldThrowExceptionWhenFirstNameIsEmpty() {
        Role role = new Role(1L, "CLIENT", true);
        String validDni = "71234567";
        String invalidFirstName = "";

        DomainRuleException exception = assertThrows(
                DomainRuleException.class,
                () -> User.create(role, invalidFirstName, "Gómez", validDni, "maria@gmail.com", "pass123")
        );

        assertEquals("First name is required", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenDniIsShort() {
        Role role = new Role(1L, "CLIENT", true);
        String invalidDni = "12345";

        DomainRuleException exception = assertThrows(
                DomainRuleException.class,
                () -> User.create(role, "María", "Gómez", invalidDni, "maria@gmail.com", "pass123")
        );

        assertEquals("DNI is required and must contain exactly 8 digits", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenDniIsNullOrEqualToEmpty() {
        Role role = new Role(1L, "CLIENT", true);
        String invalidDni = "";

        DomainRuleException exception = assertThrows(
                DomainRuleException.class,
                () -> User.create(role, "María", "Gómez", invalidDni, "maria@gmail.com", "pass123")
        );

        assertEquals("DNI is required and must contain exactly 8 digits", exception.getMessage());
    }
}