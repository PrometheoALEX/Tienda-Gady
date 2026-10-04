package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.Categoria;
import com.bodega.api.infrastructure.adapters.in.web.dto.CategoriaDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaDTO toDto(Categoria domain);

    Categoria toDomain(CategoriaDTO dto); // O le renombras a toDomain si prefieres

    List<CategoriaDTO> toDtoList(List<Categoria> domainList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(CategoriaDTO dto, @MappingTarget Categoria domain);
}