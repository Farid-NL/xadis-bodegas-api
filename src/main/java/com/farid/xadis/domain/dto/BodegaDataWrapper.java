package com.farid.xadis.domain.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BodegaDataWrapper {

    @Valid
    @NotEmpty(message = "Input bodega list cannot be empty")
    private List<BodegaDTO> data;
}
