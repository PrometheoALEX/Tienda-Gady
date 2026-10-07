package com.bodega.api.application.services;

import com.bodega.api.domain.exceptions.UserDeletionNotAllowedException;
import com.bodega.api.domain.exceptions.UserNotFoundException;
import com.bodega.api.domain.model.User;
import com.bodega.api.domain.ports.out.UserPersistencePort;
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
class UserServiceImplTest {

    @Mock
    private UserPersistencePort persistencePort;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
        user.setActive(true);
    }

    @Test
    void findById_WhenExists_ShouldReturnUser() {
        when(persistencePort.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void findById_WhenNotExists_ShouldThrowException() {
        when(persistencePort.findById(1L)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userService.findById(1L));
    }

    @Test
    void deleteById_WhenActive_ShouldThrowException() {
        when(persistencePort.findById(1L)).thenReturn(Optional.of(user));

        assertThrows(UserDeletionNotAllowedException.class, () -> userService.deleteById(1L));
        verify(persistencePort, never()).deleteById(1L);
    }
}