package com.bodega.api.infrastructure.adapters.out.persistence;

import com.bodega.api.domain.model.MetodoPago;
import com.bodega.api.domain.ports.out.MetodoPagoPersistencePort;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.MetodoPagoEntity;
import com.bodega.api.infrastructure.adapters.out.persistence.mapper.MetodoPagoPersistenceMapper;
import com.bodega.api.infrastructure.adapters.out.persistence.repositories.MetodoPagoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor

public class MetodoPagoPersistenceAdapter implements MetodoPagoPersistencePort {

    private final MetodoPagoRepository metodoPagoRepository;
    private final MetodoPagoPersistenceMapper mapper;



    @Override
    public List<MetodoPago> findAll() {
        return metodoPagoRepository.findAll().stream()
                .map(entity -> mapper.toDomain(entity)).toList();
    }

    @Override
    public Optional<MetodoPago> findById(Long id) {
        return metodoPagoRepository.findById(id).map(entity -> mapper.toDomain(entity));
    }

    @Override
    public MetodoPago save(MetodoPago metodoPago) {
        MetodoPagoEntity entity = mapper.toEntity(metodoPago);
        MetodoPagoEntity savedEntity = metodoPagoRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        metodoPagoRepository.deleteById(id);
    }

}
