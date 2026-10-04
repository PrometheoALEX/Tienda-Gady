package com.bodega.api.infrastructure.adapters.out.persistence.mapper;

import com.bodega.api.domain.model.Categoria;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.CategoriaEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoriaPersistenceMapper {
    public CategoriaEntity toEntity(Categoria domain) {
        if (domain == null) return null;
        CategoriaEntity entity = new CategoriaEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        entity.setActivo(domain.getActivo());
        return entity;
    }

    public Categoria toDomain(CategoriaEntity entity) {
        if (entity == null) return null;
        Categoria domain = new Categoria();
        domain.setId(entity.getId());
        domain.setNombre(entity.getNombre());
        domain.setActivo(entity.getActivo());
        return domain;
    }


}
