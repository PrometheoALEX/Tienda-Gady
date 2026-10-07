package com.bodega.api.infrastructure.adapters.in.web.controllers;

import com.bodega.api.domain.model.User;
import com.bodega.api.domain.ports.in.UserServicePort;
import com.bodega.api.infrastructure.adapters.in.web.dto.UserDTO;
import com.bodega.api.infrastructure.adapters.in.web.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServicePort userServicePort;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userServicePort.findAll();
        return ResponseEntity.ok(userMapper.toDtoList(users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        User user = userServicePort.findById(id);
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@Valid @RequestBody UserDTO dto) {
        User user = userMapper.toDomain(dto);
        User savedUser = userServicePort.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toDto(savedUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(
            @PathVariable Long id, @Valid @RequestBody UserDTO dto) {
        User user = userMapper.toDomain(dto);
        User updatedUser = userServicePort.update(id, user);
        return ResponseEntity.ok(userMapper.toDto(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}