package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.PaymentMethod;
import com.bodega.api.infrastructure.adapters.in.web.dto.PaymentMethodDTO;
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
public class PaymentMethodMapperImpl implements PaymentMethodMapper {

    @Override
    public PaymentMethodDTO toDto(PaymentMethod domain) {
        if ( domain == null ) {
            return null;
        }

        PaymentMethodDTO.PaymentMethodDTOBuilder paymentMethodDTO = PaymentMethodDTO.builder();

        paymentMethodDTO.id( domain.getId() );
        paymentMethodDTO.name( domain.getName() );
        paymentMethodDTO.active( domain.getActive() );

        return paymentMethodDTO.build();
    }

    @Override
    public PaymentMethod toDomain(PaymentMethodDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PaymentMethod paymentMethod = new PaymentMethod();

        paymentMethod.setId( dto.getId() );
        paymentMethod.setName( dto.getName() );
        paymentMethod.setActive( dto.getActive() );

        return paymentMethod;
    }

    @Override
    public List<PaymentMethodDTO> toDtoList(List<PaymentMethod> domainList) {
        if ( domainList == null ) {
            return null;
        }

        List<PaymentMethodDTO> list = new ArrayList<PaymentMethodDTO>( domainList.size() );
        for ( PaymentMethod paymentMethod : domainList ) {
            list.add( toDto( paymentMethod ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(PaymentMethodDTO dto, PaymentMethod domain) {
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
