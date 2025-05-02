package com.farid.xadis.services;

import com.farid.xadis.domain.dto.BodegaDTO;
import com.farid.xadis.domain.dto.BodegaDTOPartialUpdate;
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

    public BodegaDTO save(Long id, BodegaDTO bodegaDTO) {
        bodegaDTO.setId(id);
        BodegaEntity bodegaEntity = modelMapper.map(bodegaDTO, BodegaEntity.class);
        BodegaEntity savedBodegaEntity = bodegaRepository.save(bodegaEntity);

        return modelMapper.map(savedBodegaEntity, BodegaDTO.class);
    }

    public int saveAll(List<BodegaDTO> bodegasDTO) {
        List<BodegaEntity> bodegaEntities = bodegasDTO.stream()
            .map(bodegaDTO -> modelMapper.map(bodegaDTO, BodegaEntity.class))
            .toList();
        List<BodegaEntity> savedBodegas = bodegaRepository.saveAll(bodegaEntities);

        return savedBodegas.size();
    }

    public List<BodegaDTO> findAll() {
        return bodegaRepository.findAll().stream()
            .map(bodegaEntity -> modelMapper.map(bodegaEntity, BodegaDTO.class))
            .toList();
    }

    public Optional<BodegaDTO> findById(Long id) {
        return bodegaRepository.findById(id)
            .map(bodegaEntity -> modelMapper.map(bodegaEntity, BodegaDTO.class));
    }

    public BodegaDTOPartialUpdate partialUpdate(Long id, BodegaDTOPartialUpdate bodegaDTO) {
        bodegaDTO.setId(id);

        return bodegaRepository.findById(id).map(bodegaEntity -> {
            Optional.ofNullable(bodegaDTO.getCodigo()).ifPresent(bodegaEntity::setCodigo);
            Optional.ofNullable(bodegaDTO.getNombre()).ifPresent(bodegaEntity::setNombre);
            Optional.ofNullable(bodegaDTO.getActivo()).ifPresent(bodegaEntity::setActivo);
            Optional.ofNullable(bodegaDTO.getDocumentopto()).ifPresent(bodegaEntity::setDocumentopto);
            Optional.ofNullable(bodegaDTO.getCodigopto()).ifPresent(bodegaEntity::setCodigopto);
            Optional.ofNullable(bodegaDTO.getPais()).ifPresent(bodegaEntity::setPais);
            Optional.ofNullable(bodegaDTO.getDepartamento()).ifPresent(bodegaEntity::setDepartamento);
            Optional.ofNullable(bodegaDTO.getProvincia()).ifPresent(bodegaEntity::setProvincia);
            Optional.ofNullable(bodegaDTO.getDistrito()).ifPresent(bodegaEntity::setDistrito);
            Optional.ofNullable(bodegaDTO.getUbigeo_pto()).ifPresent(bodegaEntity::setUbigeo_pto);
            Optional.ofNullable(bodegaDTO.getProcesawms()).ifPresent(bodegaEntity::setProcesawms);
            Optional.ofNullable(bodegaDTO.getFecha_procesawms()).ifPresent(bodegaEntity::setFecha_procesawms);
            Optional.ofNullable(bodegaDTO.getMetro2()).ifPresent(bodegaEntity::setMetro2);

            BodegaEntity bodegaUpdated = bodegaRepository.save(bodegaEntity);

            return modelMapper.map(bodegaUpdated, BodegaDTOPartialUpdate.class);
        }).orElse(null);
    }

    public BodegaDTO remove(Long id) {
        return bodegaRepository.findById(id)
            .map(bodegaEntity -> {
                bodegaRepository.delete(bodegaEntity);
                return modelMapper.map(bodegaEntity, BodegaDTO.class);
            })
            .orElse(null);
    }
}
