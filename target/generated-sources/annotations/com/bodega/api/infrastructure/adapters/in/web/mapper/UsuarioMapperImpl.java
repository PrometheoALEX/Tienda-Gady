package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.Rol;
import com.bodega.api.domain.model.Usuario;
import com.bodega.api.infrastructure.adapters.in.web.dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-05T19:23:15-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.10 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Autowired
    private RolMapper rolMapper;

    @Override
    public UsuarioDTO toDto(Usuario domain) {
        if ( domain == null ) {
            return null;
        }

        UsuarioDTO.UsuarioDTOBuilder usuarioDTO = UsuarioDTO.builder();

        usuarioDTO.id( domain.getId() );
        usuarioDTO.rol( rolMapper.toDto( domain.getRol() ) );
        usuarioDTO.nombres( domain.getNombres() );
        usuarioDTO.apellidos( domain.getApellidos() );
        usuarioDTO.dni( domain.getDni() );
        usuarioDTO.celular( domain.getCelular() );
        usuarioDTO.correo( domain.getCorreo() );
        usuarioDTO.contrasena( domain.getContrasena() );
        usuarioDTO.activo( domain.getActivo() );
        usuarioDTO.fechaRegistro( domain.getFechaRegistro() );

        return usuarioDTO.build();
    }

    @Override
    public Usuario toDomain(UsuarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( dto.getId() );
        usuario.setRol( rolMapper.toDomain( dto.getRol() ) );
        usuario.setNombres( dto.getNombres() );
        usuario.setApellidos( dto.getApellidos() );
        usuario.setDni( dto.getDni() );
        usuario.setCelular( dto.getCelular() );
        usuario.setCorreo( dto.getCorreo() );
        usuario.setContrasena( dto.getContrasena() );
        usuario.setActivo( dto.getActivo() );
        usuario.setFechaRegistro( dto.getFechaRegistro() );

        return usuario;
    }

    @Override
    public List<UsuarioDTO> toDtoList(List<Usuario> domainList) {
        if ( domainList == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>( domainList.size() );
        for ( Usuario usuario : domainList ) {
            list.add( toDto( usuario ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(UsuarioDTO dto, Usuario domain) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            domain.setId( dto.getId() );
        }
        if ( dto.getRol() != null ) {
            if ( domain.getRol() == null ) {
                domain.setRol( new Rol() );
            }
            rolMapper.updateEntityFromDto( dto.getRol(), domain.getRol() );
        }
        if ( dto.getNombres() != null ) {
            domain.setNombres( dto.getNombres() );
        }
        if ( dto.getApellidos() != null ) {
            domain.setApellidos( dto.getApellidos() );
        }
        if ( dto.getDni() != null ) {
            domain.setDni( dto.getDni() );
        }
        if ( dto.getCelular() != null ) {
            domain.setCelular( dto.getCelular() );
        }
        if ( dto.getCorreo() != null ) {
            domain.setCorreo( dto.getCorreo() );
        }
        if ( dto.getContrasena() != null ) {
            domain.setContrasena( dto.getContrasena() );
        }
        if ( dto.getActivo() != null ) {
            domain.setActivo( dto.getActivo() );
        }
        if ( dto.getFechaRegistro() != null ) {
            domain.setFechaRegistro( dto.getFechaRegistro() );
        }
    }
}
