package com.pmd.rentavehiculos.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "VEHICULOS")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String marca;
    private String color;
    private String carroceria;
    private Integer plazas;
    private String cambios;
    private String tipoCombustible;
    private BigDecimal valorDia;
    private boolean disponible;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    public Integer getPlazas() {
        return plazas;
    }

    public void setPlazas(Integer plazas) {
        this.plazas = plazas;
    }

    public String getCambios() {
        return cambios;
    }

    public void setCambios(String cambios) {
        this.cambios = cambios;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public BigDecimal getValorDia() {
        return valorDia;
    }

    public void setValorDia(BigDecimal valorDia) {
        this.valorDia = valorDia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
