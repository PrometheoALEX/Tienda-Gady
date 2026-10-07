package com.bodega.api.application.services;

import com.bodega.api.domain.exceptions.CategoryDeletionNotAllowedException;
import com.bodega.api.domain.exceptions.CategoryNotFoundException;
import com.bodega.api.domain.model.Category;
import com.bodega.api.domain.ports.in.CategoryServicePort;
import com.bodega.api.domain.ports.out.CategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryServicePort {

    private final CategoryPersistencePort persistencePort;

    @Override
    public List<Category> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Category findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
    }

    @Override
    public Category save(Category category) {
        return persistencePort.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        this.findById(id);
        category.setId(id);
        return persistencePort.save(category);
    }

    @Override
    public void deleteById(Long id) {
        Category category = this.findById(id);

        if (Boolean.TRUE.equals(category.getActive())) {
            throw new CategoryDeletionNotAllowedException("Cannot delete category because it is active");
        }

        persistencePort.deleteById(id);
    }
}