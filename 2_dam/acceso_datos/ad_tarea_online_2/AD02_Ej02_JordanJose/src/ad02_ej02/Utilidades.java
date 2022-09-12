package ad02_ej02;


/*
 Class Utilidades
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaime M. Botonero Morillo
 */
public class Utilidades {

    /**
     * Creado por: jbotonero Fecha: 11-mar-2005
     *
     * @param string
     * @return
     */
    public static double leerDoble(String cadena) {
        // Lee un número double mostrando una cadena que se pasa como parámetro

        //	Creamos el objeto de entrada de datos de tipo BufferedReader
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        double numero = 0;
        boolean continuar = false;
        do {
            System.out.print(cadena);
            try {
            	numero = Double.parseDouble(entrada.readLine());
            	continuar = false;
            }
            catch (NumberFormatException ex) {
                System.out.println("No has introducido un número double correcto.");
                continuar = true;
                esperar(2);
            }
            catch (IOException ex) {
                System.out.println("Se ha producido un error de entrada/salida genérico.");
                continuar = true;
                esperar(2);
            }
        } while (continuar);
        return numero;
    }

    /**
     * Creado por: jbotonero Fecha: 11-mar-2005
     *
     * @param string
     * @return
     */
    public static float leerFloat(String cadena) {
        // Lee un número float mostrando una cadena que se pasa como parámetro

        //	Creamos el objeto de entrada de datos de tipo BufferedReader
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        Float numero = 0.0F;
        boolean continuar = false;
        do {
            System.out.print(cadena);
            try {
                numero = Float.parseFloat(entrada.readLine());
                continuar = false;
            }
            catch (NumberFormatException ex) {
                System.out.println("No has introducido un número float correcto.");
                continuar = true;
                esperar(2);
            }
            catch (IOException ex) {
                System.out.println("Se ha producido un error de entrada/salida genérico.");
                continuar = true;
                esperar(2);
            }
        } while (continuar);
        return numero;
    }

    /**
     * Creado por: jbotonero Fecha: 11-mar-2005
     *
     * @param string
     * @return
     */
    public static int leerEntero(String cadena) {
        // Lee un número entero mostrando una cadena que se pasa como parámetro

        //	Creamos el objeto de entrada de datos de tipo BufferedReader
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        int numero = 0;
        boolean continuar = false;
        do {
            System.out.print(cadena);
            try {
                numero = Integer.parseInt(entrada.readLine());
                continuar = false;
            }
            catch (NumberFormatException ex) {
                System.out.println("No has introducido un número entero correcto.");
                continuar = true;
                esperar(2);
            }
            catch (IOException ex) {
                System.out.println("Se ha producido un error de entrada/salida genérico.");
                continuar = true;
                esperar(2);
            }
        } while (continuar);
        return numero;
    }

    /**
     * Creado por: jbotonero Fecha: 11-mar-2005
     *
     * @param string
     * @return
     */
    public static String leerCadena(String cadena) {
        // Lee una cadena mostrando una cadena que se pasa como parámetro

        //	Creamos el objeto de entrada de datos de tipo BufferedReader
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        String cadenaRetorno = "";
        boolean continuar = false;
        do {
            System.out.print(cadena);
            try {
            	cadenaRetorno = entrada.readLine();
            	continuar = false;
            }
            catch (IOException ex) {
                System.out.println("Se ha producido un error de entrada/salida genérico.");
                continuar = true;
                esperar(2);
            }
        } while (continuar);
        return cadenaRetorno;
    }

    /**
     * Creado por: jbotonero Fecha: 11-mar-2005
     *
     * @param
     * @return
     */
    public static void borrarPantalla() {
        //Imprimimos 30 líneas en blanco para "borrar" la pantalla.
        for (int i = 0; i < 29; i++) {
            System.out.println();
        }
    }

    /**
     * Creado por: jbotonero Fecha: 11-mar-2005
     *
     * @param int
     * @return
     */
    public static void esperar(int n) {

        //Espera un número de segundos antes de continuar
        long tiempo0, tiempo1;

        tiempo0 = System.currentTimeMillis();

        do {
            tiempo1 = System.currentTimeMillis();
        } while ((tiempo1 - tiempo0) < (n * 1000));
    }

    public static int MCD(int a, int b) {
        int r;
        if (a < b) {
            r = a;
            a = b;
            b = r;
        }
        if (b == 0) {
            return a;
        }
        return MCD(b, a % b);
    }
    
    /**
     * Permite convertir un String en fecha (Date).
     * @param fecha Cadena de fecha yyyy/MM/DD
     * @return Objeto Date
     */
    public static Date parseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
    
    public static LocalDate leerFecha(String Cadena) {
        // Lee una cadena mostrando una cadena que se pasa como parámetro

        //	Creamos el objeto de entrada de datos de tipo BufferedReader
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        String cadenaRetorno = "";
        
        boolean continuar = false;
        LocalDate fecha=null;
        do {
            System.out.print(Cadena);
            try {
            	cadenaRetorno = entrada.readLine();
            	DateTimeFormatter formatAmerican = DateTimeFormatter.ofPattern("yyyy/LL/dd");

        		 fecha = LocalDate.parse(cadenaRetorno, formatAmerican);
        		 continuar = false;
            }
            catch (IOException ex) {
                System.out.println("Se ha producido un error de entrada/salida genérico.");
                continuar = true;
                esperar(2);
            }
            catch (DateTimeParseException ex) {
                System.out.println("Se ha producido un error de formato en la fecha, el formato debe ser AAAA/MM/DD.");
                continuar = true;
                esperar(2);
            }
        } while (continuar);
        return fecha;
    }
    
    
}
