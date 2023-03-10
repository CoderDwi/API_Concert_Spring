package com.services;
import com.dtos.ConcertDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
public interface ConcertService {
    /**
     * Create concert
     */
    ConcertDto CreateConcert(ConcertDto tconcertDto);

    /**
     * Get a concert by it's id
     */
    ConcertDto getConcertById(Long concertId);

    /**
     * Delete a concert by it's id
     */
    boolean deleteConcert(Long concertId);

    /**
     * Get all the concert
     */
    List<ConcertDto> getAllConcert();

    /**
     * Put concert
     */
    public ResponseEntity<ConcertDto> putConcertId(@PathVariable Long concertId, @RequestBody ConcertDto concertDto);

}
