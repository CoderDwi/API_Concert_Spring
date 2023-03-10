package com.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.entities.ConcertEntity;
import com.mapper.SalleMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dtos.SalleDto;
import com.entities.SalleEntity;
import com.repositories.SalleRepository;
import com.services.SalleService;

@Service
public class SalleServiceImpl implements SalleService {

    private final SalleRepository salleRepository;
    private final SalleMapper salleMapper;

    public SalleServiceImpl(SalleRepository salleRepository, SalleMapper salleMapper) {
        this.salleRepository = salleRepository;
        this.salleMapper = salleMapper;
    }

    @Override
    public SalleDto saveSalle(SalleDto salleDto) {
        SalleEntity salle = salleMapper.salleDtoToEntity(salleDto);
        salle = salleRepository.save(salle);
        return salleMapper.salleEntityToDto(salle);
    }

    @Override
    public SalleDto getSalleById(Long salleId) {
        SalleEntity salle = salleRepository.findById(salleId)
                .orElseThrow(() -> new EntityNotFoundException("Salle not found"));
        return salleMapper.salleEntityToDto(salle);
    }

    @Override
    public boolean deleteSalle(Long salleId) {
        salleRepository.deleteById(salleId);
        return true;
    }

    @Override
    public List<SalleDto> getAllSalles() {
        List<SalleDto> salleDtos = new ArrayList<>();
        List<SalleEntity> salles = salleRepository.findAll();
        salles.forEach(salle -> {
            salleDtos.add(salleMapper.salleEntityToDto(salle));
        });
        return salleDtos;
    }



    /*
    *    @Override
    public ResponseEntity<ConcertDto> putConcertId(Long concertId, ConcertDto concertDto) {
        Optional<ConcertEntity> optionalConcert = TConcertRepository.findById(concertId);
        if (optionalConcert.isPresent()) {
            ConcertEntity concert = optionalConcert.get();
            concert.setConDateDebut(concertDto.getConDateDebut());
            concert.setConDateFin(concertDto.getConDateFin());

            // ajouter d'autres mises à jour pour les autres attributs du Concert
            ConcertEntity updatedConcert = TConcertRepository.save(concert);
            return ResponseEntity.ok(concertMapper.ConcertEntityToDto(updatedConcert));
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
    @Override
    public ResponseEntity<SalleDto> putSalleId(Long salleId, SalleDto salleDto) {
        Optional<SalleEntity> optionalSalle = salleRepository.findById(salleId);
        if (optionalSalle.isPresent()) {
            SalleEntity salle = optionalSalle.get();
            salle.setNom(salleDto.getNom());
            salle.setAdresse(salleDto.getAdresse());
            salle.setCapacite(salleDto.getCapacite());
            // ajouter d'autres mises à jour pour les autres attributs du Concert
            SalleEntity updatedSalle = salleRepository.save(salle);
            return ResponseEntity.ok(salleMapper.salleEntityToDto(updatedSalle));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
