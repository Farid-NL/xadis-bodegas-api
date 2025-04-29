package com.farid.xadis.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "bodegas")
public class BodegaEntity {

    @Id
    private String codigo;

    private String nombre;

    @Column(length = 1)
    private String activo;

    private String documentopto;

    private String codigopto;

    @Column(length = 2)
    private String pais;

    private String departamento;

    private String provincia;

    private String distrito;

    private String ubigeo_pto;

    private String direccion_pto;

    private String procesawms;

    private LocalDate fecha_procesawms;

    private String metro2;

}
