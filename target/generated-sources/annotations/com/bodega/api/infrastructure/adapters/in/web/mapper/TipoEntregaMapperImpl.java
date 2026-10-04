package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.TipoEntrega;
import com.bodega.api.infrastructure.adapters.in.web.dto.TipoEntregaDTO;
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
public class TipoEntregaMapperImpl implements TipoEntregaMapper {

    @Override
    public TipoEntregaDTO toDto(TipoEntrega domain) {
        if ( domain == null ) {
            return null;
        }

        TipoEntregaDTO.TipoEntregaDTOBuilder tipoEntregaDTO = TipoEntregaDTO.builder();

        tipoEntregaDTO.id( domain.getId() );
        tipoEntregaDTO.nombre( domain.getNombre() );

        return tipoEntregaDTO.build();
    }

    @Override
    public TipoEntrega toDomain(TipoEntregaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TipoEntrega tipoEntrega = new TipoEntrega();

        tipoEntrega.setId( dto.getId() );
        tipoEntrega.setNombre( dto.getNombre() );

        return tipoEntrega;
    }

    @Override
    public List<TipoEntregaDTO> toDtoList(List<TipoEntrega> domainList) {
        if ( domainList == null ) {
            return null;
        }

        List<TipoEntregaDTO> list = new ArrayList<TipoEntregaDTO>( domainList.size() );
        for ( TipoEntrega tipoEntrega : domainList ) {
            list.add( toDto( tipoEntrega ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(TipoEntregaDTO dto, TipoEntrega domain) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            domain.setId( dto.getId() );
        }
        if ( dto.getNombre() != null ) {
            domain.setNombre( dto.getNombre() );
        }
    }
}
