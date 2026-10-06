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
    private Rol rol; // Relación con la entidad Rol que ya tienes creada
    private String nombres;
    private String apellidos;
    private String dni;
    private String celular;
    private String correo;
    private String contrasena;
    private Boolean activo;
    private LocalDateTime fechaRegistro;
}