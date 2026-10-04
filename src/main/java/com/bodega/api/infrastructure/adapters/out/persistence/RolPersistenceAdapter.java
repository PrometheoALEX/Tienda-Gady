package com.bodega.api.infrastructure.adapters.out.persistence;


import com.bodega.api.domain.model.Rol;
import com.bodega.api.domain.ports.out.RolPersistencePort;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.RolEntity;
import com.bodega.api.infrastructure.adapters.out.persistence.mapper.RolPersistenceMapper;
import com.bodega.api.infrastructure.adapters.out.persistence.repositories.RolRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class RolPersistenceAdapter implements RolPersistencePort {

    private final RolRepository rolRepository;
    private final RolPersistenceMapper mapper;


    @Override
    public List<Rol> findAll() {
        return rolRepository.findAll().stream()
                .map(entity -> mapper.toDomain(entity)).toList();
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return rolRepository.findById(id).map(
                entity -> mapper.toDomain(entity));
    }

    @Override
    public Rol save(Rol rol) {
        RolEntity entity = mapper.toEntity(rol);
        RolEntity savedEntity = rolRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        rolRepository.deleteById(id);
    }
}
