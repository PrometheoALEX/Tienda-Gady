package com.bodega.api.application.services;

import com.bodega.api.domain.exceptions.DeliveryTypeNotFoundException;
import com.bodega.api.domain.model.DeliveryType;
import com.bodega.api.domain.ports.in.DeliveryTypeServicePort;
import com.bodega.api.domain.ports.out.DeliveryTypePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DeliveryTypeServiceImpl implements DeliveryTypeServicePort {

    private final DeliveryTypePersistencePort persistencePort;

    @Override
    public List<DeliveryType> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public DeliveryType findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(() -> new DeliveryTypeNotFoundException("Delivery type not found with id: " + id));
    }

    @Override
    public DeliveryType save(DeliveryType deliveryType) {
        return persistencePort.save(deliveryType);
    }

    @Override
    public DeliveryType update(Long id, DeliveryType deliveryType) {
        this.findById(id);
        deliveryType.setId(id);
        return persistencePort.save(deliveryType);
    }

    @Override
    public void deleteById(Long id) {
        this.findById(id);
        persistencePort.deleteById(id);
    }
}