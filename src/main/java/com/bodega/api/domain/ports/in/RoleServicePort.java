package com.bodega.api.domain.ports.in;

import com.bodega.api.domain.model.Role;
import java.util.List;

public interface RoleServicePort {
    List<Role> findAll();
    Role findById(Long id);
    Role save(Role role);
    Role update(Long id, Role role);
    void deleteById(Long id);
}