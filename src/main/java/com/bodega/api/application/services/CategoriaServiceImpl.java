package com.bodega.api.application.services;

import com.bodega.api.domain.model.Categoria;
import com.bodega.api.domain.ports.in.CategoriaServicePort;
import com.bodega.api.domain.ports.out.CategoriaPersistencePort;
import com.bodega.api.domain.exceptions.CategoriaNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//La clase se enlaza al contrato de salida de ports
public class CategoriaServiceImpl implements CategoriaServicePort {

    private final CategoriaPersistencePort persistencePort;

    public CategoriaServiceImpl(CategoriaPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public List<Categoria> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Categoria findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(() -> new CategoriaNotFoundException("Categoria no encontrada con id: " + id));
    }

    @Override
    public Categoria save(Categoria categoria) {

        return persistencePort.save(categoria);
    }


    @Override
    public Categoria update(Long id, Categoria categoria) {
        this.findById(id);
        categoria.setId(id);
        return persistencePort.save(categoria);
    }

    @Override
    public void deleteById(Long id) {
        this.findById(id);
        persistencePort.deleteById(id);
    }
}