package com.bodega.api.services;

import com.bodega.api.dto.MetodoPagoDTO;
import com.bodega.api.entities.MetodoPagoEntity;
import com.bodega.api.errors.MetodoPagoDeletionNotAllowedException;
import com.bodega.api.errors.MetodoPagoNotFoundException;
import com.bodega.api.mapper.MetodoPagoMapper;
import com.bodega.api.repositories.MetodoPagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodoPagoServices {

    private final MetodoPagoRepository metodoPagoRepository;
    private final MetodoPagoMapper metodoPagoMapper;

    public MetodoPagoServices(MetodoPagoMapper metodoPagoMapper, MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
        this.metodoPagoMapper = metodoPagoMapper;
    }

    public List<MetodoPagoDTO> encontrarTodos() {
        return metodoPagoMapper.toDto(metodoPagoRepository.findAll());
    }

    public MetodoPagoDTO encontrarId(Long id) {
        MetodoPagoEntity metodoPago = this.metodoPagoRepository.findById(id)
                .orElseThrow(() -> new MetodoPagoNotFoundException("Método de pago no encontrado con el ID: " + id));
        return metodoPagoMapper.toDto(metodoPago);
    }

    public MetodoPagoDTO crearPagoServicio(MetodoPagoDTO metodoPagoDTO) {
        MetodoPagoEntity metodo = metodoPagoMapper.toEntity(metodoPagoDTO);
        return metodoPagoMapper.toDto(metodoPagoRepository.save(metodo));
    }

    public MetodoPagoDTO actualizarMetodoPago(Long id, MetodoPagoDTO metodoPagoDTO) {
        MetodoPagoEntity metodoPagoExistente = this.metodoPagoRepository.findById(id)
                .orElseThrow(() -> new MetodoPagoNotFoundException("Método de pago no encontrado con el ID: " + id));
        this.metodoPagoMapper.updateEntityFromDto(metodoPagoDTO, metodoPagoExistente);
        metodoPagoExistente.setId(id);
        MetodoPagoEntity metodoPagoGuardado = this.metodoPagoRepository.save(metodoPagoExistente);
        return this.metodoPagoMapper.toDto(metodoPagoGuardado);
    }

    public void eliminarMetodoPago(Long id) {
        MetodoPagoEntity pagoEntity = metodoPagoRepository.findById(id)
                .orElseThrow(() -> new MetodoPagoNotFoundException("Método de pago no encontrado con el ID: " + id));

        if (Boolean.TRUE.equals(pagoEntity.getActivo())) {
            throw new MetodoPagoDeletionNotAllowedException("No se puede eliminar el método de pago porque está activo");
        }

        metodoPagoRepository.delete(pagoEntity);
    }
}