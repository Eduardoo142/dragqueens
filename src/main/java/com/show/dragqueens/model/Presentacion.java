package com.show.dragqueens.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Presentacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHora;
    private String lugar;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Event evento;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

}