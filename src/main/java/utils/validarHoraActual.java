package utils;

import java.time.LocalTime;

public class validarHoraActual {

    public boolean validarHoraActual(String horaInicio, String horaFin) {
        LocalTime ahora = LocalTime.now();
        LocalTime inicio = LocalTime.parse(horaInicio);
        LocalTime fin = LocalTime.parse(horaFin);
        return !ahora.isBefore(inicio) && !ahora.isAfter(fin);
    }

    public static void main(String[] args) {
        // valida el metodo hora actual
        validarHoraActual validador = new validarHoraActual();
    }

}
