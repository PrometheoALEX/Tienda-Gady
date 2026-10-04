package com.bodega.api.infrastructure.adapters.out.persistence.mapper;

import com.bodega.api.domain.model.Rol;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.RolEntity;
import org.springframework.stereotype.Component;

@Component
public class RolPersistenceMapper {

    public RolEntity toEntity(Rol domain) {
        if (domain == null) return null;
        RolEntity entity = new RolEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        entity.setActivo(domain.getActivo());
        return entity;
    }

    public Rol toDomain(RolEntity entity) {
        if (entity == null) return null;
        Rol domain = new Rol();
        domain.setId(entity.getId());
        domain.setNombre(entity.getNombre());
        domain.setActivo(entity.getActivo());
        return domain;
    }

}
