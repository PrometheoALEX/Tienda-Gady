package com.bodega.api.domain.ports.in;

import com.bodega.api.domain.model.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaServicePort {
    List<Categoria> findAll();
    Categoria findById(Long id);
    Categoria save(Categoria categoria);
    Categoria update(Long id, Categoria categoria);
    void deleteById(Long id);
}