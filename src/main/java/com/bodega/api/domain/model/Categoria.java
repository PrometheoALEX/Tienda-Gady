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
    //Esto crea categorias al usarse pero tiene evualuadores de seguridad // REGLA DE DOMINIO
    public static Categoria crear(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la categoría es obligatorio");
        }

        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);
        return categoria;
    }
}