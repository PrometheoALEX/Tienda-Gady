package com.bodega.api.infrastructure.adapters.out.persistence.mapper;

import com.bodega.api.domain.model.DeliveryType;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.DeliveryTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class DeliveryTypePersistenceMapper {

    public DeliveryTypeEntity toEntity(DeliveryType domain) {
        if (domain == null) return null;
        DeliveryTypeEntity entity = new DeliveryTypeEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());

        return entity;
    }

    public DeliveryType toDomain(DeliveryTypeEntity entity) {
        if (entity == null) return null;
        DeliveryType domain = new DeliveryType();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        return domain;
    }
}