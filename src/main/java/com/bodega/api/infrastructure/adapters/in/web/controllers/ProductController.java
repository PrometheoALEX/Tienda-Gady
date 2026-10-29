package com.bodega.api.infrastructure.adapters.in.web.controllers;

import com.bodega.api.domain.model.Product;
import com.bodega.api.domain.ports.in.ProductServicePort;
import com.bodega.api.infrastructure.adapters.in.web.dto.ProductDTO;
import com.bodega.api.infrastructure.adapters.in.web.mapper.ProductMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServicePort productServicePort;
    private final ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<Product> products = productServicePort.findAll();
        return ResponseEntity.ok(productMapper.toDtoList(products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        Product product = productServicePort.findById(id);
        return ResponseEntity.ok(productMapper.toDto(product));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> save(@Valid @RequestBody ProductDTO dto) {
        Product product = productMapper.toDomain(dto);
        Product savedProduct = productServicePort.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.toDto(savedProduct));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto) {
        Product product = productMapper.toDomain(dto);
        Product updatedProduct = productServicePort.update(id, product);
        return ResponseEntity.ok(productMapper.toDto(updatedProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        productServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}