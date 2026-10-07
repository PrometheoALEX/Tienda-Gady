package com.bodega.api.application.services;

import com.bodega.api.domain.exceptions.PaymentMethodDeletionNotAllowedException;
import com.bodega.api.domain.exceptions.PaymentMethodNotFoundException;
import com.bodega.api.domain.model.PaymentMethod;
import com.bodega.api.domain.ports.in.PaymentMethodServicePort;
import com.bodega.api.domain.ports.out.PaymentMethodPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaymentMethodServiceImpl implements PaymentMethodServicePort {

    private final PaymentMethodPersistencePort persistencePort;

    @Override
    public List<PaymentMethod> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public PaymentMethod findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(() -> new PaymentMethodNotFoundException("Payment method not found with id: " + id));
    }

    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        return persistencePort.save(paymentMethod);
    }

    @Override
    public PaymentMethod update(Long id, PaymentMethod paymentMethod) {
        this.findById(id);
        paymentMethod.setId(id);
        return persistencePort.save(paymentMethod);
    }

    @Override
    public void deleteById(Long id) {
        PaymentMethod paymentMethod = this.findById(id);

        if (Boolean.TRUE.equals(paymentMethod.getActive())) {
            throw new PaymentMethodDeletionNotAllowedException("Cannot delete payment method because it is active");
        }

        persistencePort.deleteById(id);
    }
}