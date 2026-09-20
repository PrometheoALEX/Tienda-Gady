package com.bodega.api.controllers;

import com.bodega.api.dto.TipoEntregaDTO;
import com.bodega.api.services.TipoEntregaServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrega")
public class TipoEntregaController {

    private final TipoEntregaServices tipoEntregaServices;

    public TipoEntregaController(TipoEntregaServices tipoEntregaServices) {
        this.tipoEntregaServices = tipoEntregaServices;
    }

    @GetMapping
    public List<TipoEntregaDTO> obtenerTodas() {
        return tipoEntregaServices.traerTodos();
    }

    @GetMapping("/{id}")
    public TipoEntregaDTO obtenerPorId(@PathVariable Long id) {
        return tipoEntregaServices.traerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoEntregaDTO guardar(@Valid @RequestBody TipoEntregaDTO tipoEntregaDTO) {
        return tipoEntregaServices.crear(tipoEntregaDTO);
    }

    @PutMapping("/{id}")
    public TipoEntregaDTO actualizar(@PathVariable Long id, @Valid @RequestBody TipoEntregaDTO tipoEntregaDTO) {
        return tipoEntregaServices.actualizar(id, tipoEntregaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        tipoEntregaServices.eliminar(id);
    }
}