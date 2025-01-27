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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Integer getDiasRenta() {
        return diasRenta;
    }

    public void setDiasRenta(Integer diasRenta) {
        this.diasRenta = diasRenta;
    }

    public BigDecimal getValorTotalRenta() {
        return valorTotalRenta;
    }

    public void setValorTotalRenta(BigDecimal valorTotalRenta) {
        this.valorTotalRenta = valorTotalRenta;
    }

    public LocalDateTime getFechaRenta() {
        return fechaRenta;
    }

    public void setFechaRenta(LocalDateTime fechaRenta) {
        this.fechaRenta = fechaRenta;
    }

    public LocalDateTime getFechaEstimadaEntrega() {
        return fechaEstimadaEntrega;
    }

    public void setFechaEstimadaEntrega(LocalDateTime fechaEstimadaEntrega) {
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }

    public LocalDateTime getFechaEntregado() {
        return fechaEntregado;
    }

    public void setFechaEntregado(LocalDateTime fechaEntregado) {
        this.fechaEntregado = fechaEntregado;
    }
}
