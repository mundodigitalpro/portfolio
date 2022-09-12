
package ad02_ej02;

public class EmpleadoDepartamento {

    private int numeroEmpleados;
    private int presupuestoDepartamento;
    private String nombreDepartamento;
    private int numeroDepartamento;
    private String nombreEmpleado;

    public EmpleadoDepartamento(int numeroEmpleados, int presupuestoDepartamento, String nombreDepartamento, int numeroDepartamento, String nombreEmpleado) {
        this.numeroEmpleados = numeroEmpleados;
        this.presupuestoDepartamento = presupuestoDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.numeroDepartamento = numeroDepartamento;
        this.nombreEmpleado = nombreEmpleado;
    }

        public EmpleadoDepartamento() {
        this.numeroEmpleados = 0;
        this.presupuestoDepartamento = 0;
        this.nombreDepartamento = "";
        this.numeroDepartamento = 0;
        this.nombreEmpleado = "";
    }
    


    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }
    

    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(int numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    public int getPresupuestoDepartamento() {
        return presupuestoDepartamento;
    }

    public void setPresupuestoDepartamento(int presupuestoDepartamento) {
        this.presupuestoDepartamento = presupuestoDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public int getNumeroDepartamento() {
        return numeroDepartamento;
    }

    public void setNumeroDepartamento(int numeroDepartamento) {
        this.numeroDepartamento = numeroDepartamento;
    }

    @Override
    public String toString() {
        return "Numero de Empleados: " + numeroEmpleados +"\t"+"Presupuesto: " + presupuestoDepartamento +"\t"+"Departamento: " + nombreDepartamento +"\t"+"Numero: " + numeroDepartamento +"\t"+"Apellido: " + nombreEmpleado;
    }


        
    
    
}
