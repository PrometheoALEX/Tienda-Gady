package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.TipoEntrega;
import com.bodega.api.infrastructure.adapters.in.web.dto.TipoEntregaDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoEntregaMapper {
    TipoEntregaDTO toDto(TipoEntrega domain);

    TipoEntrega toDomain(TipoEntregaDTO dto);

    List<TipoEntregaDTO> toDtoList(List<TipoEntrega> domainList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(TipoEntregaDTO dto, @MappingTarget TipoEntrega domain);
}