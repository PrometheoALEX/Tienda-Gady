package com.bodega.api.application.services;

import com.bodega.api.domain.exceptions.RoleDeletionNotAllowedException;
import com.bodega.api.domain.exceptions.RoleNotFoundException;
import com.bodega.api.domain.model.Role;
import com.bodega.api.domain.ports.in.RoleServicePort;
import com.bodega.api.domain.ports.out.RolePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleServicePort {

    private final RolePersistencePort persistencePort;

    @Override
    public List<Role> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Role findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role not found with id: " + id));
    }

    @Override
    public Role save(Role role) {
        return persistencePort.save(role);
    }

    @Override
    public Role update(Long id, Role role) {
        this.findById(id);
        role.setId(id);
        return persistencePort.save(role);
    }

    @Override
    public void deleteById(Long id) {
        Role role = this.findById(id);

        if (Boolean.TRUE.equals(role.getActive())) {
            throw new RoleDeletionNotAllowedException("Cannot delete role because it is active");
        }

        persistencePort.deleteById(id);
    }
}