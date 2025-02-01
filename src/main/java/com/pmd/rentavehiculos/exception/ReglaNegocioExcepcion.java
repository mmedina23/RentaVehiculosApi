package com.pmd.rentavehiculos.exception;

import java.util.function.Function;

public class ReglaNegocioExcepcion extends RuntimeException {

    public final static Function<Integer, ReglaNegocioExcepcion> vehiculoNoDisponible = (id) -> new ReglaNegocioExcepcion("El vehiculo con id '" + id + "' no esta disponible");
    public final static Function<Integer, ReglaNegocioExcepcion> vehiculoNoExiste = (id) -> new ReglaNegocioExcepcion("No existe el vehiculo con id '"+id+"'");
    public final static ReglaNegocioExcepcion usuarioNoAutorizado = new ReglaNegocioExcepcion("Usuario no esta autorizado para esta acción");
    public final static ReglaNegocioExcepcion errorAutenticacion = new ReglaNegocioExcepcion("Usuario o Contrasena Erroneo");
    public final static ReglaNegocioExcepcion llaveNoValida = new ReglaNegocioExcepcion("La llave no es valida");
    public final static ReglaNegocioExcepcion personaNoExiste = new ReglaNegocioExcepcion("Persona no existe");

    public ReglaNegocioExcepcion(String message) {
        super(message);
    }
}
