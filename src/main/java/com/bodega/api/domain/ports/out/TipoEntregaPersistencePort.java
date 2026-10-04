package com.bodega.api.domain.ports.out;

import com.bodega.api.domain.model.TipoEntrega;
import java.util.List;
import java.util.Optional;

public interface TipoEntregaPersistencePort {
    List<TipoEntrega> findAll();
    Optional<TipoEntrega> findById(Long id);
    TipoEntrega save(TipoEntrega tipoEntrega);
    void deleteById(Long id);
}