package com.bodega.api.application.services;

import com.bodega.api.domain.exceptions.PaymentMethodDeletionNotAllowedException;
import com.bodega.api.domain.exceptions.PaymentMethodNotFoundException;
import com.bodega.api.domain.model.PaymentMethod;
import com.bodega.api.domain.ports.out.PaymentMethodPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentMethodServiceImplTest {

    @Mock
    private PaymentMethodPersistencePort persistencePort;

    @InjectMocks
    private PaymentMethodServiceImpl paymentMethodService;

    private PaymentMethod paymentMethod;

    @BeforeEach
    void setUp() {
        paymentMethod = new PaymentMethod();
        paymentMethod.setId(1L);
        paymentMethod.setName("Credit Card");
        paymentMethod.setActive(true);
    }

    @Test
    void findAll_ShouldReturnPaymentMethodList() {
        when(persistencePort.findAll()).thenReturn(List.of(paymentMethod));

        List<PaymentMethod> result = paymentMethodService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(persistencePort, times(1)).findAll();
    }

    @Test
    void findById_WhenExists_ShouldReturnPaymentMethod() {
        when(persistencePort.findById(1L)).thenReturn(Optional.of(paymentMethod));

        PaymentMethod result = paymentMethodService.findById(1L);

        assertNotNull(result);
        assertEquals("Credit Card", result.getName());
    }

    @Test
    void findById_WhenNotExists_ShouldThrowPaymentMethodNotFoundException() {
        when(persistencePort.findById(1L)).thenReturn(Optional.empty());

        assertThrows(PaymentMethodNotFoundException.class, () -> paymentMethodService.findById(1L));
    }

    @Test
    void save_ShouldReturnSavedPaymentMethod() {
        when(persistencePort.save(any(PaymentMethod.class))).thenReturn(paymentMethod);

        PaymentMethod result = paymentMethodService.save(paymentMethod);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void deleteById_WhenActive_ShouldThrowPaymentMethodDeletionNotAllowedException() {
        when(persistencePort.findById(1L)).thenReturn(Optional.of(paymentMethod));

        assertThrows(PaymentMethodDeletionNotAllowedException.class, () -> paymentMethodService.deleteById(1L));
        verify(persistencePort, never()).deleteById(1L);
    }

    @Test
    void deleteById_WhenInactive_ShouldDeletePaymentMethod() {
        paymentMethod.setActive(false);
        when(persistencePort.findById(1L)).thenReturn(Optional.of(paymentMethod));

        paymentMethodService.deleteById(1L);

        verify(persistencePort, times(1)).deleteById(1L);
    }
}