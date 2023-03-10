package com.services;

import java.util.List;

import com.dtos.SalleDto;
import org.springframework.http.ResponseEntity;

public interface SalleService {

    SalleDto saveSalle(SalleDto salleDto);

    SalleDto getSalleById(Long salleId);

    boolean deleteSalle(Long salleId);

    List<SalleDto> getAllSalles();

    ResponseEntity<SalleDto> putSalleId(Long salleId, SalleDto salleDto);
}
