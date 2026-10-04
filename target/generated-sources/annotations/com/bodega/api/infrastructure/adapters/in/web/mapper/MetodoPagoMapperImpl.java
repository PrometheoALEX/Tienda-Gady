package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.MetodoPago;
import com.bodega.api.infrastructure.adapters.in.web.dto.MetodoPagoDTO;
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
public class MetodoPagoMapperImpl implements MetodoPagoMapper {

    @Override
    public MetodoPagoDTO toDto(MetodoPago domain) {
        if ( domain == null ) {
            return null;
        }

        MetodoPagoDTO.MetodoPagoDTOBuilder metodoPagoDTO = MetodoPagoDTO.builder();

        metodoPagoDTO.id( domain.getId() );
        metodoPagoDTO.nombre( domain.getNombre() );
        metodoPagoDTO.activo( domain.getActivo() );

        return metodoPagoDTO.build();
    }

    @Override
    public MetodoPago toDomain(MetodoPagoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MetodoPago metodoPago = new MetodoPago();

        metodoPago.setId( dto.getId() );
        metodoPago.setNombre( dto.getNombre() );
        metodoPago.setActivo( dto.getActivo() );

        return metodoPago;
    }

    @Override
    public List<MetodoPagoDTO> toDtoList(List<MetodoPago> domainList) {
        if ( domainList == null ) {
            return null;
        }

        List<MetodoPagoDTO> list = new ArrayList<MetodoPagoDTO>( domainList.size() );
        for ( MetodoPago metodoPago : domainList ) {
            list.add( toDto( metodoPago ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(MetodoPagoDTO dto, MetodoPago domain) {
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
