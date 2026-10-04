package com.bodega.api.services;

import com.bodega.api.dto.MetodoPagoDTO;
import com.bodega.api.dto.RolDTO;
import com.bodega.api.entities.MetodoPagoEntity;
import com.bodega.api.entities.RolEntity;
import com.bodega.api.mapper.RolMapper;
import com.bodega.api.repositories.RolRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RollServices {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    public RollServices(RolRepository rolRepository, RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }

    public List<RolDTO> encontrarTodos() {
        return rolMapper.toDto(rolRepository.findAll());
    }

    //Metodo para traer p-or id
    public  RolDTO encontrarId(Long id) {
        Optional<RolEntity> metodoPago = this.rolRepository.findById(id);
        if(metodoPago.isPresent()) {
            return rolMapper.toDto(metodoPago.get());
        }
        return null;
    }


    //Metodo para agregar
    public RolDTO crearPagoServicio(RolDTO rolDTO) {
        RolEntity rol = rolMapper.toEntity(rolDTO);
        return rolMapper.toDto(rolRepository.save(rol));
    }


    public RolDTO actualizarRol(Long id, RolDTO rolDTO) {
        RolEntity rolExistente = this.rolRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol no encontrado"));

        this.rolMapper.updateEntityFromDto(rolDTO, rolExistente);

        rolExistente.setId(id);
        RolEntity rolGuardado = this.rolRepository.save(rolExistente);

        return this.rolMapper.toDto(rolGuardado);
    }


    //Metodo para eliminar
    public void eliminarMetodoPago(Long id) {
        Optional<RolEntity> rolEntity = rolRepository.findById(id);
        if (rolEntity == null) {
            return;
        }
        if (Boolean.TRUE.equals(rolEntity.get().getActivo())) {
            throw new RuntimeException("No se puede eliminar el rol porque esta activo");
        }
        RolEntity r =  rolEntity.get();
        rolRepository.delete(r);
    }

}
