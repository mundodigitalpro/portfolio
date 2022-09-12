package projectx.entidad;
// Generated 03-ene-2022 14:04:21 by Hibernate Tools 4.3.1



/**
 * Trabaja generated by hbm2java
 */
public class Trabaja  implements java.io.Serializable {


     private TrabajaId id;
     private Empleado empleado;
     private Proyecto proyecto;
     private Integer nhoras;

    public Trabaja() {
    }

	
    public Trabaja(TrabajaId id, Empleado empleado, Proyecto proyecto) {
        this.id = id;
        this.empleado = empleado;
        this.proyecto = proyecto;
    }
    public Trabaja(TrabajaId id, Empleado empleado, Proyecto proyecto, Integer nhoras) {
       this.id = id;
       this.empleado = empleado;
       this.proyecto = proyecto;
       this.nhoras = nhoras;
    }
   
    public TrabajaId getId() {
        return this.id;
    }
    
    public void setId(TrabajaId id) {
        this.id = id;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public Proyecto getProyecto() {
        return this.proyecto;
    }
    
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    public Integer getNhoras() {
        return this.nhoras;
    }
    
    public void setNhoras(Integer nhoras) {
        this.nhoras = nhoras;
    }




}


