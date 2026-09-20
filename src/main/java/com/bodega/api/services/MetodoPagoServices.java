package com.bodega.api.services;

import com.bodega.api.dto.CategoriaDTO;
import com.bodega.api.dto.MetodoPagoDTO;

import com.bodega.api.entities.MetodoPagoEntity;
import com.bodega.api.mapper.MetodoPagoMapper;
import com.bodega.api.mapper.MetodoPagoMapperImpl;
import com.bodega.api.repositories.MetodoPagoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoServices {

    private final MetodoPagoRepository metodoPagoRepository;
    private final MetodoPagoMapper metodoPagoMapper;

    public MetodoPagoServices(MetodoPagoMapper metodoPagoMapper,MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
        this.metodoPagoMapper = metodoPagoMapper;

    }


    //Metodo para traer todos
    public List<MetodoPagoDTO> encontrarTodos() {
        return metodoPagoMapper.toDto(metodoPagoRepository.findAll());
    }


    //Metodo para traer p-or id
    public  MetodoPagoDTO encontrarId(Long id) {
        MetodoPagoEntity metodoPago = this.metodoPagoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Metodo de pago no encontrado"));
        return metodoPagoMapper.toDto(metodoPago);
    }

    //Metodo para agregar

    public MetodoPagoDTO crearPagoServicio(MetodoPagoDTO metodoPagoDTO) {
        MetodoPagoEntity metodo = metodoPagoMapper.toEntity(metodoPagoDTO);
        return metodoPagoMapper.toDto(metodoPagoRepository.save(metodo));
    }

    //Metodo para actualizar
    // Método para actualizar
    public MetodoPagoDTO actualizarMetodoPago(Long id, MetodoPagoDTO metodoPagoDTO) {
        MetodoPagoEntity metodoPagoExistente = this.metodoPagoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Método de pago no encontrado"));
        this.metodoPagoMapper.updateEntityFromDto(metodoPagoDTO, metodoPagoExistente);
        metodoPagoExistente.setId(id);
        MetodoPagoEntity metodoPagoGuardado = this.metodoPagoRepository.save(metodoPagoExistente);
        return this.metodoPagoMapper.toDto(metodoPagoGuardado);
    }


    //Metodo para eliminar
    public void eliminarMetodoPago(Long id) {
        Optional<MetodoPagoEntity> pagoEntity = metodoPagoRepository.findById(id);
        if (pagoEntity == null) {
            return;
        }
        if (Boolean.TRUE.equals(pagoEntity.get().getActivo())) {
            throw new RuntimeException("No se puede eliminar el metodo de pago porque esta activo");
        }
        MetodoPagoEntity c =  pagoEntity.get();
        metodoPagoRepository.delete(c);
    }

}
