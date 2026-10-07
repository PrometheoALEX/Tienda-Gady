package com.bodega.api.infrastructure.adapters.out.persistence.mapper;

import com.bodega.api.domain.model.PaymentMethod;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.PaymentMethodEntity;
import org.springframework.stereotype.Component;

@Component
public class PaymentMethodPersistenceMapper {

    public PaymentMethodEntity toEntity(PaymentMethod domain) {
        if (domain == null) return null;
        PaymentMethodEntity entity = new PaymentMethodEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setActive(domain.getActive());
        return entity;
    }

    public PaymentMethod toDomain(PaymentMethodEntity entity) {
        if (entity == null) return null;
        PaymentMethod domain = new PaymentMethod();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        domain.setActive(entity.getActive());
        return domain;
    }
}