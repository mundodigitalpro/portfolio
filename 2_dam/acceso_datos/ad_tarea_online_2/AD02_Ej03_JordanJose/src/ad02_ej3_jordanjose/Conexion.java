package ad02_ej3_jordanjose;

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

    /* PROCEDIMIENTOS ALMACENADOS   P.A. 3:
    *  P.A. 3: Un procedimiento almacenado que aumente el salario de los empleados de cierto departamento en un porcentaje. 
    *departamento y valor entero del porcentaje a aplicar se han de pasar como parámetros (de entrada).
     */
    
    public void aumentarSalarioDepartamentoIncremento(int departamento, int incremento) {
        try {
            CallableStatement pa = connection.prepareCall("{call aumentarSalario (?, ?)}");
            pa.setInt(1, departamento);
            pa.setInt(2, incremento);
            pa.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
    
 /* PROCEDIMIENTOS ALMACEDADOS   P.A. 2:
    * Un procedimiento almacenado que devuelva en un parámetro de salida, el número total de empleados dados de alta en la consultora,
    * cuyo salario pertenece a un determinado intervalo económico. Se deben pasar como parámetros al procedimiento, 
    * tanto el valor inicial como el valor final de dicho intervalo.
     */
    public int totalEmpleadosIntervaloSalario(int salario1, int salario2) {
        int num = 1;
        try {
            CallableStatement pa = connection.prepareCall("{call totalEmpleados (?, ?, ?)}");
            pa.setInt(1, salario1);
            pa.setInt(2, salario2);
            pa.registerOutParameter(3, java.sql.Types.INTEGER);
            pa.execute();
            num = pa.getInt(3);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return num;
    }

    /* PROCEDIMIENTOS ALMACENADOS
    P.A. 1: Un procedimiento almacenado que obtenga en un parámetro de salida, 
    el número total de empleados cuya comisión pertenece a un determinado intervalo.
    Se deben pasar como parámetros al procedimiento, tanto el valor inicial del intervalo como el valor final.
     */
    public int empleadosIntervaloComision(int comision1, int comision2) {
        int num = 1;
        try {
            CallableStatement pa = connection.prepareCall("{call empleadosComision (?, ?, ?)}");
            pa.setInt(1, comision1);
            pa.setInt(2, comision2);
            pa.registerOutParameter(3, java.sql.Types.INTEGER);
            pa.execute();
            num = pa.getInt(3);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return num;
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
    
    /* PREPARED STATEMENT */
 //Obtener Empleados que pertenecen a un departamento, indicado por su num
    public ArrayList consultaPreparadaEmpleadoNumeroDepartamento(int numeroDepartamento) throws SQLException {
        if (connection != null) {
            System.out.println("Conectado con la Base de Datos");
        }
        ArrayList<Empleado> empleados = new ArrayList();
        try {
            
            //Statement orden = connection.createStatement();
            //ResultSet res = orden.executeQuery("SELECT * FROM empleados WHERE dept_no =" + numeroDepartamento);
            
            String consulta = "SELECT * FROM empleados WHERE dept_no = ?";
            PreparedStatement sentencia = connection.prepareStatement(consulta);
            sentencia.setInt(1, numeroDepartamento);
            ResultSet res = sentencia.executeQuery();
            
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
