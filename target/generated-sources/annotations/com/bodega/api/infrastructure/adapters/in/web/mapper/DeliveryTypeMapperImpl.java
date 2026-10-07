package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.DeliveryType;
import com.bodega.api.infrastructure.adapters.in.web.dto.DeliveryTypeDTO;
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
public class DeliveryTypeMapperImpl implements DeliveryTypeMapper {

    @Override
    public DeliveryTypeDTO toDto(DeliveryType domain) {
        if ( domain == null ) {
            return null;
        }

        DeliveryTypeDTO.DeliveryTypeDTOBuilder deliveryTypeDTO = DeliveryTypeDTO.builder();

        deliveryTypeDTO.id( domain.getId() );
        deliveryTypeDTO.name( domain.getName() );

        return deliveryTypeDTO.build();
    }

    @Override
    public DeliveryType toDomain(DeliveryTypeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DeliveryType deliveryType = new DeliveryType();

        deliveryType.setId( dto.getId() );
        deliveryType.setName( dto.getName() );

        return deliveryType;
    }

    @Override
    public List<DeliveryTypeDTO> toDtoList(List<DeliveryType> domainList) {
        if ( domainList == null ) {
            return null;
        }

        List<DeliveryTypeDTO> list = new ArrayList<DeliveryTypeDTO>( domainList.size() );
        for ( DeliveryType deliveryType : domainList ) {
            list.add( toDto( deliveryType ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(DeliveryTypeDTO dto, DeliveryType domain) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            domain.setId( dto.getId() );
        }
        if ( dto.getName() != null ) {
            domain.setName( dto.getName() );
        }
    }
}
