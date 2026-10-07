package com.bodega.api.domain.ports.out;

import com.bodega.api.domain.model.PaymentMethod;
import java.util.List;
import java.util.Optional;

public interface PaymentMethodPersistencePort {
    List<PaymentMethod> findAll();
    Optional<PaymentMethod> findById(Long id);
    PaymentMethod save(PaymentMethod paymentMethod);
    void deleteById(Long id);
}