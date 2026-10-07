package com.bodega.api.domain.ports.out;

import com.bodega.api.domain.model.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryPersistencePort {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    Category save(Category category);
    void deleteById(Long id);
}