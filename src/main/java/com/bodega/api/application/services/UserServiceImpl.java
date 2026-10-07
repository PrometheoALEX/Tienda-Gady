package com.bodega.api.application.services;

import com.bodega.api.domain.exceptions.UserDeletionNotAllowedException;
import com.bodega.api.domain.exceptions.UserNotFoundException;
import com.bodega.api.domain.model.User;
import com.bodega.api.domain.ports.in.UserServicePort;
import com.bodega.api.domain.ports.out.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserServicePort {

    private final UserPersistencePort persistencePort;

    @Override
    public List<User> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public User findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public User save(User user) {
        return persistencePort.save(user);
    }

    @Override
    public User update(Long id, User user) {
        this.findById(id);
        user.setId(id);
        return persistencePort.save(user);
    }

    @Override
    public void deleteById(Long id) {
        User user = this.findById(id);

        if (Boolean.TRUE.equals(user.getActive())) {
            throw new UserDeletionNotAllowedException("Cannot delete user because it is active");
        }

        persistencePort.deleteById(id);
    }
}