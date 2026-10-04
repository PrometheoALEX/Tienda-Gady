package com.bodega.api.domain.ports.out;


import com.bodega.api.domain.model.Rol;

import java.util.List;
import java.util.Optional;

public interface RolPersistencePort {
    List<Rol> findAll();
    Optional<Rol> findById(Long id);
    Rol save(Rol roll);
    void deleteById(Long id);
}
