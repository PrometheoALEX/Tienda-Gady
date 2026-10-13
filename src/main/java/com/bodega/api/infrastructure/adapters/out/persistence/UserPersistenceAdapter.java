package com.bodega.api.infrastructure.adapters.out.persistence;

import com.bodega.api.domain.model.User;
import com.bodega.api.domain.ports.out.UserPersistencePort;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.RoleEntity;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.UserEntity;
import com.bodega.api.infrastructure.adapters.out.persistence.mapper.UserPersistenceMapper;
import com.bodega.api.infrastructure.adapters.out.persistence.repositories.RoleRepository;
import com.bodega.api.infrastructure.adapters.out.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserPersistenceMapper mapper;
    private final RoleRepository roleRepository;


    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity entity = mapper.toEntity(user);

        // 2. Si el usuario trae un rol con ID, lo buscamos completo de la BD para asegurar que su nombre ("ADMIN") no viaje nulo
        if (entity.getRole() != null && entity.getRole().getId() != null) {
            RoleEntity managedRole = roleRepository.findById(entity.getRole().getId())
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + entity.getRole().getId()));
            entity.setRole(managedRole); // Asignamos el rol completo y gestionado por Hibernate
        }

        UserEntity savedEntity = userRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}