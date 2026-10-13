package com.bodega.api.application.services;

import com.bodega.api.domain.exceptions.CategoryDeletionNotAllowedException;
import com.bodega.api.domain.exceptions.CategoryNotFoundException;
import com.bodega.api.domain.model.Category;
import com.bodega.api.domain.ports.out.CategoryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @Mock
    private CategoryPersistencePort persistencePort;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
        category.setId(1L);
        category.setName("Beverages");
        category.setActive(true);
    }

    @Test
    void findAll_ShouldReturnCategoryList() {
        //Cuando el mok busque algo retorna category quien tendra los datos del before
        when(persistencePort.findAll()).thenReturn(List.of(category));
        //La lista resultado aplicara al mock falso tratando encontrar todo
        List<Category> result = categoryService.findAll();

        // debe dar verde si el servicio esta bien
        assertNotNull(result);
        //debe dar en verde si la lista tiene un objeto
        assertEquals(1, result.size());
        //Verifica si solo llamaste una sola ves al persistencePort
        verify(persistencePort, times(1)).findAll();
    }

    @Test
    void findById_WhenExists_ShouldReturnCategory() {
        //cuando el mok llama por id a 1 devuelve categoria
        when(persistencePort.findById(1L)).thenReturn(Optional.of(category));
        // aplica el servicio intentando de encontrar el objeto del id 1
        Category result = categoryService.findById(1L);
        //Verfica el valor si es null pero y no debe ser para dar ver, es correcto
        assertNotNull(result);
        //compara valores es verde
        assertEquals("Beverages", result.getName());
    }

    @Test
    void findById_WhenNotExists_ShouldThrowCategoryNotFoundException() {
        when(persistencePort.findById(1L)).thenReturn(Optional.empty());

        assertThrows(CategoryNotFoundException.class, () -> categoryService.findById(1L));
    }

    @Test
    void save_ShouldReturnSavedCategory() {
        when(persistencePort.save(any(Category.class))).thenReturn(category);

        Category result = categoryService.save(category);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void deleteById_WhenActive_ShouldThrowCategoryDeletionNotAllowedException() {
        //Si buscas el id 1 debe devolver la categoria
        when(persistencePort.findById(1L)).thenReturn(Optional.of(category));
        //
        assertThrows(CategoryDeletionNotAllowedException.class, () -> categoryService.deleteById(1L));
        verify(persistencePort, never()).deleteById(1L);
    }

    @Test
    void deleteById_WhenInactive_ShouldDeleteCategory() {
        category.setActive(false);
        when(persistencePort.findById(1L)).thenReturn(Optional.of(category));

        categoryService.deleteById(1L);

        verify(persistencePort, times(1)).deleteById(1L);
    }
}