package com.bodega.api.controllers;

import com.bodega.api.dto.RolDTO;
import com.bodega.api.entities.RolEntity;
import com.bodega.api.mapper.RolMapper;
import com.bodega.api.repositories.RolRepository;
import com.bodega.api.services.RollServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
@RequiredArgsConstructor
public class RolController {

    private final RollServices rollServices;

    @GetMapping
    public List<RolDTO> obtenerTodos() {

        return rollServices.encontrarTodos();
    }

    @GetMapping("/{id}")
    public RolDTO encontrarId(@PathVariable Long id) {
        return rollServices.encontrarId(id);
    }

    @PostMapping
    public RolDTO guardar(@Valid @RequestBody RolDTO rolDTO) {
        return rollServices.crearPagoServicio(rolDTO);
    }

    @PutMapping("/{id}")
    public RolDTO actualizar(@PathVariable Long id, @Valid @RequestBody RolDTO rolDTO) {
        return rollServices.actualizarRol(id, rolDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        rollServices.eliminarMetodoPago(id);
    }

}
