package com.bodega.api.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void deberiaLanzarExcepcionCuandoNombresSonVacios() {
        Rol rol = new Rol(1L, "CLIENTE", true);
        String dniValido = "71234567";
        String nombresInvalidos = "";

        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> Usuario.crear(rol, nombresInvalidos, "Gómez", dniValido, "maria@gmail.com", "pass123")
        );

        assertEquals("Los nombres son obligatorios", excepcion.getMessage());
    }
    @Test
    void deberiaLanzarExcepcionCuandoDniEsCorto() {
        Rol rol = new Rol(1L, "CLIENTE", true);
        String dniInvalido = "12345";

        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> Usuario.crear(rol, "María", "Gómez", dniInvalido, "maria@gmail.com", "pass123")
        );

        assertEquals("El DNI es obligatorio y debe tener exactamente 8 caracteres", excepcion.getMessage());
    }

    @Test
    void deberiaLanzarExcepcionCuandoDniEsNuloOVacio() {
        Rol rol = new Rol(1L, "CLIENTE", true);
        String dniInvalido = "";

        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> Usuario.crear(rol, "María", "Gómez", dniInvalido, "maria@gmail.com", "pass123")
        );

        assertEquals("El DNI es obligatorio y debe tener exactamente 8 caracteres", excepcion.getMessage());
    }

}