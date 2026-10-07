package com.bodega.api.infrastructure.adapters.out.persistence.mapper;

import com.bodega.api.domain.model.Category;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryPersistenceMapper {

    public CategoryEntity toEntity(Category domain) {
        if (domain == null) return null;
        CategoryEntity entity = new CategoryEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setActive(domain.getActive());
        return entity;
    }

    public Category toDomain(CategoryEntity entity) {
        if (entity == null) return null;
        Category domain = new Category();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        domain.setActive(entity.getActive());
        return domain;
    }
}