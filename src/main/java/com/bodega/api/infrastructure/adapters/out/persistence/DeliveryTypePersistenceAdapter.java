package com.bodega.api.infrastructure.adapters.out.persistence;

import com.bodega.api.domain.model.DeliveryType;
import com.bodega.api.domain.ports.out.DeliveryTypePersistencePort;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.DeliveryTypeEntity;
import com.bodega.api.infrastructure.adapters.out.persistence.mapper.DeliveryTypePersistenceMapper;
import com.bodega.api.infrastructure.adapters.out.persistence.repositories.DeliveryTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DeliveryTypePersistenceAdapter implements DeliveryTypePersistencePort {

    private final DeliveryTypeRepository deliveryTypeRepository;
    private final DeliveryTypePersistenceMapper mapper;

    @Override
    public List<DeliveryType> findAll() {
        return deliveryTypeRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<DeliveryType> findById(Long id) {
        return deliveryTypeRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public DeliveryType save(DeliveryType deliveryType) {
        DeliveryTypeEntity entity = mapper.toEntity(deliveryType);
        DeliveryTypeEntity savedEntity = deliveryTypeRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        deliveryTypeRepository.deleteById(id);
    }
}