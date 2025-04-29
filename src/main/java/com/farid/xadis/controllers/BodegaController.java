package com.farid.xadis.controllers;

import com.farid.xadis.domain.entities.BodegaEntity;
import com.farid.xadis.repositories.BodegaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BodegaController {
    private final BodegaRepository bodegaRepository;

    public BodegaController(BodegaRepository bodegaRepository) {
        this.bodegaRepository = bodegaRepository;
    }

    @PostMapping("/bodega")
    public BodegaEntity createBodega(@RequestBody BodegaEntity bodegaEntity) {
        return bodegaRepository.save(bodegaEntity);
    }
}
