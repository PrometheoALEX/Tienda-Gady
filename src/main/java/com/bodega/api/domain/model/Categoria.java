package com.bodega.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Categoria {

    private Long id;
    private String nombre;
    private Boolean activo;

    // Constructor útil para cuando creas una categoría nueva (antes de persistir)
    public Categoria(String nombre, Boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }
}