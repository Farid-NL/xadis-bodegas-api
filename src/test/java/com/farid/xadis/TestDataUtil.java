package com.farid.xadis;

import com.farid.xadis.domain.entities.BodegaEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class TestDataUtil {
    public static BodegaEntity createBodegaEntityA() {
        return BodegaEntity.builder()
            .codigo("01")
            .nombre("01 ALMACEN OBSOLETOS")
            .activo("A")
            .documentopto("20427799973")
            .codigopto("0101")
            .pais("PE")
            .departamento("15")
            .provincia("LIMA")
            .distrito("ATE")
            .ubigeo_pto("150103")
            .direccion_pto("CALLE VULCANO N° 176 LOTE N° 6 MZ. F URB. INDUSTRIAL")
            .procesawms("S")
            .fecha_procesawms(LocalDate.parse("04/22/2025", DateTimeFormatter.ofPattern("MM/dd/yyyy")))
            .metro2(null)
            .build();
    }

    public static BodegaEntity createBodegaEntityB() {
        return BodegaEntity.builder()
            .codigo("01-2")
            .nombre("01-2 ALMACEN OBSOLETOS-CONSIGNACION")
            .activo("A")
            .documentopto("20427799973")
            .codigopto("0101")
            .pais("PE")
            .departamento("15")
            .provincia(null)
            .distrito("LIMA")
            .ubigeo_pto("150103")
            .direccion_pto("CALLE VULCANO N° 176 LOTE N° 6 MZ. F URB. INDUSTRIAL")
            .procesawms("S")
            .fecha_procesawms(LocalDate.parse("04/22/2025", DateTimeFormatter.ofPattern("MM/dd/yyyy")))
            .metro2(null)
            .build();
    }

    public static BodegaEntity createBodegaEntityC() {
        return BodegaEntity.builder()
            .codigo("02")
            .nombre("T02 ALMACEN CERCADO-JIRON5")
            .activo("A")
            .documentopto("20427799973")
            .codigopto("0164")
            .pais("PE")
            .departamento("15")
            .provincia("Lima")
            .distrito("LIMA")
            .ubigeo_pto("150101")
            .direccion_pto("JR DE LA UNION 553")
            .procesawms("S")
            .fecha_procesawms(LocalDate.parse("04/22/2025", DateTimeFormatter.ofPattern("MM/dd/yyyy")))
            .metro2(null)
            .build();
    }
}
