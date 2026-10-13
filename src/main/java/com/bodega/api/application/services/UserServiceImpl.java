package com.bodega.api.application.services;

import com.bodega.api.domain.exceptions.UserDeletionNotAllowedException;
import com.bodega.api.domain.exceptions.UserNotFoundException;
import com.bodega.api.domain.model.User;
import com.bodega.api.domain.ports.in.UserServicePort;
import com.bodega.api.domain.ports.out.UserPersistencePort;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Data
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserServicePort {

    private final UserPersistencePort persistencePort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        // 1. Ciframos la contraseña en texto plano que viene del JSON antes de guardarla
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        // 2. Guardamos usando tu persistencePort existente
        return persistencePort.save(user); // O el método que uses para guardar en tu puerto
    }

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
        // Si la fecha de registro es nula, le asignamos la fecha actual automáticamente
        if (user.getRegistrationDate() == null) {
            user.setRegistrationDate(java.time.LocalDateTime.now());
        }

        // Ciframos la contraseña con BCrypt si no está cifrada
        if (user.getPassword() != null && !user.getPassword().startsWith("$2a$")) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

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