package com.farid.xadis.repositories;

import com.farid.xadis.domain.entities.BodegaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodegaRepository extends JpaRepository<BodegaEntity, Long> {
}
