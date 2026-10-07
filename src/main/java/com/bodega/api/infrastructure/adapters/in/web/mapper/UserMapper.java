package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.User;
import com.bodega.api.infrastructure.adapters.in.web.dto.UserDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {
    UserDTO toDto(User domain);

    User toDomain(UserDTO dto);

    List<UserDTO> toDtoList(List<User> domainList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(UserDTO dto, @MappingTarget User domain);
}