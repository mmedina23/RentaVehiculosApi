package com.pmd.rentavehiculos.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

    public static String generarLlaveUsuario() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyyHHmmssSSS");
        String llave = fechaHoraActual.format(formato);

        return llave;
    }


}
