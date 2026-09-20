package com.bodega.api.mapper;

import com.bodega.api.dto.MetodoPagoDTO;
import com.bodega.api.entities.MetodoPagoEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MetodoPagoMapper {
    MetodoPagoDTO toDto(MetodoPagoEntity entity);

    MetodoPagoEntity toEntity(MetodoPagoDTO dto);

    List<MetodoPagoDTO> toDto(List<MetodoPagoEntity> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(MetodoPagoDTO dto, @MappingTarget MetodoPagoEntity entity);
}
