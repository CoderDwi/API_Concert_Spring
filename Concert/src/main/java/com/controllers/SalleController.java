package com.controllers;

import com.dtos.ConcertDto;
import com.dtos.SalleDto;
import com.services.impl.SalleServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salles")
public class SalleController {

    private final SalleServiceImpl salleService;

    public SalleController(SalleServiceImpl salleService) {
        this.salleService = salleService;
    }

    /**
     * <p>Get all salles in the system</p>
     * @return List<SalleDto>
     */
    @GetMapping
    public List<SalleDto> getSalles() {
        return salleService.getAllSalles();
    }

    /**
     * Method to get the salle based on the ID
     */
    @GetMapping("/{id}")
    public SalleDto getSalle(@PathVariable Long id){
        return salleService.getSalleById(id);
    }

    /**
     * Create a new Salle in the system
     */
    @PostMapping
    public SalleDto saveSalle(final @RequestBody SalleDto salleDto){
        return salleService.saveSalle(salleDto);
    }

    /**
     * Delete a salle by its id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteSalle(@PathVariable Long id){
        return salleService.deleteSalle(id);
    }


    /**
     * Put a salle by its id
     */
    @PutMapping("salles/{salleId}")
    public ResponseEntity<SalleDto> updateSalle(@PathVariable Long salleId, @RequestBody SalleDto salleDto) {
        return salleService.putSalleId(salleId,salleDto);
    }

}
