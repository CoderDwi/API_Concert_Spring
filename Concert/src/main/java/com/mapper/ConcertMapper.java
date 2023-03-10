package com.mapper;

import com.dtos.ConcertDto;
import com.entities.ConcertEntity;
import com.entities.SalleEntity;
import com.entities.SoireeEntity;
import org.springframework.stereotype.Component;

@Component
public class ConcertMapper {

    /**
     * Map ConcertDto  to ConcertEntity
     */

    public ConcertDto ConcertEntityToDto(ConcertEntity concert){
        ConcertDto tconcertDto = new ConcertDto();
        tconcertDto.setConId(concert.getConId());
        tconcertDto.setConDateDebut(concert.getConDateDebut());
        tconcertDto.setConDateFin(concert.getConDateFin());
       // tconcertDto.setSalle(new SalleEntity());
       // tconcertDto.setSoiree(new SoireeEntity());
        return tconcertDto;
    }

    /**
     * Map ConcertEntity  to ConcertDto
     */

    public ConcertEntity ConcertDtoToEntity(ConcertDto tConcertDto){
        ConcertEntity concert = new ConcertEntity();
        concert.setConId(tConcertDto.getConId());
        concert.setConDateDebut(tConcertDto.getConDateDebut());
        concert.setConDateFin(tConcertDto.getConDateFin());
       // concert.setSalle(new SalleEntity());
       // concert.setSoiree(new SoireeEntity());


        return concert;
    }
}
