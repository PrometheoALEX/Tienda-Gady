package com.bodega.api.infrastructure.adapters.out.persistence.mapper;

import com.bodega.api.domain.model.Role;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RolePersistenceMapper {

    public RoleEntity toEntity(Role domain) {
        if (domain == null) return null;
        RoleEntity entity = new RoleEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setActive(domain.getActive());
        return entity;
    }

    public Role toDomain(RoleEntity entity) {
        if (entity == null) return null;
        Role domain = new Role();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        domain.setActive(entity.getActive());
        return domain;
    }
}