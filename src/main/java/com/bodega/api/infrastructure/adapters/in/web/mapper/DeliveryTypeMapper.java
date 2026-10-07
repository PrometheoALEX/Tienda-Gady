package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.DeliveryType;
import com.bodega.api.infrastructure.adapters.in.web.dto.DeliveryTypeDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeliveryTypeMapper {
    DeliveryTypeDTO toDto(DeliveryType domain);

    DeliveryType toDomain(DeliveryTypeDTO dto);

    List<DeliveryTypeDTO> toDtoList(List<DeliveryType> domainList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(DeliveryTypeDTO dto, @MappingTarget DeliveryType domain);
}