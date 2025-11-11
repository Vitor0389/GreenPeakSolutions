package com.GreenPeak.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "residuos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Residuo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String tipo;

    private Double peso;

    private String destinoFinal;
}

