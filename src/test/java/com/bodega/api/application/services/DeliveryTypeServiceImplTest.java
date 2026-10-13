package com.bodega.api.application.services;

import com.bodega.api.domain.model.DeliveryType;
import com.bodega.api.domain.ports.out.DeliveryTypePersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeliveryTypeServiceImplTest {

    @Mock
    private DeliveryTypePersistencePort persistencePort;

    @InjectMocks
    private DeliveryTypeServiceImpl deliveryTypeService;

    private DeliveryType deliveryType;

    @BeforeEach
    void setUp() {
        deliveryType = new DeliveryType ();
        deliveryType.setId(1L);
        deliveryType.setName("Express");
    }


    @Test
    void findById_WhenExists_ShouldReturnDeliveryType() {
        when(persistencePort.findById(1L)).thenReturn(Optional.of(deliveryType));

        DeliveryType ver = deliveryTypeService.findById(1L);

        assertEquals(deliveryType.getName(), ver.getName());
        verify(persistencePort, times(1)).findById(1L);
    }



}