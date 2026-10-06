package com.bodega.api.domain.ports.out;

import com.bodega.api.domain.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioPersistencePort {
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario usuario);
    void deleteById(Long id);
}