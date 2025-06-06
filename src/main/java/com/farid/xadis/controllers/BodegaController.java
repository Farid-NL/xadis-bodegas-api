package com.farid.xadis.controllers;

import com.farid.xadis.domain.dto.BodegaDTO;
import com.farid.xadis.domain.dto.BodegaDataWrapper;
import com.farid.xadis.services.BodegaService;
import com.farid.xadis.validations.groups.OnCreate;
import com.farid.xadis.validations.groups.OnUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Validated
@Tag(name = "Bodega Controller", description = "CRUD operations for bodegas schema")
@RestController
public class BodegaController {
    private final BodegaService bodegaService;

    public BodegaController(BodegaService bodegaService) {
        this.bodegaService = bodegaService;
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
    public ResponseEntity<BodegaDTO> createBodega(@Validated(OnCreate.class) @RequestBody BodegaDTO bodegaDTO) {
        return new ResponseEntity<>(bodegaService.save(bodegaDTO), HttpStatus.CREATED);
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
    @Validated(OnCreate.class)
    public ResponseEntity<Map<String, Integer>> createBodegas(
        @RequestBody
        @NotEmpty(message = "Input bodega list cannot be empty")
        List<@Valid BodegaDTO> bodegasDTO
    ) {
        int savedBodegas = bodegaService.saveAll(bodegasDTO);
        Map<String, Integer> response = Map.of("saved_bodegas", savedBodegas);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
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
    public ResponseEntity<Map<String, Integer>> createBodegas(@Validated(OnCreate.class) @RequestBody BodegaDataWrapper dataWrapper) {
        List<BodegaDTO> bodegas = dataWrapper.getData();
        int savedBodegas = bodegaService.saveAll(bodegas);
        Map<String, Integer> response = Map.of("saved_bodegas", savedBodegas);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
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
        return new ResponseEntity<>(bodegaService.findAll(), HttpStatus.OK);
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
    @GetMapping("/bodega/{id}")
    public ResponseEntity<BodegaDTO> getBodega(@Positive @PathVariable("id") Long id) {
        return bodegaService.findById(id)
            .map(bodegaDTO -> new ResponseEntity<>(bodegaDTO, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
    @PutMapping("/bodega/{id}")
    public ResponseEntity<BodegaDTO> fullUpdateBodega(
        @Positive @PathVariable("id") Long id,
        @Validated(OnUpdate.class) @RequestBody BodegaDTO bodegaDTO
    ) {
        return bodegaService.findById(id)
            .map(bodegaToBeUpdated -> new ResponseEntity<>(bodegaService.save(id, bodegaDTO), HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
    @PatchMapping("/bodega/{id}")
    @Validated(OnUpdate.class)
    public ResponseEntity<BodegaDTO> partialUpdateBodega(
        @Positive @PathVariable("id") Long id,
        @Validated(OnUpdate.class) @RequestBody BodegaDTO bodegaDTO
    ) {
        return bodegaService.partialUpdate(id, bodegaDTO)
            .map(bodegaUpdated -> new ResponseEntity<>(bodegaUpdated, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
    @DeleteMapping("/bodega/{id}")
    public ResponseEntity<BodegaDTO> removeBodega(@Positive @PathVariable("id") Long id) {
        return bodegaService.remove(id)
            .map(bodegaDTO -> new ResponseEntity<>(bodegaDTO, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
