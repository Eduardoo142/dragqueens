package com.show.dragqueens.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Table(name = "dwarf_portfolios")

@Entity
@Getter @Setter
public class DwarfPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String biography;
    private String photoLinks;
    private String videoLinks;
}
