package com.pmd.rentavehiculos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "PERSONAS")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String tipoIdentificacion;
    private String identificacion;

    public Persona() {
    }

    public Persona(Integer id, String nombre, String apellidos, String direccion, String telefono, String tipoIdentificacion, String identificacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacion = identificacion;
    }
}
