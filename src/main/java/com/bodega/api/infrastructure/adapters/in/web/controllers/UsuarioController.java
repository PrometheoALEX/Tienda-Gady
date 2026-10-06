package com.bodega.api.infrastructure.adapters.in.web.controllers;

import com.bodega.api.domain.model.Usuario;
import com.bodega.api.domain.ports.in.UsuarioServicePort;
import com.bodega.api.infrastructure.adapters.in.web.dto.UsuarioDTO;
import com.bodega.api.infrastructure.adapters.in.web.mapper.UsuarioMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServicePort usuarioServicePort;
    private final UsuarioMapper usuarioMapper;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> obtenerTodos() {
        List<Usuario> usuarios = usuarioServicePort.findAll();
        return ResponseEntity.ok(usuarioMapper.toDtoList(usuarios));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerPorId(@PathVariable Long id) {
        Usuario usuario = usuarioServicePort.findById(id);
        return ResponseEntity.ok(usuarioMapper.toDto(usuario));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> guardar(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toDomain(usuarioDTO);
        Usuario guardado = usuarioServicePort.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioMapper.toDto(guardado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizar(
            @PathVariable Long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toDomain(usuarioDTO);
        Usuario actualizado = usuarioServicePort.update(id, usuario);
        return ResponseEntity.ok(usuarioMapper.toDto(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}