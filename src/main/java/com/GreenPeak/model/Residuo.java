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

    private String tipoResiduo;

    private Double quantidade;

    private java.util.Date dataColeta;


}
