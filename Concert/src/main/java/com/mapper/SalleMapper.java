package com.mapper;

import com.dtos.SalleDto;
import com.entities.SalleEntity;
import org.springframework.stereotype.Component;

@Component
public class SalleMapper {
    public SalleDto salleEntityToDto(SalleEntity salle) {
        SalleDto salleDto = new SalleDto();
        salleDto.setSalleId(salle.getSalleId());
        salleDto.setNom(salle.getNom());
        salleDto.setAdresse(salle.getAdresse());
        salleDto.setCapacite(salle.getCapacite());
        return salleDto;
    }

    public SalleEntity salleDtoToEntity(SalleDto salleDto) {
        SalleEntity salle = new SalleEntity();
        salle.setSalleId(salleDto.getSalleId());
        salle.setNom(salleDto.getNom());
        salle.setAdresse(salleDto.getAdresse());
        salle.setCapacite(salleDto.getCapacite());
        return salle;
    }
}
