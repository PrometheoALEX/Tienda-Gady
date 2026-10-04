package com.bodega.api.infrastructure.adapters.in.web.controllers;

import com.bodega.api.domain.model.TipoEntrega;
import com.bodega.api.domain.ports.in.TipoEntregaServicePort;
import com.bodega.api.infrastructure.adapters.in.web.dto.TipoEntregaDTO;
import com.bodega.api.infrastructure.adapters.in.web.mapper.TipoEntregaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipoEntrega")
@RequiredArgsConstructor
public class TipoEntregaController {

    private final TipoEntregaServicePort tipoEntregaServicePort;
    private final TipoEntregaMapper tipoEntregaMapper;

    @GetMapping
    public ResponseEntity<List<TipoEntregaDTO>> obtenerTodos() {
        List<TipoEntrega> tiposEntrega = tipoEntregaServicePort.findAll();
        return ResponseEntity.ok(tipoEntregaMapper.toDtoList(tiposEntrega));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoEntregaDTO> obtenerPorId(@PathVariable Long id) {
        TipoEntrega tipoEntrega = tipoEntregaServicePort.findById(id);
        return ResponseEntity.ok(tipoEntregaMapper.toDto(tipoEntrega));
    }

    @PostMapping
    public ResponseEntity<TipoEntregaDTO> guardar(@Valid @RequestBody TipoEntregaDTO tipoEntregaDTO) {
        TipoEntrega tipoEntrega = tipoEntregaMapper.toDomain(tipoEntregaDTO);
        TipoEntrega guardado = tipoEntregaServicePort.save(tipoEntrega);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoEntregaMapper.toDto(guardado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoEntregaDTO> actualizar(
            @PathVariable Long id, @Valid @RequestBody TipoEntregaDTO tipoEntregaDTO) {
        TipoEntrega tipoEntrega = tipoEntregaMapper.toDomain(tipoEntregaDTO);
        TipoEntrega actualizado = tipoEntregaServicePort.update(id, tipoEntrega);
        return ResponseEntity.ok(tipoEntregaMapper.toDto(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tipoEntregaServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}