package com.farid.xadis.repositories;

import com.farid.xadis.TestDataUtil;
import com.farid.xadis.domain.entities.BodegaEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Test CRUD operations")
class BodegaRepositoryImplementationTests {

    @Autowired
    private BodegaRepository underTest;

    private BodegaEntity bodegaEntityA;

    @BeforeEach
    void setUp() {
        bodegaEntityA = TestDataUtil.createBodegaEntityA();
    }

    @Test
    @DisplayName("Should store and retrieve a Bodega")
    public void shouldStoreAndRetrieveBodega() {
        /* Act */
        underTest.save(bodegaEntityA);
        Optional<BodegaEntity> result = underTest.findById(bodegaEntityA.getId());

        /* Assert */
        assertTrue(result.isPresent());
        assertEquals(bodegaEntityA, result.get());
    }

    @Test
    @DisplayName("Should store and retrieve multiple Bodegas")
    public void shouldStoreAndRetrieveMultipleBodegas() {
        /* Arrange */
        BodegaEntity bodegaEntityB = TestDataUtil.createBodegaEntityB();
        BodegaEntity bodegaEntityC = TestDataUtil.createBodegaEntityC();

        /* Act */
        underTest.save(bodegaEntityA);
        underTest.save(bodegaEntityB);
        underTest.save(bodegaEntityC);
        List<BodegaEntity> result = underTest.findAll();

        /* Assert */
        assertEquals(3, result.size());
        assertEquals(List.of(bodegaEntityA, bodegaEntityB, bodegaEntityC), result);

    }

    @Test
    @DisplayName("Should update a Bodega correctly")
    public void shouldUpdateBodegaCorrectly() {
        /* Arrange */
        underTest.save(bodegaEntityA);

        /* Act */
        bodegaEntityA.setNombre("DIFFERENT");
        underTest.save(bodegaEntityA);
        Optional<BodegaEntity> result = underTest.findById(bodegaEntityA.getId());

        /* Assert */
        assertTrue(result.isPresent());
        assertEquals(bodegaEntityA, result.get());

    }

    @Test
    @DisplayName("Should delete a Bodega correctly")
    public void shouldDeleteBodegaCorrectly() {
        /* Arrange */
        underTest.save(bodegaEntityA);

        /* Act */
        underTest.delete(bodegaEntityA);
        Optional<BodegaEntity> result = underTest.findById(bodegaEntityA.getId());

        /* Assert */
        assertTrue(result.isEmpty());

    }
}
