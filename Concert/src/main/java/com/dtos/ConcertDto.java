package com.dtos;
import com.entities.SalleEntity;
import com.entities.SoireeEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.sql.Date;
import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
public class ConcertDto {

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

