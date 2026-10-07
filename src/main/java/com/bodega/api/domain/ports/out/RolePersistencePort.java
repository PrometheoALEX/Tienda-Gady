package com.bodega.api.domain.ports.out;

import com.bodega.api.domain.model.Role;
import java.util.List;
import java.util.Optional;

public interface RolePersistencePort {
    List<Role> findAll();
    Optional<Role> findById(Long id);
    Role save(Role role);
    void deleteById(Long id);
}