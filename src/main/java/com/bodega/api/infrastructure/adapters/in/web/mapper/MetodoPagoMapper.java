package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.MetodoPago;
import com.bodega.api.infrastructure.adapters.in.web.dto.MetodoPagoDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MetodoPagoMapper {
    MetodoPagoDTO toDto(MetodoPago domain);

    MetodoPago toDomain(MetodoPagoDTO dto);

    List<MetodoPagoDTO> toDtoList(List<MetodoPago> domainList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(MetodoPagoDTO dto, @MappingTarget MetodoPago domain);
}