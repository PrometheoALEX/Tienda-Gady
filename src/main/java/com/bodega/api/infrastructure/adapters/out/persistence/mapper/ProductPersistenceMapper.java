package com.bodega.api.infrastructure.adapters.out.persistence.mapper;

import com.bodega.api.domain.model.Product;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductPersistenceMapper {

    private final CategoryPersistenceMapper categoryMapper;

    public ProductPersistenceMapper(CategoryPersistenceMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public ProductEntity toEntity(Product domain) {
        if (domain == null) return null;
        ProductEntity entity = new ProductEntity();
        entity.setId(domain.getId());
        entity.setCategory(categoryMapper.toEntity(domain.getCategory()));
        entity.setName(domain.getName());
        entity.setDescription(domain.getDescription());
        entity.setPrice(domain.getPrice());
        entity.setStock(domain.getStock());
        entity.setImage(domain.getImage());
        entity.setDiscount(domain.getDiscount());
        entity.setActive(domain.getActive());
        return entity;
    }

    public Product toDomain(ProductEntity entity) {
        if (entity == null) return null;
        Product domain = new Product();
        domain.setId(entity.getId());
        domain.setCategory(categoryMapper.toDomain(entity.getCategory()));
        domain.setName(entity.getName());
        domain.setDescription(entity.getDescription());
        domain.setPrice(entity.getPrice());
        domain.setStock(entity.getStock());
        domain.setImage(entity.getImage());
        domain.setDiscount(entity.getDiscount());
        domain.setActive(entity.getActive());
        return domain;
    }

    public List<Product> toDomainList(List<ProductEntity> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public List<ProductEntity> toEntityList(List<Product> domains) {
        if (domains == null) return null;
        return domains.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}