package com.bodega.api.application.services;

import com.bodega.api.domain.exceptions.TipoEntregaFoundException;
import com.bodega.api.domain.model.TipoEntrega;
import com.bodega.api.domain.ports.in.TipoEntregaServicePort;
import com.bodega.api.domain.ports.out.TipoEntregaPersistencePort;
import org.springframework.stereotype.Service;
import java.util.List;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class TipoEntregaServiceImpl implements TipoEntregaServicePort {

    private final TipoEntregaPersistencePort persistencePort;



    @Override
    public List<TipoEntrega> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public TipoEntrega findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(() -> new TipoEntregaFoundException("TipoEntrega no encontrado con id: " + id));
    }

    @Override
    public TipoEntrega save(TipoEntrega tipoEntrega) {
        return persistencePort.save(tipoEntrega);
    }

    @Override
    public TipoEntrega update(Long id, TipoEntrega tipoEntrega) {
        this.findById(id); // Esto ya lanza la excepción si no existe
        tipoEntrega.setId(id);
        return persistencePort.save(tipoEntrega); // Asegúrate de llamar al persistencePort.save aquí
    }

    @Override
    public void deleteById(Long id) {
        TipoEntrega entrega = persistencePort.findById(id)
                .orElseThrow(() -> new TipoEntregaFoundException("TipoEntrega no encontrado con el ID: " + id));

        persistencePort.deleteById(id);
    }
}