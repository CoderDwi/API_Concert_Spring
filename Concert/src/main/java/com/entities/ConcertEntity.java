package com.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class ConcertEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime conDateDebut;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime  conDateFin;


    @ManyToOne
    private SalleEntity salle;

    @ManyToOne
    private SoireeEntity soiree;

}
