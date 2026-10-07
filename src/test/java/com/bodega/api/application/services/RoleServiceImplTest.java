package com.bodega.api.application.services;

import com.bodega.api.domain.exceptions.RoleDeletionNotAllowedException;
import com.bodega.api.domain.exceptions.RoleNotFoundException;
import com.bodega.api.domain.model.Role;
import com.bodega.api.domain.ports.out.RolePersistencePort;
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
class RoleServiceImplTest {

    @Mock
    private RolePersistencePort persistencePort;

    @InjectMocks
    private RoleServiceImpl roleService;

    private Role role;

    @BeforeEach
    void setUp() {
        role = new Role();
        role.setId(1L);
        role.setName("ADMIN");
        role.setActive(true);
    }

    @Test
    void findAll_ShouldReturnRoleList() {
        when(persistencePort.findAll()).thenReturn(List.of(role));

        List<Role> result = roleService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(persistencePort, times(1)).findAll();
    }

    @Test
    void findById_WhenExists_ShouldReturnRole() {
        when(persistencePort.findById(1L)).thenReturn(Optional.of(role));

        Role result = roleService.findById(1L);

        assertNotNull(result);
        assertEquals("ADMIN", result.getName());
    }

    @Test
    void findById_WhenNotExists_ShouldThrowRoleNotFoundException() {
        when(persistencePort.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RoleNotFoundException.class, () -> roleService.findById(1L));
    }

    @Test
    void save_ShouldReturnSavedRole() {
        when(persistencePort.save(any(Role.class))).thenReturn(role);

        Role result = roleService.save(role);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void deleteById_WhenActive_ShouldThrowRoleDeletionNotAllowedException() {
        when(persistencePort.findById(1L)).thenReturn(Optional.of(role));

        assertThrows(RoleDeletionNotAllowedException.class, () -> roleService.deleteById(1L));
        verify(persistencePort, never()).deleteById(1L);
    }

    @Test
    void deleteById_WhenInactive_ShouldDeleteRole() {
        role.setActive(false);
        when(persistencePort.findById(1L)).thenReturn(Optional.of(role));

        roleService.deleteById(1L);

        verify(persistencePort, times(1)).deleteById(1L);
    }
}