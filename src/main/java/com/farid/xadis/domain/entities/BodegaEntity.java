package com.farid.xadis.domain.entities;

import jakarta.persistence.*;
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
@SequenceGenerator(name = "id_seq", allocationSize = 1)
@Table(name = "bodegas")
public class BodegaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_seq")
    private Long id;

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
