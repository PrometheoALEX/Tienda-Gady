package com.bodega.api.infrastructure.adapters.in.web.controllers;

import com.bodega.api.domain.model.Category;
import com.bodega.api.domain.ports.in.CategoryServicePort;
import com.bodega.api.infrastructure.adapters.in.web.dto.CategoryDTO;
import com.bodega.api.infrastructure.adapters.in.web.mapper.CategoryMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServicePort categoryServicePort;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<Category> categories = categoryServicePort.findAll();
        return ResponseEntity.ok(categoryMapper.toDtoList(categories));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
        Category category = categoryServicePort.findById(id);
        return ResponseEntity.ok(categoryMapper.toDto(category));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@Valid @RequestBody CategoryDTO dto) {
        Category category = categoryMapper.toDomain(dto);
        Category savedCategory = categoryServicePort.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryMapper.toDto(savedCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @Valid @RequestBody CategoryDTO dto) {
        Category category = categoryMapper.toDomain(dto);
        Category updatedCategory = categoryServicePort.update(id, category);
        return ResponseEntity.ok(categoryMapper.toDto(updatedCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        categoryServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}