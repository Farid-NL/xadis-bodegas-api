CREATE TABLE bodegas
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    codigo           VARCHAR(255) NULL,
    nombre           VARCHAR(255) NULL,
    activo           VARCHAR(1) NULL,
    documentopto     VARCHAR(255) NULL,
    codigopto        VARCHAR(255) NULL,
    pais             VARCHAR(2) NULL,
    departamento     VARCHAR(255) NULL,
    provincia        VARCHAR(255) NULL,
    distrito         VARCHAR(255) NULL,
    ubigeo_pto       VARCHAR(255) NULL,
    direccion_pto    VARCHAR(255) NULL,
    procesawms       VARCHAR(255) NULL,
    fecha_procesawms date NULL,
    metro2           VARCHAR(255) NULL,
    CONSTRAINT pk_bodegas PRIMARY KEY (id)
);
