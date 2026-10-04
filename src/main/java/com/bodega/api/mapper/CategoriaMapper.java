package com.bodega.api.mapper;

import com.bodega.api.dto.CategoriaDTO;
import com.bodega.api.entities.CategoriaEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaDTO toDto(CategoriaEntity entity);

    CategoriaEntity toEntity(CategoriaDTO dto);

    List<CategoriaDTO> toDto(List<CategoriaEntity> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(CategoriaDTO dto, @MappingTarget CategoriaEntity entity);
}
