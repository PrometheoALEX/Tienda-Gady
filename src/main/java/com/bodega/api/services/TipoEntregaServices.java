package com.bodega.api.services;

import com.bodega.api.dto.TipoEntregaDTO;
import com.bodega.api.entities.TipoEntregaEntity;
import com.bodega.api.mapper.RolMapper;
import com.bodega.api.mapper.TipoEntregaMapper;
import com.bodega.api.repositories.RolRepository;
import com.bodega.api.repositories.TipoEntregaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TipoEntregaServices {

    private final TipoEntregaRepository tipoEntregaRepository;
    private final TipoEntregaMapper tipoEntregaMapper;

    public TipoEntregaServices(
            TipoEntregaRepository tipoEntregaRepository,
            TipoEntregaMapper tipoEntregaMapper) {

        this.tipoEntregaRepository = tipoEntregaRepository;
        this.tipoEntregaMapper = tipoEntregaMapper;
    }

    //Metodo traer todos
    public List<TipoEntregaDTO> traerTodos() {
        List<TipoEntregaEntity> entregas = tipoEntregaRepository.findAll();
        return tipoEntregaMapper.toDto(entregas);
    }

    //Metodo traer por id
    public TipoEntregaDTO traerPorId(Long id) {
        TipoEntregaEntity entrega = tipoEntregaRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No encontrado"));
        return tipoEntregaMapper.toDto(entrega);
    }

    //Metodo crear nuevos

    public TipoEntregaDTO crear(TipoEntregaDTO tipoEntregaDTO) {
        tipoEntregaRepository.save(tipoEntregaMapper.toEntity(tipoEntregaDTO));
        return tipoEntregaDTO;
    }

    //Metodo actualizar
    public TipoEntregaDTO actualizar(Long id, TipoEntregaDTO tipoEntregaDTO) {
        TipoEntregaEntity entregaExistente = this.tipoEntregaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de entrega no encontrado"));

        this.tipoEntregaMapper.updateEntityFromDto(tipoEntregaDTO, entregaExistente);

        entregaExistente.setId(id);
        TipoEntregaEntity entregaGuardada = this.tipoEntregaRepository.save(entregaExistente);

        return this.tipoEntregaMapper.toDto(entregaGuardada);
    }

    //Metodo Eliminar

    public TipoEntregaDTO eliminar(Long id) {
        TipoEntregaEntity entrega = tipoEntregaRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No encontrado"));
        tipoEntregaRepository.delete(entrega);
        return tipoEntregaMapper.toDto(entrega);
    }
}
