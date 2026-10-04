package com.bodega.api.infrastructure.adapters.in.web.controllers;

import com.bodega.api.domain.model.Rol;
import com.bodega.api.domain.ports.in.RolServicePort;
import com.bodega.api.infrastructure.adapters.in.web.dto.RolDTO;
import com.bodega.api.infrastructure.adapters.in.web.mapper.RolMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
@RequiredArgsConstructor
public class RolController {

    private final RolServicePort rolServicePort;
    private final RolMapper rolMapper;

    @GetMapping
    public ResponseEntity<List<RolDTO>> obtenerTodos() {
        List<Rol> roles = rolServicePort.findAll();
        return ResponseEntity.ok(rolMapper.toDtoList(roles));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> obtenerPorId(@PathVariable Long id) {
        Rol rol = rolServicePort.findById(id);
        return ResponseEntity.ok(rolMapper.toDto(rol));
    }

    @PostMapping
    public ResponseEntity<RolDTO> guardar(@Valid @RequestBody RolDTO rolDTO) {
        Rol rol = rolMapper.toDomain(rolDTO);
        Rol guardado = rolServicePort.save(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(rolMapper.toDto(guardado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> actualizar(
            @PathVariable Long id, @Valid @RequestBody RolDTO rolDTO) {
        Rol rol = rolMapper.toDomain(rolDTO);
        Rol actualizado = rolServicePort.update(id, rol);
        return ResponseEntity.ok(rolMapper.toDto(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        rolServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}