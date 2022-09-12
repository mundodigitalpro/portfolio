package ad_tarea_ud4_jejm;

import java.time.LocalDate;

public class Autor {

    private String nombre;
    private String nacionalidad;
    private LocalDate fecha_nacimiento;
    private String tipo;

    public Autor(String nombre, String nacionalidad, LocalDate fecha_nacimiento, String tipo) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.tipo = tipo;
    }

    public Autor() {
        this.nombre = "Nombre Desconocido";
        this.nacionalidad = "Nacionalidad Desconocida";
        this.fecha_nacimiento = null;
        this.tipo = "Tipo Desconocido";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
