package com.bodega.api.infrastructure.adapters.out.persistence.repositories;

import com.bodega.api.infrastructure.adapters.out.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}