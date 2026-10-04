package com.bodega.api.application.services;

import com.bodega.api.domain.model.Rol;
import com.bodega.api.domain.ports.in.RolServicePort;
import com.bodega.api.domain.ports.out.RolPersistencePort;
import com.bodega.api.domain.exceptions.RolNotFoundException;
import com.bodega.api.domain.exceptions.RolDeletionNotAllowedException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolServiceImpl implements RolServicePort {

    private final RolPersistencePort persistencePort;

    public RolServiceImpl(RolPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public List<Rol> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Rol findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(() -> new RolNotFoundException("Rol no encontrado con id: " + id));
    }

    @Override
    public Rol save(Rol rol) {
        return persistencePort.save(rol);
    }

    @Override
    public Rol update(Long id, Rol rol) {
        this.findById(id);
        rol.setId(id);
        return persistencePort.save(rol);
    }

    @Override
    public void deleteById(Long id) {
        Rol rol = persistencePort.findById(id)
                .orElseThrow(() -> new RolNotFoundException("Rol no encontrado con el ID: " + id));

        if (Boolean.TRUE.equals(rol.getActivo())) {
            throw new RolDeletionNotAllowedException("No se puede eliminar el rol porque está activo");
        }
        persistencePort.deleteById(id);
    }
}