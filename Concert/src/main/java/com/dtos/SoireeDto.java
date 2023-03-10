package com.dtos;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SoireeDto {
    private Long soiId;

    private String nom;

    private String lieu;

    private String description;
    private Double prix;
}
