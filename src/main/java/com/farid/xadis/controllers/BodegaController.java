package com.farid.xadis.controllers;

import com.farid.xadis.domain.dto.BodegaDTO;
import com.farid.xadis.domain.entities.BodegaEntity;
import com.farid.xadis.services.BodegaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BodegaController {
    private final BodegaService bodegaService;

    private final ModelMapper modelMapper;

    public BodegaController(BodegaService bodegaService, ModelMapper modelMapper) {
        this.bodegaService = bodegaService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/bodega")
    public ResponseEntity<BodegaDTO> createBodega(@RequestBody BodegaDTO bodegaDTO) {
        BodegaEntity bodegaEntity = modelMapper.map(bodegaDTO, BodegaEntity.class);
        BodegaEntity savedBodegaEntity = bodegaService.create(bodegaEntity);
        return new ResponseEntity<>(modelMapper.map(savedBodegaEntity, BodegaDTO.class), HttpStatus.CREATED);
    }
}
