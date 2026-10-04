package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.Categoria;
import com.bodega.api.infrastructure.adapters.in.web.dto.CategoriaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-04T10:18:35-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.10 (Oracle Corporation)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaDTO toDto(Categoria domain) {
        if ( domain == null ) {
            return null;
        }

        CategoriaDTO.CategoriaDTOBuilder categoriaDTO = CategoriaDTO.builder();

        categoriaDTO.id( domain.getId() );
        categoriaDTO.nombre( domain.getNombre() );
        categoriaDTO.activo( domain.getActivo() );

        return categoriaDTO.build();
    }

    @Override
    public Categoria toDomain(CategoriaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( dto.getId() );
        categoria.setNombre( dto.getNombre() );
        categoria.setActivo( dto.getActivo() );

        return categoria;
    }

    @Override
    public List<CategoriaDTO> toDtoList(List<Categoria> domainList) {
        if ( domainList == null ) {
            return null;
        }

        List<CategoriaDTO> list = new ArrayList<CategoriaDTO>( domainList.size() );
        for ( Categoria categoria : domainList ) {
            list.add( toDto( categoria ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(CategoriaDTO dto, Categoria domain) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            domain.setId( dto.getId() );
        }
        if ( dto.getNombre() != null ) {
            domain.setNombre( dto.getNombre() );
        }
        if ( dto.getActivo() != null ) {
            domain.setActivo( dto.getActivo() );
        }
    }
}
