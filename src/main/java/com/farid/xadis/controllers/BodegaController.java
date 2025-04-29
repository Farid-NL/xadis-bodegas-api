package com.farid.xadis.controllers;

import com.farid.xadis.domain.entities.BodegaEntity;
import com.farid.xadis.repositories.BodegaRepository;
import com.farid.xadis.services.BodegaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BodegaController {
    private final BodegaService bodegaService;

    public BodegaController(BodegaService bodegaService) {
        this.bodegaService = bodegaService;
    }

    @PostMapping("/bodega")
    public BodegaEntity createBodega(@RequestBody BodegaEntity bodegaEntity) {
        return bodegaService.create(bodegaEntity);
    }
}
