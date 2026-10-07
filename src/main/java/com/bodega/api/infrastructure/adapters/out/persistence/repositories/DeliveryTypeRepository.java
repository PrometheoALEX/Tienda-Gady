package com.bodega.api.infrastructure.adapters.out.persistence.repositories;

import com.bodega.api.infrastructure.adapters.out.persistence.entities.DeliveryTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryTypeRepository extends JpaRepository<DeliveryTypeEntity, Long> {
}