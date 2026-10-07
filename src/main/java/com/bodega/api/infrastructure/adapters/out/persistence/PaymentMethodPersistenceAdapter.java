package com.bodega.api.infrastructure.adapters.out.persistence;

import com.bodega.api.domain.model.PaymentMethod;
import com.bodega.api.domain.ports.out.PaymentMethodPersistencePort;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.PaymentMethodEntity;
import com.bodega.api.infrastructure.adapters.out.persistence.mapper.PaymentMethodPersistenceMapper;
import com.bodega.api.infrastructure.adapters.out.persistence.repositories.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PaymentMethodPersistenceAdapter implements PaymentMethodPersistencePort {

    private final PaymentMethodRepository paymentMethodRepository;
    private final PaymentMethodPersistenceMapper mapper;

    @Override
    public List<PaymentMethod> findAll() {
        return paymentMethodRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<PaymentMethod> findById(Long id) {
        return paymentMethodRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        PaymentMethodEntity entity = mapper.toEntity(paymentMethod);
        PaymentMethodEntity savedEntity = paymentMethodRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        paymentMethodRepository.deleteById(id);
    }
}