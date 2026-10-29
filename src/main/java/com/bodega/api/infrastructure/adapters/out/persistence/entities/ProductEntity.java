package com.bodega.api.infrastructure.adapters.out.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "producto")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoryEntity category;

    @Column(name = "nombre", nullable = false, length = 150)
    private String name;

    @Column(name = "descripcion", length = 500)
    private String description;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "imagen", length = 255)
    private String image;

    @Column(name = "descuento")
    private Integer discount;

    @Column(name = "activo")
    private Boolean active;
}