package com.pmd.rentavehiculos.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    public Renta() {
    }

    public Renta(Integer id, Persona persona, Vehiculo vehiculo, Integer diasRenta, BigDecimal valorTotalRenta, LocalDateTime fechaRenta, LocalDateTime fechaEstimadaEntrega, LocalDateTime fechaEntregado) {
        this.id = id;
        this.persona = persona;
        this.vehiculo = vehiculo;
        this.diasRenta = diasRenta;
        this.valorTotalRenta = valorTotalRenta;
        this.fechaRenta = fechaRenta;
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
        this.fechaEntregado = fechaEntregado;
    }


}
