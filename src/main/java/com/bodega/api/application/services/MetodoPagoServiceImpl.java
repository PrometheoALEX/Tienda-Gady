package com.bodega.api.application.services;

import com.bodega.api.domain.model.MetodoPago;
import com.bodega.api.domain.ports.in.MetodoPagoServicePort;
import com.bodega.api.domain.ports.out.MetodoPagoPersistencePort;
import com.bodega.api.domain.exceptions.MetodoPagoDeletionNotAllowedException;
import com.bodega.api.domain.exceptions.MetodoPagoNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service


public class MetodoPagoServiceImpl implements MetodoPagoServicePort {

    private final MetodoPagoPersistencePort persistencePort;



    @Override
    public List<MetodoPago> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public MetodoPago findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(() -> new MetodoPagoNotFoundException("Categoria no encontrada con id: " + id));
    }

    @Override
    public MetodoPago save(MetodoPago metodoPago) {
        return persistencePort.save(metodoPago);
    }

    @Override
    public MetodoPago update(Long id, MetodoPago metodoPago) {
        this.findById(id);
        metodoPago.setId(id);
        return persistencePort.save(metodoPago);
    }

    @Override
    public void deleteById(Long id) {

        MetodoPago metodoPago = persistencePort.findById(id)
                .orElseThrow(() -> new MetodoPagoNotFoundException("Método de pago no encontrado con el ID: " + id));

        if (Boolean.TRUE.equals(metodoPago.getActivo())) {
            throw new MetodoPagoDeletionNotAllowedException("No se puede eliminar el método de pago porque está activo");
        }

        persistencePort.deleteById(id);
    }
}