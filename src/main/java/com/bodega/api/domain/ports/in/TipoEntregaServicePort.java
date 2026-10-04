package com.bodega.api.domain.ports.in;

import com.bodega.api.domain.model.TipoEntrega;
import java.util.List;

public interface TipoEntregaServicePort {
    List<TipoEntrega> findAll();
    TipoEntrega findById(Long id);
    TipoEntrega save(TipoEntrega tipoEntrega);
    TipoEntrega update(Long id, TipoEntrega tipoEntrega);
    void deleteById(Long id);
}