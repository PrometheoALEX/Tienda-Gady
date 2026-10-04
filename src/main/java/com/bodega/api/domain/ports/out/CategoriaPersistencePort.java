package com.bodega.api.domain.ports.out;

import com.bodega.api.domain.model.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaPersistencePort {
    List<Categoria> findAll();
    Optional<Categoria> findById(Long id);
    Categoria save(Categoria categoria);
    void deleteById(Long id);
}