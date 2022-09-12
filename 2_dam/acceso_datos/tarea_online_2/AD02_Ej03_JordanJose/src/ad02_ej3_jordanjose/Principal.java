package ad02_ej3_jordanjose;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    private static Conexion baseDatos = new Conexion();

    public static void main(String[] args) throws SQLException {
        baseDatos.conectar();
        menu();
    }
    

    private static void listarEmpleados() throws SQLException {
        ArrayList<Empleado> empleados = new ArrayList();
        empleados = baseDatos.obtenerEmpleado();
        for (Empleado e : empleados) {
            System.out.println(e);
        }
    }

    public static void incrementarSalarios() throws SQLException {
        int cadena = Utilidades.leerEntero("Introduce el Departamento: ");
        baseDatos.actualizarSalarioEmpleado(cadena);
    }

    //aumentarSalarioDepartamentoIncremento
    public static void aumentarSalarioDepartamentoIncremento(int departamento, int incremento) throws SQLException {
        baseDatos.aumentarSalarioDepartamentoIncremento(departamento, incremento);
        System.out.println("Se ha aumentado un "+incremento+"%"+" el salario del departamento "+ departamento);
    }

    public static void empleadosIntervaloComision(int comision1, int comision2) {
        int numero = baseDatos.empleadosIntervaloComision(comision1, comision2);
        System.out.println("Numero de Empleados: "+numero);
    }

    public static void totalEmpleadosIntervaloSalario(int salario1, int salario2) {
        int numero = baseDatos.totalEmpleadosIntervaloSalario(salario1, salario2);
        System.out.println("Numero de Empleados: " + numero);
    }

    public static void menu() throws SQLException {
        boolean salir = false;
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("*******************************************************************");
            System.out.println("*           Base de Datos                                         *");
            System.out.println("*******************************************************************");
            System.out.println("*       (1) Aumento Salario Departamento                          *");
            System.out.println("*       (2) Listar Empleados                                      *");
            System.out.println("*       (3) Empleados Intervalo Comision                          *");
            System.out.println("*       (4) Empleados Intervalo Salario                           *");
            System.out.println("*       (0) Salir del programa                                    *");
            System.out.println("*******************************************************************");
            try {
                System.out.print("Elige una opción: ");
                opcion = entrada.nextInt();
                switch (opcion) {
                    case 1:
                        //PA 3
                        int departamento = Utilidades.leerEntero("Introduce el Numero de Departamento: ");
                        int incremento = Utilidades.leerEntero("Introduce el Incremento: ");
                        aumentarSalarioDepartamentoIncremento(departamento, incremento);
                        break;
                    case 2:
                        listarEmpleados();
                        break;
                    case 3:
                        //PA 1
                        int intervalo1 = Utilidades.leerEntero("Introduce 1 Intervalo: ");
                        int intervalo2 = Utilidades.leerEntero("Introduce 2 Intervalo: ");
                        empleadosIntervaloComision(intervalo1, intervalo2);
                        break;
                    case 4:
                        //PA 2
                        int salario1 = Utilidades.leerEntero("Introduce 1 Intervalo: ");
                        int salario2 = Utilidades.leerEntero("Introduce 2 Intervalo: ");
                        totalEmpleadosIntervaloSalario(salario1, salario2);
                        break;
                    case 0:
                        salir = true;
                        System.out.println("Saliendo de la aplicación....");
                        baseDatos.desconectar();
                        break;
                    default:
                        System.out.println("Introduce una opción correcta");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes de introducir un numero");
                entrada.next();
            }
        } while (!salir);
    }

}
