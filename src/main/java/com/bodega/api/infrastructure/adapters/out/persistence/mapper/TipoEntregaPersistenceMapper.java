package com.bodega.api.infrastructure.adapters.out.persistence.mapper;

import com.bodega.api.domain.model.TipoEntrega;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.TipoEntregaEntity;
import org.springframework.stereotype.Component;

@Component
public class TipoEntregaPersistenceMapper {

    public TipoEntregaEntity toEntity(TipoEntrega domain) {
        if (domain == null) return null;
        TipoEntregaEntity entity = new TipoEntregaEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());

        return entity;
    }

    public TipoEntrega toDomain(TipoEntregaEntity entity) {
        if (entity == null) return null;
        TipoEntrega domain = new TipoEntrega();
        domain.setId(entity.getId());
        domain.setNombre(entity.getNombre());
        return domain;
    }
}
