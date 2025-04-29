package com.farid.xadis.services;

import com.farid.xadis.domain.entities.BodegaEntity;
import com.farid.xadis.repositories.BodegaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BodegaService {
    private final BodegaRepository bodegaRepository;

    public BodegaService(BodegaRepository bodegaRepository) {
        this.bodegaRepository = bodegaRepository;
    }

    public BodegaEntity create(BodegaEntity bodegaEntity) {
        return bodegaRepository.save(bodegaEntity);
    }

    public List<BodegaEntity> findAll() {
        return bodegaRepository.findAll();
    }

    public Optional<BodegaEntity> findById(String codigo) {
        return bodegaRepository.findById(codigo);
    }
}
