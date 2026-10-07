package com.bodega.api.domain.model;

import com.bodega.api.domain.exceptions.DomainRuleException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void shouldThrowExceptionWhenNameIsEmpty() {

        String invalidName = "";

        DomainRuleException exception = assertThrows(
                DomainRuleException.class,
                () -> Category.create(invalidName)
        );

        assertEquals("Category name is required", exception.getMessage());
    }

    @Test
    void shouldCreateCategoryWhenNameIsValid() {
        String validName = "Dairy";

        Category result = Category.create(validName);

        assertNotNull(result);
        assertEquals("Dairy", result.getName());
    }
}