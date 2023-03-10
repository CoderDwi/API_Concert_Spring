package com.controllers;

import com.dtos.ConcertDto;
import com.entities.ConcertEntity;
import com.services.impl.ConcertServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/concerts")
public class ConcertController {
    private final ConcertServiceImpl concertService;

    public ConcertController(ConcertServiceImpl concertService) {
        this.concertService = concertService;
    }


    /**
     * <p>Get all concerts in the system</p>
     * @return List<TConcertDto>
     */
    @GetMapping
    @CrossOrigin
    public List<ConcertDto> getTConcerts() {
        return concertService.getAllConcert();
    }

    /**
     * Method to get the concert based on the ID
     */
    @GetMapping("/{id}")
    @CrossOrigin
    public ConcertDto getConcert(@PathVariable Long id){
        return concertService.getConcertById(id);
    }


    /**
     * Create a new Dog in the system
     */
    @PostMapping
    @CrossOrigin
    public ConcertDto createConcert(final @RequestBody ConcertDto concertDto){
        return concertService.CreateConcert(concertDto);
    }


    /**
     * Delete a concert by it's id
     */
    @DeleteMapping("/{id}")
    @CrossOrigin
    public Boolean deleteConcert(@PathVariable Long id){
        return concertService.deleteConcert(id);
    }

    /**
     * PUT a concert by it's id
     */

    @PutMapping("concerts/{concertId}")
    public ResponseEntity<ConcertDto> updateConcert(@PathVariable Long concertId, @RequestBody ConcertDto concertDto) {
        return concertService.putConcertId(concertId,concertDto);
    }


}
