package com.farid.xadis.controllers;

import com.farid.xadis.domain.dto.BodegaDTO;
import com.farid.xadis.domain.dto.BodegaDataWrapper;
import com.farid.xadis.domain.entities.BodegaEntity;
import com.farid.xadis.services.BodegaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Bodega Controller", description = "CRUD operations for bodegas schema")
@RestController
public class BodegaController {
    private final BodegaService bodegaService;

    private final ModelMapper modelMapper;

    public BodegaController(BodegaService bodegaService, ModelMapper modelMapper) {
        this.bodegaService = bodegaService;
        this.modelMapper = modelMapper;
    }

    @Operation(
        summary = "Create a single bodega",
        description = "Create a bodega by providing a JSON bodega object",
        responses = {
            @ApiResponse(
                description = "Successfully created",
                responseCode = "201"
            )
        }
    )
    @PostMapping("/bodega")
    public ResponseEntity<BodegaDTO> createBodega(@RequestBody BodegaDTO bodegaDTO) {
        BodegaEntity bodegaEntity = modelMapper.map(bodegaDTO, BodegaEntity.class);
        BodegaEntity savedBodegaEntity = bodegaService.save(bodegaEntity);
        return new ResponseEntity<>(modelMapper.map(savedBodegaEntity, BodegaDTO.class), HttpStatus.CREATED);
    }

    @Operation(
        summary = "Create multiple bodegas",
        description = "Create multiple bodegas by providing a JSON array with bodega objects",
        responses = {
            @ApiResponse(
                description = "Successfully created",
                responseCode = "201"
            )
        }
    )
    @PostMapping("/bodegas")
    public ResponseEntity<List<BodegaDTO>> createBodegas(@RequestBody List<BodegaDTO> bodegasDTO) {

        List<BodegaDTO> savedBodegas = bodegasDTO.stream().map(bodegaDTO -> {
            BodegaEntity bodegaEntity = modelMapper.map(bodegaDTO, BodegaEntity.class);
            BodegaEntity savedBodegaEntity = bodegaService.save(bodegaEntity);

            return modelMapper.map(savedBodegaEntity, BodegaDTO.class);
        }).toList();

        return new ResponseEntity<>(savedBodegas, HttpStatus.CREATED);
    }

    @Operation(
        summary = "Create multiple bodegas wrapped in a data array",
        description = "Create multiple bodegas by providing a JSON object with a array called data with bodega objects",
        responses = {
            @ApiResponse(
                description = "Successfully created",
                responseCode = "201"
            )
        }
    )
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

    @Operation(
        summary = "Retrieve all bodegas",
        description = "Retrieve all bodega entries",
        responses = {
            @ApiResponse(
                description = "Successfully retrieved",
                responseCode = "200"
            )
        }
    )
    @GetMapping("/bodegas")
    public ResponseEntity<List<BodegaDTO>> getBodegas() {
        List<BodegaEntity> bodegas = bodegaService.findAll();
        List<BodegaDTO> bodegasDTO = bodegas.stream().map(bodegaEntity -> modelMapper.map(bodegaEntity, BodegaDTO.class)).toList();

        return new ResponseEntity<>(bodegasDTO, HttpStatus.OK);
    }

    @Operation(
        summary = "Retrieve a single bodega",
        description = "Retrieve a bodega by providing its codigo",
        responses = {
            @ApiResponse(
                description = "Successfully retrieved",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "The bodega was not found",
                responseCode = "404"
            )
        }
    )
    @GetMapping("/bodega/{codigo}")
    public ResponseEntity<BodegaDTO> getBodega(@PathVariable("codigo") String codigo) {
        Optional<BodegaEntity> bodega = bodegaService.findById(codigo);

        if (bodega.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        BodegaEntity bodegaEntity = bodega.get();
        BodegaDTO bodegaDTO = modelMapper.map(bodegaEntity, BodegaDTO.class);

        return new ResponseEntity<>(bodegaDTO, HttpStatus.OK);
    }

    @Operation(
        summary = "Fully update a single bodega",
        description = "Fully update a bodega by providing its codigo",
        responses = {
            @ApiResponse(
                description = "Successfully updated",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "The bodega was not found",
                responseCode = "404"
            )
        }
    )
    @PutMapping("/bodega/{codigo}")
    public ResponseEntity<BodegaDTO> fullUpdateBodega(@PathVariable("codigo") String codigo, @RequestBody BodegaDTO bodegaDTO) {
        Optional<BodegaEntity> bodega = bodegaService.findById(codigo);

        if (bodega.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        bodegaDTO.setCodigo(codigo);
        BodegaEntity bodegaEntity = modelMapper.map(bodegaDTO, BodegaEntity.class);
        BodegaEntity savedBodegaEntity = bodegaService.save(bodegaEntity);

        return new ResponseEntity<>(modelMapper.map(savedBodegaEntity, BodegaDTO.class), HttpStatus.OK);
    }

    @Operation(
        summary = "Partially update a single bodega",
        description = "Partially update a bodega by providing its codigo",
        responses = {
            @ApiResponse(
                description = "Successfully updated",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "The bodega was not found",
                responseCode = "404"
            )
        }
    )
    @PatchMapping("/bodega/{codigo}")
    public ResponseEntity<BodegaDTO> partialUpdateBodega(@PathVariable("codigo") String codigo, @RequestBody BodegaDTO bodegaDTO) {
        Optional<BodegaEntity> bodega = bodegaService.findById(codigo);

        if (bodega.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        bodegaDTO.setCodigo(codigo);
        BodegaEntity bodegaEntity = modelMapper.map(bodegaDTO, BodegaEntity.class);
        BodegaEntity updatedBodegaEntity = bodegaService.partialUpdate(codigo, bodegaEntity);

        return new ResponseEntity<>(modelMapper.map(updatedBodegaEntity, BodegaDTO.class), HttpStatus.OK);
    }

    @Operation(
        summary = "Remove a single bodega",
        description = "Remove a bodega by providing its codigo",
        responses = {
            @ApiResponse(
                description = "Successfully removed",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "The bodega was not found",
                responseCode = "404"
            )
        }
    )
    @DeleteMapping("/bodega/{codigo}")
    public ResponseEntity<BodegaDTO> removeBodega(@PathVariable("codigo") String codigo) {
        Optional<BodegaEntity> bodega = bodegaService.findById(codigo);

        if (bodega.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        BodegaEntity deletedBodegaEntity = bodegaService.remove(codigo);

        return new ResponseEntity<>(modelMapper.map(deletedBodegaEntity, BodegaDTO.class), HttpStatus.OK);
    }
}
