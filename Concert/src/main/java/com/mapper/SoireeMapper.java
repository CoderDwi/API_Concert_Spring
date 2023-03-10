package com.mapper;

import com.dtos.SoireeDto;
import com.entities.SoireeEntity;
import org.springframework.stereotype.Component;

@Component
public class SoireeMapper {
    /**
     * Map soiree dto to soiree entity
     */
    public SoireeDto soireeEntityToDto(SoireeEntity soiree){
        SoireeDto soireeDto = new SoireeDto();
        soireeDto.setSoiId(soiree.getSoiId());
        soireeDto.setNom(soiree.getNom());
        soireeDto.setLieu(soiree.getLieu());
        soireeDto.setDescription(soiree.getDescription());
        return soireeDto;
    }

    /**
     * Map soiree entity to soiree dto
     */
    public SoireeEntity soireeDtoToEntity(SoireeDto soireeDto){
        SoireeEntity soiree = new SoireeEntity();
        soiree.setNom(soireeDto.getNom());
        soiree.setSoiId(soireeDto.getSoiId());
        soiree.setLieu(soireeDto.getLieu());
        soiree.setDescription(soireeDto.getDescription());
        return soiree;
    }
}
