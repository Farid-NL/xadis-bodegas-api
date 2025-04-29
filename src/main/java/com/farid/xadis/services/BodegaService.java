package com.farid.xadis.services;

import com.farid.xadis.domain.entities.BodegaEntity;

import java.util.List;

public interface BodegaService {
    BodegaEntity create(BodegaEntity bodegaEntity);

    List<BodegaEntity> findAll();
}
