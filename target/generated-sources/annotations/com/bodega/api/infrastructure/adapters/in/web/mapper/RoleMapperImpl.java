package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.Role;
import com.bodega.api.infrastructure.adapters.in.web.dto.RoleDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-07T12:09:02-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.12.1 (Ubuntu)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDTO toDto(Role domain) {
        if ( domain == null ) {
            return null;
        }

        RoleDTO.RoleDTOBuilder roleDTO = RoleDTO.builder();

        roleDTO.id( domain.getId() );
        roleDTO.name( domain.getName() );
        roleDTO.active( domain.getActive() );

        return roleDTO.build();
    }

    @Override
    public Role toDomain(RoleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( dto.getId() );
        role.setName( dto.getName() );
        role.setActive( dto.getActive() );

        return role;
    }

    @Override
    public List<RoleDTO> toDtoList(List<Role> domainList) {
        if ( domainList == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( domainList.size() );
        for ( Role role : domainList ) {
            list.add( toDto( role ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(RoleDTO dto, Role domain) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            domain.setId( dto.getId() );
        }
        if ( dto.getName() != null ) {
            domain.setName( dto.getName() );
        }
        if ( dto.getActive() != null ) {
            domain.setActive( dto.getActive() );
        }
    }
}
