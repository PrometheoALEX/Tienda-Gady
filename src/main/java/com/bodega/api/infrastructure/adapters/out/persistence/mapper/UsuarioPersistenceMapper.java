package com.bodega.api.infrastructure.adapters.out.persistence.mapper;

import com.bodega.api.domain.model.Usuario;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioPersistenceMapper {

    private final RolPersistenceMapper rolPersistenceMapper;

    public UsuarioPersistenceMapper(RolPersistenceMapper rolPersistenceMapper) {
        this.rolPersistenceMapper = rolPersistenceMapper;
    }

    public UsuarioEntity toEntity(Usuario domain) {
        if (domain == null) return null;
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(domain.getId());
        entity.setRol(rolPersistenceMapper.toEntity(domain.getRol()));
        entity.setNombres(domain.getNombres());
        entity.setApellidos(domain.getApellidos());
        entity.setDni(domain.getDni());
        entity.setCelular(domain.getCelular());
        entity.setCorreo(domain.getCorreo());
        entity.setContrasena(domain.getContrasena());
        entity.setActivo(domain.getActivo());
        entity.setFechaRegistro(domain.getFechaRegistro());
        return entity;
    }

    public Usuario toDomain(UsuarioEntity entity) {
        if (entity == null) return null;
        Usuario domain = new Usuario();
        domain.setId(entity.getId());
        domain.setRol(rolPersistenceMapper.toDomain(entity.getRol()));
        domain.setNombres(entity.getNombres());
        domain.setApellidos(entity.getApellidos());
        domain.setDni(entity.getDni());
        domain.setCelular(entity.getCelular());
        domain.setCorreo(entity.getCorreo());
        domain.setContrasena(entity.getContrasena());
        domain.setActivo(entity.getActivo());
        domain.setFechaRegistro(entity.getFechaRegistro());
        return domain;
    }
}