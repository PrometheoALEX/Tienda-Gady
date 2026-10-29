package com.bodega.api.domain.ports.out;

import com.bodega.api.domain.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductPersistencePort {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
}