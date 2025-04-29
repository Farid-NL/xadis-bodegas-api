package com.farid.xadis.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    private String codigo;

    private String nombre;

    private String activo;

    private String documentopto;

    private String codigopto;

    private String pais;

    private String departamento;

    private String provincia;

    private String distrito;

    private String ubigeo_pto;

    private String direccion_pto;

    private String procesawms;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate fecha_procesawms;

    private String metro2;

}
