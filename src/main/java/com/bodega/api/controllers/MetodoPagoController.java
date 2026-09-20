package com.bodega.api.controllers;

import com.bodega.api.dto.MetodoPagoDTO;
import com.bodega.api.entities.MetodoPagoEntity;
import com.bodega.api.mapper.MetodoPagoMapper;
import com.bodega.api.repositories.MetodoPagoRepository;
import com.bodega.api.services.MetodoPagoServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/metodoPago")
@RequiredArgsConstructor
public class MetodoPagoController {

    private final MetodoPagoServices metodoPagoServices;



    @GetMapping
    public List<MetodoPagoDTO> obtenerTodos() {
        return metodoPagoServices.encontrarTodos();
    }

    @GetMapping("/{id}")
    public MetodoPagoDTO obtenerPorId(@PathVariable Long id){
        return metodoPagoServices.encontrarId(id);
    }


    @PostMapping
    public MetodoPagoDTO guardar(@Valid @RequestBody MetodoPagoDTO metodoPagoDTO) {
        return metodoPagoServices.crearPagoServicio(metodoPagoDTO);
    }


    @PutMapping("/{id}")
    public MetodoPagoDTO actualizar(@PathVariable Long id, @Valid @RequestBody MetodoPagoDTO metodoPagoDTO) {
        return metodoPagoServices.actualizarMetodoPago(id, metodoPagoDTO);
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        metodoPagoServices.eliminarMetodoPago(id);
    }
}
