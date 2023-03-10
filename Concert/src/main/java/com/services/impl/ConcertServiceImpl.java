package com.services.impl;
import com.dtos.ConcertDto;
import com.entities.ConcertEntity;
import com.entities.SalleEntity;
import com.entities.SoireeEntity;
import com.repositories.ConcertRepository;
import com.repositories.SalleRepository;
import com.repositories.SoireeRepository;
import com.services.ConcertService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mapper.ConcertMapper;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service("concertService")
public class ConcertServiceImpl implements ConcertService {


    private final ConcertRepository concertRepository;
    private final ConcertMapper concertMapper;
    private final SalleRepository salleRepository;
    private final SoireeRepository soireeRepository;



    public ConcertServiceImpl(ConcertRepository TConcertRepository, ConcertMapper concertMapper, SalleRepository salleRepository, SoireeRepository soireeRepository){
        this.concertRepository = TConcertRepository;
        this.concertMapper  = concertMapper;
        this.salleRepository = salleRepository;
        this.soireeRepository = soireeRepository;
    }

    @Override
    public ConcertDto CreateConcert(ConcertDto concertDto) {
        // Converts the dto to the TConcert entity
       // ConcertEntity TConcert = ConcertDtoToEntity(concertDto);
        ConcertEntity TConcert = concertMapper.ConcertDtoToEntity(concertDto);
                // Save the TConcert entity
        TConcert = concertRepository.save(TConcert);
        // Return the new dto
        return concertMapper.ConcertEntityToDto(TConcert);
    }




    @Override
    public ConcertDto getConcertById(Long concertId) {
        ConcertEntity tConcertCon = concertRepository.findById(concertId).orElseThrow(() -> new EntityNotFoundException("Concert not found"));
        return concertMapper.ConcertEntityToDto(tConcertCon);
    }

    @Override
    public boolean deleteConcert(Long concertId) {
        concertRepository.deleteById(concertId);
        return true;
    }

    @Override
    public List<ConcertDto> getAllConcert() {
        List<ConcertDto> concertDtos = new ArrayList<>();
        List<ConcertEntity> concert = concertRepository.findAll();
        concert.forEach(concertt -> {
            concertDtos.add(concertMapper.ConcertEntityToDto(concertt));
        });
        return concertDtos;
    }

    @Override
    public ResponseEntity<ConcertDto> putConcertId(Long concertId, ConcertDto concertDto) {
        Optional<ConcertEntity> optionalConcert = concertRepository.findById(concertId);
        ConcertEntity concert = this.concertRepository.findById(concertId).orElseThrow(() -> new EntityNotFoundException("concert not found"));
        //SalleEntity salle  = this.salleRepository.findById(concertDto.getSalle().getSalleId()).orElseThrow(() -> new EntityNotFoundException("salle not found"));
       // SoireeEntity soiree =  this.soireeRepository.findById(concertDto.getSoiree().getSoiId()).orElseThrow(() -> new EntityNotFoundException("soiree not found"));
        if (optionalConcert.isPresent()) {
            concert.setConDateDebut(concertDto.getConDateDebut());
            concert.setConDateFin(concertDto.getConDateFin());

            // ajouter d'autres mises à jour pour les autres attributs du Concert
            ConcertEntity updatedConcert = concertRepository.save(concert);
            return ResponseEntity.ok(concertMapper.ConcertEntityToDto(updatedConcert));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
