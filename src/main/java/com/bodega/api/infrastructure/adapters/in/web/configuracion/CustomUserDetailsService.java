package com.bodega.api.infrastructure.adapters.in.web.configuracion;

import com.bodega.api.infrastructure.adapters.out.persistence.entities.UserEntity;
import com.bodega.api.infrastructure.adapters.out.persistence.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
//2

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + correo));

        // Usamos .authorities() con SimpleGrantedAuthority para que respete el nombre "ROLE_USUARIO" sin duplicar el prefijo
        return User.builder()
                .username(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(Collections.singletonList(new SimpleGrantedAuthority(userEntity.getRole().getName())))
                .build();
    }
}