package com.bodega.api.infrastructure.adapters.in.web.controllers;

import com.bodega.api.domain.model.PaymentMethod;
import com.bodega.api.domain.ports.in.PaymentMethodServicePort;
import com.bodega.api.infrastructure.adapters.in.web.dto.PaymentMethodDTO;
import com.bodega.api.infrastructure.adapters.in.web.mapper.PaymentMethodMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment-methods")
@RequiredArgsConstructor
public class PaymentMethodController {

    private final PaymentMethodServicePort paymentMethodServicePort;
    private final PaymentMethodMapper paymentMethodMapper;

    @GetMapping
    public ResponseEntity<List<PaymentMethodDTO>> findAll() {
        List<PaymentMethod> paymentMethods = paymentMethodServicePort.findAll();
        return ResponseEntity.ok(paymentMethodMapper.toDtoList(paymentMethods));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethodDTO> findById(@PathVariable Long id) {
        PaymentMethod paymentMethod = paymentMethodServicePort.findById(id);
        return ResponseEntity.ok(paymentMethodMapper.toDto(paymentMethod));
    }

    @PostMapping
    public ResponseEntity<PaymentMethodDTO> save(@Valid @RequestBody PaymentMethodDTO dto) {
        PaymentMethod paymentMethod = paymentMethodMapper.toDomain(dto);
        PaymentMethod savedPaymentMethod = paymentMethodServicePort.save(paymentMethod);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentMethodMapper.toDto(savedPaymentMethod));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentMethodDTO> update(@PathVariable Long id, @Valid @RequestBody PaymentMethodDTO dto) {
        PaymentMethod paymentMethod = paymentMethodMapper.toDomain(dto);
        PaymentMethod updatedPaymentMethod = paymentMethodServicePort.update(id, paymentMethod);
        return ResponseEntity.ok(paymentMethodMapper.toDto(updatedPaymentMethod));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        paymentMethodServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}