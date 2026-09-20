package com.bodega.api.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TipoEntregaDTO {

    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

}
