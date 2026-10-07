package com.bodega.api.infrastructure.adapters.out.persistence;

import com.bodega.api.domain.model.User;
import com.bodega.api.domain.ports.out.UserPersistencePort;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.UserEntity;
import com.bodega.api.infrastructure.adapters.out.persistence.mapper.UserPersistenceMapper;
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
        UserEntity savedEntity = userRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}