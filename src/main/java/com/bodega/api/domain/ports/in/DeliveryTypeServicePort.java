package com.bodega.api.domain.ports.in;

import com.bodega.api.domain.model.DeliveryType;
import java.util.List;

public interface DeliveryTypeServicePort {
    List<DeliveryType> findAll();
    DeliveryType findById(Long id);
    DeliveryType save(DeliveryType deliveryType);
    DeliveryType update(Long id, DeliveryType deliveryType);
    void deleteById(Long id);
}