package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.PaymentMethod;
import com.bodega.api.infrastructure.adapters.in.web.dto.PaymentMethodDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {
    PaymentMethodDTO toDto(PaymentMethod domain);

    PaymentMethod toDomain(PaymentMethodDTO dto);

    List<PaymentMethodDTO> toDtoList(List<PaymentMethod> domainList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(PaymentMethodDTO dto, @MappingTarget PaymentMethod domain);
}