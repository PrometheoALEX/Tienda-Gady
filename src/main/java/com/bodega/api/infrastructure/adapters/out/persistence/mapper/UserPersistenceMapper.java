package com.bodega.api.infrastructure.adapters.out.persistence.mapper;

import com.bodega.api.domain.model.User;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceMapper {

    private final RolePersistenceMapper rolePersistenceMapper;

    public UserPersistenceMapper(RolePersistenceMapper rolePersistenceMapper) {
        this.rolePersistenceMapper = rolePersistenceMapper;
    }

    public UserEntity toEntity(User domain) {
        if (domain == null) return null;
        UserEntity entity = new UserEntity();
        entity.setId(domain.getId());
        entity.setRole(rolePersistenceMapper.toEntity(domain.getRole()));
        entity.setFirstName(domain.getFirstName());
        entity.setLastName(domain.getLastName());
        entity.setDni(domain.getDni());
        entity.setPhone(domain.getPhone());
        entity.setEmail(domain.getEmail());
        entity.setPassword(domain.getPassword());
        entity.setActive(domain.getActive());
        entity.setRegistrationDate(domain.getRegistrationDate());
        return entity;
    }

    public User toDomain(UserEntity entity) {
        if (entity == null) return null;
        User domain = new User();
        domain.setId(entity.getId());
        domain.setRole(rolePersistenceMapper.toDomain(entity.getRole()));
        domain.setFirstName(entity.getFirstName());
        domain.setLastName(entity.getLastName());
        domain.setDni(entity.getDni());
        domain.setPhone(entity.getPhone());
        domain.setEmail(entity.getEmail());
        domain.setPassword(entity.getPassword());
        domain.setActive(entity.getActive());
        domain.setRegistrationDate(entity.getRegistrationDate());
        return domain;
    }
}