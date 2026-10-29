package com.bodega.api.domain.ports.in;

import com.bodega.api.domain.model.Product;
import java.util.List;

public interface ProductServicePort {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    Product update(Long id, Product product);
    void deleteById(Long id);
}