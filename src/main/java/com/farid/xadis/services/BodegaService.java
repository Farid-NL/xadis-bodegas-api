package com.farid.xadis.services;

import com.farid.xadis.domain.dto.BodegaDTO;
import com.farid.xadis.domain.entities.BodegaEntity;
import com.farid.xadis.repositories.BodegaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BodegaService {
    private final BodegaRepository bodegaRepository;

    private final ModelMapper modelMapper;

    public BodegaService(BodegaRepository bodegaRepository, ModelMapper modelMapper) {
        this.bodegaRepository = bodegaRepository;
        this.modelMapper = modelMapper;
    }

    public BodegaDTO save(BodegaDTO bodegaDTO) {
        BodegaEntity bodegaEntity = modelMapper.map(bodegaDTO, BodegaEntity.class);
        BodegaEntity savedBodegaEntity = bodegaRepository.save(bodegaEntity);

        return modelMapper.map(savedBodegaEntity, BodegaDTO.class);
    }

    public List<BodegaEntity> findAll() {
        return bodegaRepository.findAll();
    }

    public Optional<BodegaEntity> findById(String codigo) {
        return bodegaRepository.findById(codigo);
    }

    public BodegaEntity partialUpdate(String codigo, BodegaEntity bodegaEntity) {

        return bodegaRepository.findById(codigo).map(bodegaToBeChanged -> {
            Optional.ofNullable(bodegaEntity.getNombre()).ifPresent(bodegaToBeChanged::setNombre);
            Optional.ofNullable(bodegaEntity.getActivo()).ifPresent(bodegaToBeChanged::setActivo);
            Optional.ofNullable(bodegaEntity.getDocumentopto()).ifPresent(bodegaToBeChanged::setDocumentopto);
            Optional.ofNullable(bodegaEntity.getCodigopto()).ifPresent(bodegaToBeChanged::setCodigopto);
            Optional.ofNullable(bodegaEntity.getPais()).ifPresent(bodegaToBeChanged::setPais);
            Optional.ofNullable(bodegaEntity.getDepartamento()).ifPresent(bodegaToBeChanged::setDepartamento);
            Optional.ofNullable(bodegaEntity.getProvincia()).ifPresent(bodegaToBeChanged::setProvincia);
            Optional.ofNullable(bodegaEntity.getDistrito()).ifPresent(bodegaToBeChanged::setDistrito);
            Optional.ofNullable(bodegaEntity.getUbigeo_pto()).ifPresent(bodegaToBeChanged::setUbigeo_pto);
            Optional.ofNullable(bodegaEntity.getProcesawms()).ifPresent(bodegaToBeChanged::setProcesawms);
            Optional.ofNullable(bodegaEntity.getFecha_procesawms()).ifPresent(bodegaToBeChanged::setFecha_procesawms);
            Optional.ofNullable(bodegaEntity.getMetro2()).ifPresent(bodegaToBeChanged::setMetro2);

            return bodegaRepository.save(bodegaToBeChanged);
        }).orElse(null);
    }

    public BodegaEntity remove(String codigo) {
        Optional<BodegaEntity> bodegaEntity = bodegaRepository.findById(codigo);
        bodegaEntity.ifPresent(bodegaRepository::delete);

        return bodegaEntity.orElse(null);
    }
}
