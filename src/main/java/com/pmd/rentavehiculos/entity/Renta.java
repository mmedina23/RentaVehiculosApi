package com.pmd.rentavehiculos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RENTAS")
public class Renta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Persona persona;
    @ManyToOne
    private Vehiculo vehiculo;
    private Integer diasRenta;
    private BigDecimal valorTotalRenta;
    private LocalDateTime fechaRenta;
    private LocalDateTime fechaEstimadaEntrega;
    private LocalDateTime fechaEntregado;
}
