package com.bodega.api.infrastructure.adapters.out.persistence;

import com.bodega.api.domain.model.Product;
import com.bodega.api.domain.ports.out.ProductPersistencePort;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.ProductEntity;
import com.bodega.api.infrastructure.adapters.out.persistence.mapper.ProductPersistenceMapper;
import com.bodega.api.infrastructure.adapters.out.persistence.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductPersistencePort {

    private final ProductRepository repository;
    private final ProductPersistenceMapper mapper;

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = mapper.toEntity(product);
        ProductEntity savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}