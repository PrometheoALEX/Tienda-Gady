package com.bodega.api.infrastructure.adapters.out.persistence;

import com.bodega.api.domain.model.TipoEntrega;
import com.bodega.api.domain.ports.out.TipoEntregaPersistencePort;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.TipoEntregaEntity;
import com.bodega.api.infrastructure.adapters.out.persistence.mapper.TipoEntregaPersistenceMapper;
import com.bodega.api.infrastructure.adapters.out.persistence.repositories.TipoEntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class TipoEntregaPersistenceAdapter implements TipoEntregaPersistencePort {

    private final TipoEntregaRepository tipoEntregaRepository;
    private final TipoEntregaPersistenceMapper mapper;

    @Override
    public List<TipoEntrega> findAll() {
        return tipoEntregaRepository.findAll().stream()
                .map(entity -> mapper.toDomain(entity))
                .toList();
    }

    @Override
    public Optional<TipoEntrega> findById(Long id) {
        return tipoEntregaRepository.findById(id)
                .map(entity -> mapper.toDomain(entity));
    }

    @Override
    public TipoEntrega save(TipoEntrega tipoEntrega) {
        TipoEntregaEntity entity = mapper.toEntity(tipoEntrega);
        TipoEntregaEntity savedEntity = tipoEntregaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        tipoEntregaRepository.deleteById(id);
    }
}