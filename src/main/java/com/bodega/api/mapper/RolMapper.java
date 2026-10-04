package com.bodega.api.mapper;

import com.bodega.api.dto.RolDTO;
import com.bodega.api.entities.RolEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolMapper {
    RolDTO toDto(RolEntity entity);

    RolEntity toEntity(RolDTO dto);

    List<RolDTO> toDto(List<RolEntity> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(RolDTO dto, @MappingTarget RolEntity entity);
}
