package com.bodega.api.infrastructure.adapters.out.persistence;

import com.bodega.api.domain.model.Categoria;
import com.bodega.api.domain.ports.out.CategoriaPersistencePort;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.CategoriaEntity;
import com.bodega.api.infrastructure.adapters.out.persistence.mapper.CategoriaPersistenceMapper;
import com.bodega.api.infrastructure.adapters.out.persistence.repositories.CategoriaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component
public class CategoriaPersistenceAdapter implements CategoriaPersistencePort {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaPersistenceMapper mapper;

    // Inyección del repositorio
    public CategoriaPersistenceAdapter(CategoriaRepository categoriaRepository, CategoriaPersistenceMapper mapper) {
        this.categoriaRepository = categoriaRepository;
        this.mapper = mapper;
    }

    @Override
    public Categoria save(Categoria categoria) {
        CategoriaEntity entity = mapper.toEntity(categoria);
        CategoriaEntity savedEntity = categoriaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id)
                .map(entity -> mapper.toDomain(entity));
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll().stream()
                .map(entity -> mapper.toDomain(entity))
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }

}
