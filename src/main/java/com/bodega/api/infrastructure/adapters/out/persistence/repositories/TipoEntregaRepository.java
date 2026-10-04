package com.bodega.api.infrastructure.adapters.out.persistence.repositories;

import com.bodega.api.infrastructure.adapters.out.persistence.entities.TipoEntregaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TipoEntregaRepository extends JpaRepository<TipoEntregaEntity, Long> {

}
