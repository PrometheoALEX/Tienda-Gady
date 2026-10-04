package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.Rol;
import com.bodega.api.infrastructure.adapters.in.web.dto.RolDTO;
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
public class RolMapperImpl implements RolMapper {

    @Override
    public RolDTO toDto(Rol domain) {
        if ( domain == null ) {
            return null;
        }

        RolDTO.RolDTOBuilder rolDTO = RolDTO.builder();

        rolDTO.id( domain.getId() );
        rolDTO.nombre( domain.getNombre() );
        rolDTO.activo( domain.getActivo() );

        return rolDTO.build();
    }

    @Override
    public Rol toDomain(RolDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Rol rol = new Rol();

        rol.setId( dto.getId() );
        rol.setNombre( dto.getNombre() );
        rol.setActivo( dto.getActivo() );

        return rol;
    }

    @Override
    public List<RolDTO> toDtoList(List<Rol> domainList) {
        if ( domainList == null ) {
            return null;
        }

        List<RolDTO> list = new ArrayList<RolDTO>( domainList.size() );
        for ( Rol rol : domainList ) {
            list.add( toDto( rol ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(RolDTO dto, Rol domain) {
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
