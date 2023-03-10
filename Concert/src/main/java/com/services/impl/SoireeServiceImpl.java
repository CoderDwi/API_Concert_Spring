package com.services.impl;

import com.dtos.SalleDto;
import com.dtos.SoireeDto;
import com.entities.SalleEntity;
import com.entities.SoireeEntity;
import com.repositories.SoireeRepository;
import com.services.SoireeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mapper.SoireeMapper;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("soireeService")
public class SoireeServiceImpl implements SoireeService {

    private final SoireeRepository soireeRepository;
    private final  SoireeMapper soireeMapper;

    public SoireeServiceImpl(SoireeRepository soireeRepository, SoireeMapper soireeMapper) {
        this.soireeRepository = soireeRepository;
        this.soireeMapper = soireeMapper;
    }

    @Override
    public SoireeDto saveSoiree(SoireeDto soireeDto) {
        // Converts the dto to the soiree entity
        SoireeEntity soiree = soireeMapper.soireeDtoToEntity(soireeDto);
        // Save the soiree entity
        soiree = soireeRepository.save(soiree);
        // Return the new dto
        return soireeMapper.soireeEntityToDto(soiree);
    }

    @Override
    public SoireeDto getSoireeById(Long soireeId) {
        SoireeEntity soiree = soireeRepository.findById(soireeId).orElseThrow(() -> new EntityNotFoundException("Soiree not found"));
        return soireeMapper.soireeEntityToDto(soiree);
    }

    @Override
    public boolean deleteSoiree(Long soireeId) {
        soireeRepository.deleteById(soireeId);
        return true;
    }

    @Override
    public List<SoireeDto> getAllSoirees() {
        List<SoireeDto> soireeDtos = new ArrayList<>();
        List<SoireeEntity> soirees = soireeRepository.findAll();
        soirees.forEach(soiree -> {
            soireeDtos.add(soireeMapper.soireeEntityToDto(soiree));
        });
        return soireeDtos;
    }

    @Override
    public ResponseEntity<SoireeDto> putSoireeId(Long soireeId, SoireeDto soireeDto) {
        Optional<SoireeEntity> optionalSoiree = soireeRepository.findById(soireeId);
        if (optionalSoiree.isPresent()) {
            SoireeEntity soiree = optionalSoiree.get();
            //soiree.setSoiId(soireeDto.getSoiId());
            soiree.setPrix(soireeDto.getPrix());
            soiree.setNom(soireeDto.getNom());
            soiree.setLieu(soireeDto.getLieu());
            soiree.setDescription(soireeDto.getDescription());
            // ajouter d'autres mises à jour pour les autres attributs du Concert
            SoireeEntity updatedSoiree = soireeRepository.save(soiree);
            return ResponseEntity.ok(soireeMapper.soireeEntityToDto(updatedSoiree));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
