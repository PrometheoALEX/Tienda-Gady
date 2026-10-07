package com.bodega.api.domain.ports.out;

import com.bodega.api.domain.model.DeliveryType;
import java.util.List;
import java.util.Optional;

public interface DeliveryTypePersistencePort {
    List<DeliveryType> findAll();
    Optional<DeliveryType> findById(Long id);
    DeliveryType save(DeliveryType deliveryType);
    void deleteById(Long id);
}