package com.bodega.api.infrastructure.adapters.in.web.controllers;

import com.bodega.api.domain.model.DeliveryType;
import com.bodega.api.domain.ports.in.DeliveryTypeServicePort;
import com.bodega.api.infrastructure.adapters.in.web.dto.DeliveryTypeDTO;
import com.bodega.api.infrastructure.adapters.in.web.mapper.DeliveryTypeMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/delivery-types")
@RequiredArgsConstructor
public class DeliveryTypeController {

    private final DeliveryTypeServicePort deliveryTypeServicePort;
    private final DeliveryTypeMapper deliveryTypeMapper;

    @GetMapping
    public ResponseEntity<List<DeliveryTypeDTO>> findAll() {
        List<DeliveryType> deliveryTypes = deliveryTypeServicePort.findAll();
        return ResponseEntity.ok(deliveryTypeMapper.toDtoList(deliveryTypes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryTypeDTO> findById(@PathVariable Long id) {
        DeliveryType deliveryType = deliveryTypeServicePort.findById(id);
        return ResponseEntity.ok(deliveryTypeMapper.toDto(deliveryType));
    }

    @PostMapping
    public ResponseEntity<DeliveryTypeDTO> save(@Valid @RequestBody DeliveryTypeDTO dto) {
        DeliveryType deliveryType = deliveryTypeMapper.toDomain(dto);
        DeliveryType savedDeliveryType = deliveryTypeServicePort.save(deliveryType);
        return ResponseEntity.status(HttpStatus.CREATED).body(deliveryTypeMapper.toDto(savedDeliveryType));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryTypeDTO> update(
            @PathVariable Long id, @Valid @RequestBody DeliveryTypeDTO dto) {
        DeliveryType deliveryType = deliveryTypeMapper.toDomain(dto);
        DeliveryType updatedDeliveryType = deliveryTypeServicePort.update(id, deliveryType);
        return ResponseEntity.ok(deliveryTypeMapper.toDto(updatedDeliveryType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        deliveryTypeServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}