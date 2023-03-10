package com.services;

import com.dtos.SalleDto;
import com.dtos.SoireeDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SoireeService {
    /**
     * Sauvegarde une soirée
     */
    SoireeDto saveSoiree(SoireeDto soireeDto);

    /**
     * Récupère une soirée en fonction de son ID
     */
    SoireeDto getSoireeById(Long soireeId);

    /**
     * Supprime une soirée en fonction de son ID
     */
    boolean deleteSoiree(Long soireeId);

    /**
     * Récupère toutes les soirées
     */
    List<SoireeDto> getAllSoirees();

    ResponseEntity<SoireeDto>  putSoireeId(Long soireeId, SoireeDto soireeDto);
}
