package com.bodega.api.controllers;

import com.bodega.api.dto.CategoriaDTO;
import com.bodega.api.entities.CategoriaEntity;
import com.bodega.api.mapper.CategoriaMapper;
import com.bodega.api.repositories.CategoriaRepository;
import com.bodega.api.services.CategoriaServices;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor


public class CategoriaController {

    private final CategoriaServices categoriaServices;
 ;


    @GetMapping
    public List<CategoriaDTO> obtenerTodas() {
        return categoriaServices.encontrarTodos();
    }

    @GetMapping("/{id}")
    public CategoriaDTO obtenerPorId(@PathVariable Long id) {
        CategoriaDTO categoriaDTO = categoriaServices.encontrarId(id);
        return  categoriaDTO;
    }


    @PostMapping
    public CategoriaDTO guardar(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        return categoriaServices.crearCategoria(categoriaDTO);
    }

    @PutMapping("/{id}")
    public CategoriaDTO actualizar(@PathVariable Long id, @Valid @RequestBody CategoriaDTO categoriaDTO) {
        // El controlador solo delega la responsabilidad al servicio
        return categoriaServices.actualizarCategoria(id, categoriaDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        categoriaServices.eliminarCategoria(id);
    }
}