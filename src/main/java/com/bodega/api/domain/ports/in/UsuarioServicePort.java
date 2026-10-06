package com.bodega.api.domain.ports.in;

import com.bodega.api.domain.model.Usuario;
import java.util.List;

public interface UsuarioServicePort {
    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario save(Usuario usuario);
    Usuario update(Long id, Usuario usuario);
    void deleteById(Long id);
}