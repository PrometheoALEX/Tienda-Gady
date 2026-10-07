package com.bodega.api.infrastructure.adapters.out.persistence;

import com.bodega.api.domain.model.Role;
import com.bodega.api.domain.ports.out.RolePersistencePort;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.RoleEntity;
import com.bodega.api.infrastructure.adapters.out.persistence.mapper.RolePersistenceMapper;
import com.bodega.api.infrastructure.adapters.out.persistence.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RolePersistenceAdapter implements RolePersistencePort {

    private final RoleRepository roleRepository;
    private final RolePersistenceMapper mapper;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Role save(Role role) {
        RoleEntity entity = mapper.toEntity(role);
        RoleEntity savedEntity = roleRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}