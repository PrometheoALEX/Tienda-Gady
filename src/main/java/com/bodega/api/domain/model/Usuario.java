package com.bodega.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private Long id;
    private Rol rol;
    private String nombres;
    private String apellidos;
    private String dni;
    private String celular;
    private String correo;
    private String contrasena;
    private Boolean activo;
    private LocalDateTime fechaRegistro;

    public static Usuario crear(Rol rol, String nombres, String apellidos, String dni, String correo, String contrasena) {
        if (dni == null ||   dni.isEmpty() || dni.length() != 8) {
            throw new IllegalArgumentException("El DNI es obligatorio y debe tener exactamente 8 caracteres");
        }
        if (correo == null  || correo.isEmpty() || !correo.contains("@")) {
            throw new IllegalArgumentException("El correo electrónico no es válido");
        }
        if (nombres == null   || nombres.isEmpty()) {
            throw new IllegalArgumentException("Los nombres son obligatorios");
        }

        Usuario usuario = new Usuario();
        usuario.setRol(rol);
        usuario.setNombres(nombres);
        usuario.setApellidos(apellidos);
        usuario.setDni(dni);
        usuario.setCorreo(correo);
        usuario.setContrasena(contrasena);
        usuario.setActivo(true);
        usuario.setFechaRegistro(LocalDateTime.now()); // <-Este momento

        return usuario;
    }
}