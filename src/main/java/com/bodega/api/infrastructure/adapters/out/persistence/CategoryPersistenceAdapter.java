package com.bodega.api.infrastructure.adapters.out.persistence;

import com.bodega.api.domain.model.Category;
import com.bodega.api.domain.ports.out.CategoryPersistencePort;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.CategoryEntity;
import com.bodega.api.infrastructure.adapters.out.persistence.mapper.CategoryPersistenceMapper;
import com.bodega.api.infrastructure.adapters.out.persistence.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistencePort {

    private final CategoryRepository categoryRepository;
    private final CategoryPersistenceMapper mapper;

    @Override
    public Category save(Category category) {
        CategoryEntity entity = mapper.toEntity(category);
        CategoryEntity savedEntity = categoryRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}