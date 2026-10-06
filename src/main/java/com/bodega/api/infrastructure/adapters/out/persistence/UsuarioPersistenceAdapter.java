package com.bodega.api.infrastructure.adapters.out.persistence;

import com.bodega.api.domain.model.Usuario;
import com.bodega.api.domain.ports.out.UsuarioPersistencePort;
import com.bodega.api.infrastructure.adapters.out.persistence.entities.UsuarioEntity;
import com.bodega.api.infrastructure.adapters.out.persistence.mapper.UsuarioPersistenceMapper;
import com.bodega.api.infrastructure.adapters.out.persistence.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioPersistenceAdapter implements UsuarioPersistencePort {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioPersistenceMapper mapper;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        UsuarioEntity savedEntity = usuarioRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}