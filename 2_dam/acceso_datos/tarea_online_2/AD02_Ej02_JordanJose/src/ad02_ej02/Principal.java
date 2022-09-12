package ad02_ej02;

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

    private static void listarNumeroEmpleadosDepartamentoPresupuesto() throws SQLException {
        ArrayList<EmpleadoDepartamento> empleadosDepartamentos = new ArrayList();
        empleadosDepartamentos = baseDatos.obtenerNumeroEmpleadosDepartamentoPresupuesto();
        for (EmpleadoDepartamento ed : empleadosDepartamentos) {
            System.out.println(ed);
        }
    }

    private static void listarEmpleados() throws SQLException {
        ArrayList<Empleado> empleados = new ArrayList();
        empleados = baseDatos.obtenerEmpleado();
        for (Empleado e : empleados) {
            System.out.println(e);
        }
    }

    private static void listarEmpleadosDepartamento(String departamento) throws SQLException {
        ArrayList<EmpleadoDepartamento> empleadosDepartamentos = new ArrayList();
        empleadosDepartamentos = baseDatos.obtenerEmpleadoDepartamento(departamento);
        for (EmpleadoDepartamento e : empleadosDepartamentos) {
            System.out.println(e);
        }
    }
    
    //obtenerEmpleadoNumeroDepartamento
    private static void listarEmpleadosNumeroDepartamento(int numDepartamento) throws SQLException {
        ArrayList<Empleado> empleados = new ArrayList();
        empleados = baseDatos.obtenerEmpleadoNumeroDepartamento(numDepartamento);
        for (Empleado e : empleados) {
            System.out.println(e);
        }
    }
    
    

    private static void listarEmpleadosDepartamentoIncremento(int numDepartamento) throws SQLException {
        ArrayList<Empleado> empleados = new ArrayList();
        empleados = baseDatos.obtenerEmpleadoNumeroDepartamentoIncremento(numDepartamento);
        for (Empleado e : empleados) {
            System.out.println(e);
        }
    }

    public static void menu() throws SQLException {
        boolean salir = false;
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("*******************************************************************");
            System.out.println("*           Base de Datos                                         *");
            System.out.println("*******************************************************************");
            System.out.println("*       (1) Listar Empleados                                      *");
            System.out.println("*       (2) Listar Numero de Empleados Departamento Presupuesto   *");
            System.out.println("*       (3) Listar Empleados por Nombre de Departamento           *");
            System.out.println("*       (4) Listar Empleados por Numero de Departamento           *");
            System.out.println("*       (0) Salir del programa                                    *");
            System.out.println("*******************************************************************");
            try {
                System.out.print("Elige una opción: ");
                opcion = entrada.nextInt();
                String cadena = "";
                int numero = 0;
                switch (opcion) {

                    case 1:
                        listarEmpleados();
                        break;
                    case 2:
                        listarNumeroEmpleadosDepartamentoPresupuesto();
                        break;
                    case 3:
                        cadena = Utilidades.leerCadena("Introduce el Nombre del Departamento: ");
                        listarEmpleadosDepartamento(cadena);
                        break;
                    case 4:
                        numero = Utilidades.leerEntero("Introduce el Numero del Departamento: ");
                        listarEmpleadosNumeroDepartamento(numero);
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
