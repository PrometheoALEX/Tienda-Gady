package com.bodega.api.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipoentrega")

@Builder

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class TipoEntregaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre", nullable = false, length = 50)
    private String nombre;

}
