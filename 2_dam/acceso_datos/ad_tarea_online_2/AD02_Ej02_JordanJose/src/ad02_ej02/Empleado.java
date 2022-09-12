package ad02_ej02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empleado {

    private int emp_no;
    private String apellido;
    private String oficio;
    private int dir;
    private static DateTimeFormatter formatAmerican = DateTimeFormatter.ofPattern("yyyy-LL-dd");
    private LocalDate fecha_alt = LocalDate.parse("1970-01-01", formatAmerican);
    private double salario;
    private double comision;
    private int dept_no;

    public Empleado() {
        this.emp_no = 0;
        this.apellido = "Desconocido";
        this.oficio = "Desconocido";
        this.dir = 0;
        this.salario = 0;
        this.comision = 0;
        this.dept_no = 0;
    }

    public Empleado(int emp_no, String apellido, String oficio, int dir, double salario, double comision, int dept_no) {
        this.emp_no = emp_no;
        this.apellido = apellido;
        this.oficio = oficio;
        this.dir = dir;
        this.salario = salario;
        this.comision = comision;
        this.dept_no = dept_no;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }
    
    public static DateTimeFormatter getFormatAmerican() {
        return formatAmerican;
    }

    public static void setFormatAmerican(DateTimeFormatter formatAmerican) {
        Empleado.formatAmerican = formatAmerican;
    }

    public LocalDate getFecha_alt() {
        return fecha_alt;
    }

    public void setFecha(String fechaNac) {
        DateTimeFormatter formatAmerican = DateTimeFormatter.ofPattern("yyyy-LL-dd");
        LocalDate fecha = LocalDate.parse(fechaNac, formatAmerican);
        this.fecha_alt = fecha;
    }

    public void setFecha(LocalDate fechaNac) {
        this.fecha_alt = fechaNac;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario > 0) {
            this.salario = salario;
        }
    }

    @Override
    public String toString() {
        return "Numero de Empleado: " + emp_no +"\t"+"Apellido: " + apellido +"\t"+"Oficio: " + oficio +"\t"+"Dir: " + dir +"\t"+" Fecha de Alta: " + fecha_alt +"\t"+"Salario: " + salario +"\t"+"Comision: " + comision +"\t"+"Departamento: " + dept_no;
    }
    
    
//    @Override
//    public String toString() {
//        System.out.println("-------------------------------------------------------------------------------------------------------------------");
//        System.out.println("Numero\tAPELLIDO\tOFICIO\tDIR\tFECHA\tSALARIO\tCOMISION\tDEPARTAMENTO");
//        System.out.println("--------------------------------------------------------------------------------------------------------------------");
//        return emp_no + "\t" + apellido + "\t" + oficio + "\t" + dir + "\t" + fecha_alt +"\t" + salario + "\t" + comision + "\t" + dept_no + "\n"
//                + "------------------------------------------------------------------------------------------------------------------------------";
//    }

}
