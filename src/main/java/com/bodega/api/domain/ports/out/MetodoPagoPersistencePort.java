package com.bodega.api.domain.ports.out;

import com.bodega.api.domain.model.MetodoPago;
import java.util.List;
import java.util.Optional;

public interface MetodoPagoPersistencePort {
    List<MetodoPago> findAll();
    Optional<MetodoPago> findById(Long id);
    MetodoPago save(MetodoPago metodoPago);
    void deleteById(Long id);
}
