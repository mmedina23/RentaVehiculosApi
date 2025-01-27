package com.pmd.rentavehiculos.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String usuario;
    private String contrasena;
    private String perfil;
    private String llave;
    private LocalDateTime fechaExpLlave;

    public Usuario() {
    }

    public Usuario(LocalDateTime fechaExpLlave, String llave, String perfil, String contrasena, String usuario, Integer id) {
        this.fechaExpLlave = fechaExpLlave;
        this.llave = llave;
        this.perfil = perfil;
        this.contrasena = contrasena;
        this.usuario = usuario;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public LocalDateTime getFechaExpLlave() {
        return fechaExpLlave;
    }

    public void setFechaExpLlave(LocalDateTime fechaExpLlave) {
        this.fechaExpLlave = fechaExpLlave;
    }
}
