package com.bodega.api.domain.ports.in;

import com.bodega.api.domain.model.Rol;

import java.util.List;

public interface RolServicePort {
    List<Rol> findAll();
    Rol findById(Long id);
    Rol save(Rol roll);
    Rol update(Long id, Rol roll);
    void deleteById(Long id);
}
