package com.bodega.api.application.services;

import com.bodega.api.domain.model.Usuario;
import com.bodega.api.domain.ports.in.UsuarioServicePort;
import com.bodega.api.domain.ports.out.UsuarioPersistencePort;
import com.bodega.api.domain.exceptions.UsuarioNotFoundException;
import com.bodega.api.domain.exceptions.UsuarioDeletionNotAllowedException;
import org.springframework.stereotype.Service;
import java.util.List;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor

@Service
public class UsuarioServiceImpl implements UsuarioServicePort {

    private final UsuarioPersistencePort persistencePort;


    @Override
    public List<Usuario> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con id: " + id));
    }

    @Override
    public Usuario save(Usuario usuario) {
        return persistencePort.save(usuario);
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        this.findById(id); // Asegura que el usuario existe antes de actualizar
        usuario.setId(id);
        return persistencePort.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        Usuario usuario = persistencePort.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con el ID: " + id));

        // Regla de negocio opcional: No permitir eliminar si está activo (igual que en Rol)
        if (Boolean.TRUE.equals(usuario.getActivo())) {
            throw new UsuarioDeletionNotAllowedException("No se puede eliminar el usuario porque está activo");
        }
        persistencePort.deleteById(id);
    }
}