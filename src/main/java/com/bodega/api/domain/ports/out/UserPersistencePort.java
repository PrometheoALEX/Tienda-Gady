package com.bodega.api.domain.ports.out;

import com.bodega.api.domain.model.User;
import java.util.List;
import java.util.Optional;

public interface UserPersistencePort {
    List<User> findAll();
    Optional<User> findById(Long id);
    User save(User user);
    void deleteById(Long id);
}