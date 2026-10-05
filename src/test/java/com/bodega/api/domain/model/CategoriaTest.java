package com.bodega.api.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CategoriaTest {

    @Test
    void deberiaLanzarExcepcionCuandoNombreVacio() {

        String nombreInvalido = ""; //Este es el arrange

        // Aca se juntan 2 el Act y el Assert
        //Guarda en exception lo que resulte al ejecutar la creacion de categoria con un nombre
        //invalido y se lance una illegalArgumentException
        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> Categoria.crear(nombreInvalido)
        );

        assertEquals("El nombre de la categoría es obligatorio", excepcion.getMessage());
    }

    @Test
    void deberiaCrearCategoriaCuandoNombreEsValido() {
        // Arrange
        String nombreValido = "Lacteos";

        // Act
        Categoria resultado = Categoria.crear(nombreValido);

        // Assert
        assertNotNull(resultado);
        assertEquals("Lacteos", resultado.getNombre());
    }
}