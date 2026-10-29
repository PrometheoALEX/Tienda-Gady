package com.bodega.api.application.services;

import com.bodega.api.domain.exceptions.ProductDeletionNotAllowedException;
import com.bodega.api.domain.exceptions.ProductNotFoundException;
import com.bodega.api.domain.model.Product;
import com.bodega.api.domain.ports.in.ProductServicePort;
import com.bodega.api.domain.ports.out.ProductPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductServicePort {

    private final ProductPersistencePort persistencePort;

    @Override
    public List<Product> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Product findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    @Override
    public Product save(Product product) {
        return persistencePort.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        this.findById(id);
        product.setId(id);
        return persistencePort.save(product);
    }

    @Override
    public void deleteById(Long id) {
        Product product = this.findById(id);

        if (Boolean.TRUE.equals(product.getActive())) {
            throw new ProductDeletionNotAllowedException("Cannot delete product because it is active");
        }

        persistencePort.deleteById(id);
    }
}