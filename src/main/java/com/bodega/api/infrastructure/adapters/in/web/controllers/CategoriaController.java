package com.bodega.api.infrastructure.adapters.in.web.controllers;

import com.bodega.api.domain.model.Categoria;
import com.bodega.api.domain.ports.in.CategoriaServicePort;
import com.bodega.api.infrastructure.adapters.in.web.dto.CategoriaDTO;
import com.bodega.api.infrastructure.adapters.in.web.mapper.CategoriaMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    private final CategoriaServicePort categoriaServicePort;
    private final CategoriaMapper categoriaMapper;

    public CategoriaController(CategoriaServicePort categoriaServicePort, CategoriaMapper categoriaMapper) {
        this.categoriaServicePort = categoriaServicePort;
        this.categoriaMapper = categoriaMapper;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> obtenerTodas() {
        List<Categoria> categorias = categoriaServicePort.findAll();
        return ResponseEntity.ok(categoriaMapper.toDtoList(categorias));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> obtenerPorId(@PathVariable Long id) {
        Categoria categoria = categoriaServicePort.findById(id);
        return ResponseEntity.ok(categoriaMapper.toDto(categoria));
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> guardar(@RequestBody CategoriaDTO dto) {
        Categoria categoriaDominio = categoriaMapper.toDomain(dto); // Usa toEntity como en tu mapper
        Categoria guardada = categoriaServicePort.save(categoriaDominio);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaMapper.toDto(guardada));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Long id, @RequestBody CategoriaDTO dto) {
        Categoria categoriaDominio = categoriaMapper.toDomain(dto);
        Categoria actualizada = categoriaServicePort.update(id, categoriaDominio);
        return ResponseEntity.ok(categoriaMapper.toDto(actualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        categoriaServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}