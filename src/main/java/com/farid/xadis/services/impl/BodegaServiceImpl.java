package com.farid.xadis.services.impl;

import com.farid.xadis.domain.entities.BodegaEntity;
import com.farid.xadis.repositories.BodegaRepository;
import com.farid.xadis.services.BodegaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodegaServiceImpl implements BodegaService {
    private final BodegaRepository bodegaRepository;

    public BodegaServiceImpl(BodegaRepository bodegaRepository) {
        this.bodegaRepository = bodegaRepository;
    }

    @Override
    public BodegaEntity create(BodegaEntity bodegaEntity) {
        return bodegaRepository.save(bodegaEntity);
    }

    @Override
    public List<BodegaEntity> findAll() {
        return bodegaRepository.findAll();
    }
}
