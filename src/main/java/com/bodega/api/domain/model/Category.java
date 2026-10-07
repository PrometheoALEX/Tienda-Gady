package com.bodega.api.domain.model;

import com.bodega.api.domain.exceptions.DomainRuleException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private Long id;
    private String name;
    private Boolean active;

    public Category(String name, Boolean active) {
        this.name = name;
        this.active = active;
    }

    public static Category create(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new DomainRuleException("Category name is required");
        }

        Category category = new Category();
        category.setName(name);
        category.setActive(true);
        return category;
    }
}