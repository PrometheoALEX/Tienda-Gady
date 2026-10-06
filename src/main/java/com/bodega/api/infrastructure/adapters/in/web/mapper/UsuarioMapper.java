package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.Usuario;
import com.bodega.api.infrastructure.adapters.in.web.dto.UsuarioDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RolMapper.class})
public interface UsuarioMapper {
    UsuarioDTO toDto(Usuario domain);

    Usuario toDomain(UsuarioDTO dto);

    List<UsuarioDTO> toDtoList(List<Usuario> domainList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(UsuarioDTO dto, @MappingTarget Usuario domain);
}