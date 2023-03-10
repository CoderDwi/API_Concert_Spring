package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class SoireeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long soiId;

    private String nom;

    private String lieu;

    private String description;
    private Double prix;


    @OneToMany(mappedBy = "soiree")
    private List<ConcertEntity> concerts;

}
