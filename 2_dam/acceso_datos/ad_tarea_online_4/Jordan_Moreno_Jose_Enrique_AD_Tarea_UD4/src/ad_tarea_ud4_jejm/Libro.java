package ad_tarea_ud4_jejm;

public class Libro {

    private String titulo;
    private double precio;
    private Autor autor;
    private String editorial;
    private String tipo;

    public Libro(String titulo, double precio, String editorial, String tipo) {
        this.titulo = titulo;
        this.precio = precio;
        this.autor = null;
        this.editorial = editorial;
        this.tipo = tipo;
        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", precio=" + precio + ", autor=" + autor.getNombre().toString() + ", editorial=" + editorial + ", tipo: "+tipo;
    }
    
    

    
    
    

}
