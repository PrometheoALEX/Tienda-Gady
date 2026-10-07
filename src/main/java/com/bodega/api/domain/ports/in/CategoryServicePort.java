package com.bodega.api.domain.ports.in;

import com.bodega.api.domain.model.Category;
import java.util.List;

public interface CategoryServicePort {
    List<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    Category update(Long id, Category category);
    void deleteById(Long id);
}