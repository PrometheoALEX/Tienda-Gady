package com.bodega.api.infrastructure.adapters.in.web.configuracion;

import com.bodega.api.infrastructure.adapters.out.persistence.entities.UserEntity;
import com.bodega.api.infrastructure.adapters.out.persistence.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository; // Para buscar en tu PostgreSQL

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override // 2. Implementamos el contrato obligatorio de Spring Security
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

        // Aquí es donde tú buscas el usuario en tu base de datos usando tu repositorio
        // (Buscamos en la tabla 'usuario' que vimos en tu diagrama)
        UserEntity userEntity = userRepository.findByEmail(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + correo));

        // Le entregamos los datos a Spring para que él haga la validación de la contraseña
        return User.builder()
                .username(userEntity.getEmail())
                .password(userEntity.getPassword()) // La contraseña que está guardada en tu BD
                .roles(userEntity.getRole().getName()) // El rol que viene de tu base de datos (ej: "ADMIN")
                .build();
    }

}
