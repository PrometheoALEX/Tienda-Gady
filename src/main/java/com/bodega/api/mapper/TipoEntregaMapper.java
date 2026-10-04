package com.bodega.api.mapper;


import com.bodega.api.dto.TipoEntregaDTO;
import com.bodega.api.entities.TipoEntregaEntity;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoEntregaMapper {

    TipoEntregaDTO toDto(TipoEntregaEntity entity);

    TipoEntregaEntity toEntity(TipoEntregaDTO dto);

    List<TipoEntregaDTO> toDto(List<TipoEntregaEntity> entites) ;

    //NO SE COMO FUNCIONA PERO ACTUALIZA Y ES MAGIA
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(TipoEntregaDTO dto, @MappingTarget TipoEntregaEntity entity);




}
