package com.entities;

import java.util.List;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class SalleEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salleId;

    private String nom;

    private String adresse;

    private String capacite;


    @OneToMany(mappedBy = "salle")
    private List<ConcertEntity> concerts;


}
