package projectx.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Utilidades {

    public static boolean esNumerico(String valor) {
        try {
            if (valor != null) {
                Integer.parseInt(valor);
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
        return false;
    }

    public static LocalDate leerFecha(String cadena) {

        LocalDate fecha = null;
        boolean continuar = false;
        do {
            try {
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                fecha = LocalDate.parse(cadena, formato);
            } catch (DateTimeParseException ex) {
                fecha = null;
                return fecha;
            }
        } while (continuar || fecha == null);
        return fecha;
    }

}
