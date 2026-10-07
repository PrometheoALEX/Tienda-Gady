package com.bodega.api.infrastructure.adapters.out.persistence.repositories;

import com.bodega.api.infrastructure.adapters.out.persistence.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}