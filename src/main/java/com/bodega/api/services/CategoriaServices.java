package com.bodega.api.services;


import com.bodega.api.dto.CategoriaDTO;
import com.bodega.api.entities.CategoriaEntity;
import com.bodega.api.errors.CategoriaDeletionNotAllowedException;
import com.bodega.api.errors.CategoriaNotFoundException;
import com.bodega.api.mapper.CategoriaMapper;
import com.bodega.api.repositories.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServices {

    //Mapstrup y repositorio se agregan en el servicio
    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;


    public CategoriaServices (
            CategoriaMapper categoriaMapper ,
            CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    //Logica de encontrar a todos
    public List<CategoriaDTO> encontrarTodos() {
        List<CategoriaEntity> lista = categoriaRepository.findAll();
        return categoriaMapper.toDto(lista);
    }


    //Logica encontrar por i-d
    public CategoriaDTO encontrarId(Long id) {
        CategoriaEntity categoria = this.categoriaRepository.findById(id)
            .orElseThrow(() -> new CategoriaNotFoundException("Categoría no encontrada con el ID: "+ id));
        return categoriaMapper.toDto(categoria);
    }


    //Crear una nueva entidad
    public CategoriaDTO crearCategoria(CategoriaDTO categoriaDto) {
        CategoriaEntity categoria = this.categoriaMapper.toEntity(categoriaDto);
        return this.categoriaMapper.toDto(categoriaRepository.save(categoria));
    }

    // Actualizar la categoría
    public CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        CategoriaEntity categoriaExistente = this.categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFoundException( "Categoría no encontrada con el ID: "+ id));

        this.categoriaMapper.updateEntityFromDto(categoriaDTO, categoriaExistente);
        categoriaExistente.setId(id);
        CategoriaEntity categoriaGuardada = this.categoriaRepository.save(categoriaExistente);

        return this.categoriaMapper.toDto(categoriaGuardada);
    }


    //Elimina la categoria
    public void eliminarCategoria(Long id) {
        CategoriaEntity categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaDeletionNotAllowedException("Categoría no encontrada con el ID: "+ id));
        if (categoria == null) {
            return;
        }
        if (Boolean.TRUE.equals(categoria.getActivo())) {
            throw new RuntimeException("No se puede eliminar la categoría porque está activa.");
        }
        CategoriaEntity c = categoria;
        categoriaRepository.delete(categoria);
    }





}
