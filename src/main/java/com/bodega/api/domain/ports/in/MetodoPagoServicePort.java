package com.bodega.api.domain.ports.in;



import com.bodega.api.domain.model.MetodoPago;

import java.util.List;

public interface MetodoPagoServicePort {

    List<MetodoPago> findAll();
    MetodoPago findById(Long id);
    MetodoPago save(MetodoPago metodoPago);
    MetodoPago update(Long id, MetodoPago metodoPago);
    void deleteById(Long id);
}
