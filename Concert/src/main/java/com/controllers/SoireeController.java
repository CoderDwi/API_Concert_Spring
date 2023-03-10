package com.controllers;

import com.dtos.SalleDto;
import com.dtos.SoireeDto;
import com.services.SoireeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soirees")
public class SoireeController {

    private final SoireeService soireeService;

    public SoireeController(SoireeService soireeService) {
        this.soireeService = soireeService;
    }

    /**
     * Récupère toutes les soirées dans le système
     */
    @GetMapping
    public List<SoireeDto> getSoirees() {
        return soireeService.getAllSoirees();
    }

    /**
     * Récupère une soirée en fonction de son ID
     */
    @GetMapping("/{id}")
    public SoireeDto getSoiree(@PathVariable Long id) {
        return soireeService.getSoireeById(id);
    }

    /**
     * Crée une nouvelle soirée dans le système
     */
    @PostMapping
    public SoireeDto saveSoiree(@RequestBody SoireeDto soireeDto) {
        return soireeService.saveSoiree(soireeDto);
    }

    /**
     * Supprime une soirée en fonction de son ID
     */
    @DeleteMapping("/{id}")
    public boolean deleteSoiree(@PathVariable Long id) {
        return soireeService.deleteSoiree(id);
    }

    /**
     * Put a soiree by its id
     */
    @PutMapping("soiree/{soireeId}")
    public ResponseEntity<SoireeDto> updateSalle(@PathVariable Long soireeId, @RequestBody SoireeDto soireeDto) {
        return soireeService.putSoireeId(soireeId,soireeDto);
    }
}
