package com.bodega.api.domain.ports.in;

import com.bodega.api.domain.model.PaymentMethod;
import java.util.List;

public interface PaymentMethodServicePort {
    List<PaymentMethod> findAll();
    PaymentMethod findById(Long id);
    PaymentMethod save(PaymentMethod paymentMethod);
    PaymentMethod update(Long id, PaymentMethod paymentMethod);
    void deleteById(Long id);
}