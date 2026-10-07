package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.Role;
import com.bodega.api.domain.model.User;
import com.bodega.api.infrastructure.adapters.in.web.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-07T12:09:01-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.12.1 (Ubuntu)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDTO toDto(User domain) {
        if ( domain == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.id( domain.getId() );
        userDTO.role( roleMapper.toDto( domain.getRole() ) );
        userDTO.firstName( domain.getFirstName() );
        userDTO.lastName( domain.getLastName() );
        userDTO.dni( domain.getDni() );
        userDTO.phone( domain.getPhone() );
        userDTO.email( domain.getEmail() );
        userDTO.password( domain.getPassword() );
        userDTO.active( domain.getActive() );
        userDTO.registrationDate( domain.getRegistrationDate() );

        return userDTO.build();
    }

    @Override
    public User toDomain(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setRole( roleMapper.toDomain( dto.getRole() ) );
        user.setFirstName( dto.getFirstName() );
        user.setLastName( dto.getLastName() );
        user.setDni( dto.getDni() );
        user.setPhone( dto.getPhone() );
        user.setEmail( dto.getEmail() );
        user.setPassword( dto.getPassword() );
        user.setActive( dto.getActive() );
        user.setRegistrationDate( dto.getRegistrationDate() );

        return user;
    }

    @Override
    public List<UserDTO> toDtoList(List<User> domainList) {
        if ( domainList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( domainList.size() );
        for ( User user : domainList ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(UserDTO dto, User domain) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            domain.setId( dto.getId() );
        }
        if ( dto.getRole() != null ) {
            if ( domain.getRole() == null ) {
                domain.setRole( new Role() );
            }
            roleMapper.updateEntityFromDto( dto.getRole(), domain.getRole() );
        }
        if ( dto.getFirstName() != null ) {
            domain.setFirstName( dto.getFirstName() );
        }
        if ( dto.getLastName() != null ) {
            domain.setLastName( dto.getLastName() );
        }
        if ( dto.getDni() != null ) {
            domain.setDni( dto.getDni() );
        }
        if ( dto.getPhone() != null ) {
            domain.setPhone( dto.getPhone() );
        }
        if ( dto.getEmail() != null ) {
            domain.setEmail( dto.getEmail() );
        }
        if ( dto.getPassword() != null ) {
            domain.setPassword( dto.getPassword() );
        }
        if ( dto.getActive() != null ) {
            domain.setActive( dto.getActive() );
        }
        if ( dto.getRegistrationDate() != null ) {
            domain.setRegistrationDate( dto.getRegistrationDate() );
        }
    }
}
