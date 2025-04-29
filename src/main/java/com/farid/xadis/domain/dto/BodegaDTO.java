package com.farid.xadis.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(example = "01")
    private String codigo;

    @Schema(example = "01 ALMACEN OBSOLETOS")
    private String nombre;

    @Schema(example = "A")
    private String activo;

    @Schema(example = "20427799973")
    private String documentopto;

    @Schema(example = "0101")
    private String codigopto;

    @Schema(example = "PE")
    private String pais;

    @Schema(example = "15")
    private String departamento;

    @Schema(example = "LIMA")
    private String provincia;

    @Schema(example = "ATE")
    private String distrito;

    @Schema(example = "150103")
    private String ubigeo_pto;

    @Schema(example = "CALLE VULCANO N° 176 LOTE N° 6 MZ. F URB. INDUSTRIAL")
    private String direccion_pto;

    @Schema(example = "S")
    private String procesawms;

    @Schema(example = "04/22/2025")
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate fecha_procesawms;

    @Schema(example = "null")
    private String metro2;

}
