package com.bodega.api.application.services;

import com.bodega.api.domain.model.Categoria;
// IMPORTANTE: Verifica que esta ruta coincida con la ubicación real de tu puerto en el proyecto
import com.bodega.api.domain.ports.out.CategoriaPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) //Es el puente entre Junit5 Y Mockito
class CategoriaServiceImplTest {

    @Mock //o un objeto falso
    private CategoriaPersistencePort categoriaPersistencePortFalso;

    @InjectMocks //crea una instancia para ensamblar el servicio de aplicacion conectandole el puerto falso
    private CategoriaServiceImpl categoriaService;

    @Test
    void guardarCategoria_DeberiaRetornarCategoriaGuardada() {

        Categoria categoriaNueva = new Categoria();
        categoriaNueva.setNombre("Lácteos");


        Categoria categoriaGuardada = new Categoria();
        categoriaGuardada.setId(1L); //Lleno su propia id  simunlando que el motor de BD ya genero su clave primaria
        categoriaGuardada.setNombre("Lácteos");

        //Cuando ocurra el guardado de  categoria
        when(categoriaPersistencePortFalso.save(any(Categoria.class))).thenReturn(categoriaGuardada);

        // 2 ACT
        Categoria resultado = categoriaService.save(categoriaNueva);

        // 3 ASSERT
        assertNotNull(resultado, "El resultado no debería ser nulo");
        assertNotNull(resultado.getId(), "La categoría guardada debería tener un ID asignado");
        assertEquals("Lácteos", resultado.getNombre(), "El nombre de la categoría debe coincidir");

        verify(categoriaPersistencePortFalso, times(1)).save(any(Categoria.class));
    }
}