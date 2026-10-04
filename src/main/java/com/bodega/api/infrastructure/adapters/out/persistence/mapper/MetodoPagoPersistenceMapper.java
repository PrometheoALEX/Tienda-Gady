package com.bodega.api.infrastructure.adapters.out.persistence.mapper;

import com.bodega.api.domain.model.MetodoPago;

import com.bodega.api.infrastructure.adapters.out.persistence.entities.MetodoPagoEntity;
import org.springframework.stereotype.Component;

@Component
public class MetodoPagoPersistenceMapper {


    public MetodoPagoEntity toEntity(MetodoPago domain) {
        if (domain == null) return null;
        MetodoPagoEntity entity = new MetodoPagoEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        entity.setActivo(domain.getActivo());
        return entity;
    }

    public MetodoPago toDomain(MetodoPagoEntity entity) {
        if (entity == null) return null;
        MetodoPago domain = new MetodoPago();
        domain.setId(entity.getId());
        domain.setNombre(entity.getNombre());
        domain.setActivo(entity.getActivo());
        return domain;
    }
}
