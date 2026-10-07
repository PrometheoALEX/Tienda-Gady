package com.bodega.api.infrastructure.adapters.in.web.controllers;

import com.bodega.api.domain.model.Role;
import com.bodega.api.domain.ports.in.RoleServicePort;
import com.bodega.api.infrastructure.adapters.in.web.dto.RoleDTO;
import com.bodega.api.infrastructure.adapters.in.web.mapper.RoleMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleServicePort roleServicePort;
    private final RoleMapper roleMapper;

    @GetMapping
    public ResponseEntity<List<RoleDTO>> findAll() {
        List<Role> roles = roleServicePort.findAll();
        return ResponseEntity.ok(roleMapper.toDtoList(roles));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> findById(@PathVariable Long id) {
        Role role = roleServicePort.findById(id);
        return ResponseEntity.ok(roleMapper.toDto(role));
    }

    @PostMapping
    public ResponseEntity<RoleDTO> save(@Valid @RequestBody RoleDTO dto) {
        Role role = roleMapper.toDomain(dto);
        Role savedRole = roleServicePort.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(roleMapper.toDto(savedRole));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> update(
            @PathVariable Long id, @Valid @RequestBody RoleDTO dto) {
        Role role = roleMapper.toDomain(dto);
        Role updatedRole = roleServicePort.update(id, role);
        return ResponseEntity.ok(roleMapper.toDto(updatedRole));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        roleServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}