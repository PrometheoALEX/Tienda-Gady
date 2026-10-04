package com.bodega.api.infrastructure.adapters.in.web.controllers;

import com.bodega.api.domain.model.MetodoPago;
import com.bodega.api.domain.ports.in.MetodoPagoServicePort;
import com.bodega.api.infrastructure.adapters.in.web.dto.MetodoPagoDTO;
import com.bodega.api.infrastructure.adapters.in.web.mapper.MetodoPagoMapper;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/metodoPago")
@RequiredArgsConstructor

public class MetodoPagoController {

    private final MetodoPagoServicePort metodoPagoServicePort;
    private final MetodoPagoMapper metodoPagoMapper;

    @GetMapping
    public ResponseEntity<List<MetodoPagoDTO>> obtenerTodos() {
        List<MetodoPago> metodopago = metodoPagoServicePort.findAll();
        return ResponseEntity.ok(metodoPagoMapper.toDtoList(metodopago));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPagoDTO> obtenerPorId(@PathVariable Long id){
        MetodoPago metodoPago = metodoPagoServicePort.findById(id);
        return ResponseEntity.ok(metodoPagoMapper.toDto(metodoPago));
    }


    @PostMapping
    public ResponseEntity<MetodoPagoDTO> guardar(
            @Valid @RequestBody MetodoPagoDTO metodoPagoDTO) {
        MetodoPago metodoPago = metodoPagoMapper.toDomain(metodoPagoDTO);
        MetodoPago guardado = metodoPagoServicePort.save(metodoPago);

        return ResponseEntity.status(HttpStatus.CREATED).body(metodoPagoMapper.toDto(guardado));
    }


    @PutMapping("/{id}")
    public ResponseEntity<MetodoPagoDTO> actualizar(
            @PathVariable Long id, @Valid @RequestBody MetodoPagoDTO metodoPagoDTO) {
        MetodoPago metodoPago = metodoPagoMapper.toDomain(metodoPagoDTO);
        MetodoPago actualizada = metodoPagoServicePort.update(id , metodoPago);
        return ResponseEntity.ok(metodoPagoMapper.toDto(actualizada));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        metodoPagoServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
