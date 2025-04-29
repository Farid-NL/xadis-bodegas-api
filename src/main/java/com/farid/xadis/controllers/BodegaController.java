package com.farid.xadis.controllers;

import com.farid.xadis.domain.dto.BodegaDTO;
import com.farid.xadis.domain.dto.BodegaDataWrapper;
import com.farid.xadis.domain.entities.BodegaEntity;
import com.farid.xadis.services.BodegaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        BodegaEntity savedBodegaEntity = bodegaService.save(bodegaEntity);
        return new ResponseEntity<>(modelMapper.map(savedBodegaEntity, BodegaDTO.class), HttpStatus.CREATED);
    }

    @PostMapping("/bodegas")
    public ResponseEntity<List<BodegaDTO>> createBodegas(@RequestBody List<BodegaDTO> bodegasDTO) {

        List<BodegaDTO> savedBodegas = bodegasDTO.stream().map(bodegaDTO -> {
            BodegaEntity bodegaEntity = modelMapper.map(bodegaDTO, BodegaEntity.class);
            BodegaEntity savedBodegaEntity = bodegaService.save(bodegaEntity);

            return modelMapper.map(savedBodegaEntity, BodegaDTO.class);
        }).toList();

        return new ResponseEntity<>(savedBodegas, HttpStatus.CREATED);
    }

    @PostMapping("/bodegas/data")
    public ResponseEntity<List<BodegaDTO>> createBodegas(@RequestBody BodegaDataWrapper dataWrapper) {
        List<BodegaDTO> bodegas = dataWrapper.getData();

        List<BodegaDTO> savedBodegas = bodegas.stream().map(bodegaDTO -> {
            BodegaEntity bodegaEntity = modelMapper.map(bodegaDTO, BodegaEntity.class);
            BodegaEntity savedBodegaEntity = bodegaService.save(bodegaEntity);

            return modelMapper.map(savedBodegaEntity, BodegaDTO.class);
        }).toList();

        return new ResponseEntity<>(savedBodegas, HttpStatus.CREATED);
    }

    @GetMapping("/bodegas")
    public ResponseEntity<List<BodegaDTO>> getBodegas() {
        List<BodegaEntity> bodegas = bodegaService.findAll();
        List<BodegaDTO> bodegasDTO = bodegas.stream().map(bodegaEntity -> modelMapper.map(bodegaEntity, BodegaDTO.class)).toList();

        return new ResponseEntity<>(bodegasDTO, HttpStatus.OK);
    }

    @GetMapping("/bodega/{codigo}")
    public ResponseEntity<BodegaDTO> getBodega(@PathVariable("codigo") String codigo) {
        Optional<BodegaEntity> bodega = bodegaService.findById(codigo);

        if (bodega.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        BodegaEntity bodegaEntity = bodega.get();
        BodegaDTO bodegaDTO = modelMapper.map(bodegaEntity, BodegaDTO.class);

        return new ResponseEntity<>(bodegaDTO, HttpStatus.OK);
    }

    @PutMapping("/bodega/{codigo}")
    public ResponseEntity<BodegaDTO> fullUpdateBodega(@PathVariable("codigo") String codigo, @RequestBody BodegaDTO bodegaDTO) {
        Optional<BodegaEntity> bodega = bodegaService.findById(codigo);

        if (bodega.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        bodegaDTO.setCodigo(codigo);
        BodegaEntity bodegaEntity = modelMapper.map(bodegaDTO, BodegaEntity.class);
        BodegaEntity savedBodegaEntity = bodegaService.save(bodegaEntity);

        return new ResponseEntity<>(modelMapper.map(savedBodegaEntity, BodegaDTO.class), HttpStatus.OK);
    }

    @PatchMapping("/bodega/{codigo}")
    public ResponseEntity<BodegaDTO> partialUpdateBodega(@PathVariable("codigo") String codigo, @RequestBody BodegaDTO bodegaDTO) {
        Optional<BodegaEntity> bodega = bodegaService.findById(codigo);

        if (bodega.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        bodegaDTO.setCodigo(codigo);
        BodegaEntity bodegaEntity = modelMapper.map(bodegaDTO, BodegaEntity.class);
        BodegaEntity updatedBodegaEntity = bodegaService.partialUpdate(codigo, bodegaEntity);

        return new ResponseEntity<>(modelMapper.map(updatedBodegaEntity, BodegaDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/bodega/{codigo}")
    public ResponseEntity<BodegaDTO> removeBodega(@PathVariable("codigo") String codigo) {
        Optional<BodegaEntity> bodega = bodegaService.findById(codigo);

        if (bodega.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        BodegaEntity deletedBodegaEntity = bodegaService.remove(codigo);

        return new ResponseEntity<>(modelMapper.map(deletedBodegaEntity, BodegaDTO.class), HttpStatus.OK);
    }
}
