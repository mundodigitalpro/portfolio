package ad02_ej02;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Conexion {

    private String bd = "consultorait";
    private String login = "root";
    private String password = "";
    private String url = "jdbc:mysql://127.0.0.1:3306/consultorait";
    private Connection connection = null;
    private Statement sentencia = null;
    private static DateTimeFormatter formatAmerican = DateTimeFormatter.ofPattern("yyyy/LL/dd");

    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
            System.out.println("Conexion con Base de Datos correcta");
        } catch (Exception e) {
            System.out.println("Error al conectar con Base de Datos");
        }
    }

    public void desconectar() {
        connection = null;
        System.out.println("La conexion a la  base de datos " + bd + " ha terminado");
    }

    /*
    * Consulta 3: Incremento salarial en un porcentaje del 10% de todos los empleados de un determinado departamento 
    * que se pasará como parámetro.
    *
    */
    public ArrayList obtenerEmpleadoNumeroDepartamentoIncremento(int numeroDepartamento) throws SQLException {
        if (connection != null) {
            System.out.println("Conectado con la Base de Datos");
        }
        ArrayList<Empleado> empleados = new ArrayList();
        try {
            Statement orden = connection.createStatement();
            ResultSet res = orden.executeQuery("SELECT emp_no, apellido, oficio, dir, fecha_alt, salario*1.1 AS salario, dept_no FROM empleados WHERE dept_no =" + numeroDepartamento);
            while (res.next()) {
                Empleado e = new Empleado();
                e.setEmp_no(res.getInt("emp_no"));
                e.setDept_no(res.getInt("dept_no"));
                e.setApellido(res.getString("apellido"));
                e.setOficio(res.getString("oficio"));
                e.setDir(res.getInt("dir"));
                e.setFecha(res.getDate("fecha_alt").toLocalDate());
                e.setSalario(res.getDouble("salario"));
                empleados.add(e);
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return empleados;
    }


    // Incrementar Salarios 10% de un departamento dado por parametro
    // UPDATE empleados SET salario = salario *1.1 WHERE dept_no = 20;
    public boolean actualizarSalarioEmpleado(int numero) {
        boolean flag = false;
        //double salario = e.getSalario();
        try {
            // Creamos el objeto Statement para enviar la orden de actualizacion 
            Statement orden = connection.createStatement();
            int i = orden.executeUpdate("UPDATE empleados SET salario = salario *1.1 WHERE dept_no =" + numero);
            System.out.println("Se han modificado " + i + " filas");
            orden.close();
            flag = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return flag;
    }
    
    
    /*
    b.	Consulta 2: Para cada departamento, obtener el número de empleados que pertenecen a dicho departamento y el presupuesto (cantidad de dinero) destinado a ese departamento.
    */
    
    public ArrayList obtenerNumeroEmpleadosDepartamentoPresupuesto() throws SQLException {
        if (connection != null) {
            System.out.println("Conectado con la Base de Datos");
        }
        ArrayList<EmpleadoDepartamento> empleadosDepartamentos = new ArrayList();
        try {
            Statement orden = connection.createStatement();
            ResultSet res = orden.executeQuery("SELECT d.dept_no, d.dnombre AS 'departamento' , COUNT(e.emp_no) AS 'numeroEmpleados', SUM(salario) AS 'presupuesto'\n"
                    + "FROM empleados e , departamentos d\n"
                    + "WHERE e.dept_no = d.dept_no\n"
                    + "GROUP BY dnombre;");

            while (res.next()) {
                EmpleadoDepartamento ed = new EmpleadoDepartamento();
                ed.setNombreDepartamento(res.getString("departamento"));
                ed.setNumeroDepartamento(res.getInt("dept_no"));
                ed.setNumeroEmpleados(res.getInt("numeroEmpleados"));
                ed.setPresupuestoDepartamento(res.getInt("presupuesto"));
                empleadosDepartamentos.add(ed);
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return empleadosDepartamentos;
    }

    //Obtener Empleados que pertenecen a un departamento, indicado por su numero
    public ArrayList obtenerEmpleadoNumeroDepartamento(int numeroDepartamento) throws SQLException {
        if (connection != null) {
            System.out.println("Conectado con la Base de Datos");
        }
        ArrayList<Empleado> empleados = new ArrayList();
        try {
            Statement orden = connection.createStatement();
            ResultSet res = orden.executeQuery("SELECT * FROM empleados WHERE dept_no =" + numeroDepartamento);
            while (res.next()) {
                Empleado e = new Empleado();
                e.setEmp_no(res.getInt("emp_no"));
                e.setApellido(res.getString("apellido"));
                e.setOficio(res.getString("oficio"));
                e.setDir(res.getInt("dir"));
                e.setFecha(res.getDate("fecha_alt").toLocalDate());
                e.setSalario(res.getDouble("salario"));
                e.setComision(res.getDouble("comision"));
                e.setDept_no(res.getInt("dept_no"));
                empleados.add(e);
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return empleados;
    }
    /*
    a.	Consulta 1: Empleados que pertenecen a un departamento, indicado por su nombre.
    */
    
    public ArrayList obtenerEmpleadoDepartamento(String departamento) throws SQLException {
        if (connection != null) {
            System.out.println("Conectado con la Base de Datos");
        }
        ArrayList<EmpleadoDepartamento> empleadosDepartamentos = new ArrayList();
        try {
            Statement orden = connection.createStatement();

            ResultSet res = orden.executeQuery("SELECT * FROM empleados e, departamentos d WHERE e.dept_no = d.dept_no AND d.dnombre=" + "'" + departamento + "'");
            while (res.next()) {
                EmpleadoDepartamento ed = new EmpleadoDepartamento();
                ed.setNombreEmpleado(res.getString("apellido"));
                ed.setNombreDepartamento(res.getString("dnombre"));
                empleadosDepartamentos.add(ed);
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return empleadosDepartamentos;
    }

    public ArrayList obtenerEmpleado() throws SQLException {
        if (connection != null) {
            System.out.println("Conectado con la Base de Datos");
        }
        ArrayList<Empleado> empleados = new ArrayList();
        try {
            Statement orden = connection.createStatement();
            ResultSet res = orden.executeQuery("SELECT * FROM empleados");
            while (res.next()) {
                Empleado e = new Empleado();
                e.setEmp_no(res.getInt("emp_no"));
                e.setApellido(res.getString("apellido"));
                e.setOficio(res.getString("oficio"));
                e.setDir(res.getInt("dir"));
                e.setFecha(res.getDate("fecha_alt").toLocalDate());
                e.setSalario(res.getDouble("salario"));
                e.setComision(res.getDouble("comision"));
                e.setDept_no(res.getInt("dept_no"));
                empleados.add(e);
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return empleados;
    }
    

    
    
    
}
