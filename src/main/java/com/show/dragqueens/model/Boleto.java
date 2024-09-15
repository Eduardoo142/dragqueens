package com.show.dragqueens.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double precio;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Event evento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}