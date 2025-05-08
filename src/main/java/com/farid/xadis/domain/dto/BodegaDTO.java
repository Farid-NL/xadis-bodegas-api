package com.farid.xadis.domain.dto;

import com.farid.xadis.validations.groups.OnCreate;
import com.farid.xadis.validations.groups.OnUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BodegaDTO {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(example = "01")
    @NotBlank(groups = OnCreate.class)
    private String codigo;

    @Schema(example = "01 ALMACEN OBSOLETOS")
    @NotBlank(groups = OnCreate.class)
    private String nombre;

    @Schema(example = "A")
    @NotBlank(groups = OnCreate.class)
    @Size(groups = {OnCreate.class, OnUpdate.class}, min = 1, max = 1)
    private String activo;

    @Schema(example = "20427799973")
    @NotBlank(groups = OnCreate.class)
    private String documentopto;

    @Schema(example = "0101")
    @NotBlank(groups = OnCreate.class)
    private String codigopto;

    @Schema(example = "PE")
    @NotBlank(groups = OnCreate.class)
    @Size(groups = {OnCreate.class, OnUpdate.class}, min = 2, max = 2)
    private String pais;

    @Schema(example = "15")
    @NotBlank(groups = OnCreate.class)
    private String departamento;

    @Schema(example = "LIMA")
    private String provincia;

    @Schema(example = "ATE")
    @NotBlank(groups = OnCreate.class)
    private String distrito;

    @Schema(example = "150103")
    @NotBlank(groups = OnCreate.class)
    private String ubigeo_pto;

    @Schema(example = "CALLE VULCANO N° 176 LOTE N° 6 MZ. F URB. INDUSTRIAL")
    @NotBlank(groups = OnCreate.class)
    private String direccion_pto;

    @Schema(example = "S")
    @NotBlank(groups = OnCreate.class)
    @Size(groups = {OnCreate.class, OnUpdate.class}, min = 1, max = 1)
    private String procesawms;

    @Schema(example = "04/22/2025")
    @JsonFormat(pattern = "MM/dd/yyyy")
    @NotNull(groups = OnCreate.class)
    private LocalDate fecha_procesawms;

    @Schema(example = "null")
    private String metro2;

}
