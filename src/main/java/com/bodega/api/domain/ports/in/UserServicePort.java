package com.bodega.api.domain.ports.in;

import com.bodega.api.domain.model.User;
import java.util.List;

public interface UserServicePort {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    User update(Long id, User user);
    void deleteById(Long id);
}