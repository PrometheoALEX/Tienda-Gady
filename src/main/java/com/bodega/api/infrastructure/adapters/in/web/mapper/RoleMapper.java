package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.Role;
import com.bodega.api.infrastructure.adapters.in.web.dto.RoleDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO toDto(Role domain);

    Role toDomain(RoleDTO dto);

    List<RoleDTO> toDtoList(List<Role> domainList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(RoleDTO dto, @MappingTarget Role domain);
}