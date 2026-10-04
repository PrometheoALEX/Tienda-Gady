package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.Rol;
import com.bodega.api.infrastructure.adapters.in.web.dto.RolDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolMapper {
    RolDTO toDto(Rol domain);

    Rol toDomain(RolDTO dto);

    List<RolDTO> toDtoList(List<Rol> domainList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(RolDTO dto, @MappingTarget Rol domain);
}