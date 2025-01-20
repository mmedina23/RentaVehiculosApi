package com.pmd.rentavehiculos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Entity
@Table(name = "VEHICULOS")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String marca;
    private String color;
    private String carroceria;
    private Integer plazas;
    private String cambios;
    private String tipoCombustible;
    private BigDecimal valorDia;
    public boolean disponible;

    public Vehiculo() {
    }

    public Vehiculo(Integer id, String marca, String color, String carroceria, Integer plazas, String cambios, String tipoCombustible, BigDecimal valorDia, boolean disponible) {
        this.id = id;
        this.marca = marca;
        this.color = color;
        this.carroceria = carroceria;
        this.plazas = plazas;
        this.cambios = cambios;
        this.tipoCombustible = tipoCombustible;
        this.valorDia = valorDia;
        this.disponible = disponible;
    }
}
