package com.pmd.rentavehiculos.exception;

import java.util.function.IntFunction;

public class ReglaNegocioExcepcion extends RuntimeException {

    public final int responseCode;

    public static final IntFunction<ReglaNegocioExcepcion> vehiculoNoDisponible = id -> new ReglaNegocioExcepcion("El vehiculo con id '" + id + "' no esta disponible", 404);
    public static final IntFunction<ReglaNegocioExcepcion> vehiculoNoExiste = id -> new ReglaNegocioExcepcion("No existe el vehiculo con id '" + id + "'", 404);
    public static final ReglaNegocioExcepcion usuarioNoAutorizado = new ReglaNegocioExcepcion("Usuario no esta autorizado para esta acción", 403);
    public static final ReglaNegocioExcepcion errorAutenticacion = new ReglaNegocioExcepcion("Usuario o Contrasena Erroneo");
    public static final ReglaNegocioExcepcion llaveNoValida = new ReglaNegocioExcepcion("La llave no es valida", 401);
    public static final ReglaNegocioExcepcion personaNoExiste = new ReglaNegocioExcepcion("Persona no existe", 404);
    public static final ReglaNegocioExcepcion rentaInvalida = new ReglaNegocioExcepcion("Valor de renta invalida");

    public ReglaNegocioExcepcion(String message) {
        super(message);
        this.responseCode = 400;
    }

    public ReglaNegocioExcepcion(String message, int code) {
        super(message);
        this.responseCode = code;
    }

}
