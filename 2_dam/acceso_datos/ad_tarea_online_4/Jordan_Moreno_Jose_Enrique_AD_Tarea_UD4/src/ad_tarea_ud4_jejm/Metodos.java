package ad_tarea_ud4_jejm;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Constraint;
import com.db4o.query.Query;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Metodos {

    //METODO PARA CREAR LA BASE DE DATOS
    public static ObjectContainer crearBaseDatos() {
        File file1 = new File("biblioteca.db4o");
        try {
            if (file1.exists() && !file1.isDirectory()) {
                file1.delete();
                ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "biblioteca.db4o");
                JOptionPane.showMessageDialog(null, "Base de Datos Creada", "Conexion Base de Datos", JOptionPane.INFORMATION_MESSAGE);
                return db;
            } else {
                ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "biblioteca.db4o");
                JOptionPane.showMessageDialog(null, "Base de Datos Creada", "Conexion Base de Datos", JOptionPane.INFORMATION_MESSAGE);
                return db;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error al abrir conexión BBDD", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public static void almacenarDatos(ObjectContainer db) {
        //Objetos tipo Libro

        Libro libro1 = new Libro("Don Quijote de la Mancha", 40.0, "Editorial 1", "Novela");
        Libro libro2 = new Libro("La Sombra del Viento", 21.0, "Editorial 2", "Novela");
        Libro libro3 = new Libro("Niebla", 7.59, "Editorial 3", "Novela");
        Libro libro4 = new Libro("Lazarillo de Tormes", 8.99, "Editorial 1", "Novela");
        Libro libro5 = new Libro("El yo y el ello", 12.0, "Editorial 7", "Psicologia");
        Libro libro6 = new Libro("Totem y tabu", 16.0, "Editorial 6", "Psicologia");
        Libro libro7 = new Libro("Fahrenheit 451", 4.99, "Editorial 4", "Ciencia Ficcion");
        Libro libro8 = new Libro("Cronicas marcianas", 5.2, "Editorial 1", "Ciencia Ficcion");
        Libro libro9 = new Libro("Los Juegos del Hambre", .0, "Editorial 2", "Ciencia Ficcion");
        Libro libro10 = new Libro("Los Pilares de la Tierra", 31.0, "Editorial 5", "Historica");
        Libro libro11 = new Libro("El nombre de la Rosa", 27.0, "Editorial 2", "Historica");

        //Objetos tipo Autor
        Autor autor1 = new Autor("Miguel de Cervantes", "Espana", LocalDate.of(1547, 9, 29), "Autor");
        Autor autor2 = new Autor("Carlos Ruiz Zafon", "Espana", LocalDate.of(1964, 9, 25), "Autor");
        Autor autor3 = new Autor("Miguel de Unamuno", "Espana", LocalDate.of(1864, 9, 29), "Autor");
        Autor autor4 = new Autor("Sigmund Freud", "Republica Checa", LocalDate.of(1856, 5, 6), "Autor");
        Autor autor5 = new Autor("Ray Bradbury", "EEUU", LocalDate.of(1920, 8, 22), "Autor");
        Autor autor6 = new Autor("Suzanne Collins", "EEUU", LocalDate.of(1962, 8, 10), "Autor");
        Autor autor7 = new Autor("Ken Follet", "Reino Unido", LocalDate.of(1949, 6, 5), "Autor");
        Autor autor8 = new Autor("Umberto Eco", "Italia", LocalDate.of(1932, 1, 5), "Autor");
        Autor autor9 = new Autor("Anonimo", "Anonimo", LocalDate.of(1900, 1, 1), "Anonimo");

        //Se asigna un autor a cada libro
        libro1.setAutor(autor1);
        libro2.setAutor(autor2);
        libro3.setAutor(autor3);
        libro4.setAutor(autor9);
        libro5.setAutor(autor4);
        libro6.setAutor(autor4);
        libro7.setAutor(autor5);
        libro8.setAutor(autor5);
        libro9.setAutor(autor6);
        libro10.setAutor(autor7);
        libro11.setAutor(autor8);

        //Guardamos Objetos
        db.store(libro1);
        db.store(libro2);
        db.store(libro3);
        db.store(libro4);
        db.store(libro5);
        db.store(libro6);
        db.store(libro7);
        db.store(libro8);
        db.store(libro9);
        db.store(libro10);
        db.store(libro11);

        //CERRAMOS LA BASE DE DATOS
        //db.close();
    }
    //CONSULTAR LIBROS ORDENADOS POR TITULO

    public static ArrayList<Libro> consultarLibros(ObjectContainer db) {
        ArrayList libros = new ArrayList<Libro>();
        Query query = db.query();//declara un objeto Query
        query.constrain(Libro.class); //indica la clase a la que se aplicarán restricciones
        //query.descend("tipo").orderAscending();
        query.descend("titulo").orderAscending();
        ObjectSet result = query.execute();
        while (result.hasNext()) {
            libros.add((Libro) result.next());
        }
        return libros;
    }

    // MOSTRAR TODOS LOS AUTORES ORDENADOS POR TIPO Y NOMBRE
    public static ArrayList<Autor> consultarAutores(ObjectContainer db) {
        ArrayList autores = new ArrayList<Autor>();
        Query query = db.query();//declara un objeto Query
        query.constrain(Autor.class); //indica la clase a la que se aplicarán restricciones
        query.descend("tipo").orderAscending();
        query.descend("nombre").orderAscending();
        ObjectSet result = query.execute();
        while (result.hasNext()) {
            autores.add((Autor) result.next());
        }
        return autores;
    }

    // CONSULTAR TODOS LOS AUTORES ORDENADOS POR TIPO Y NOMBRE
    public static ArrayList<Autor> consultarAutoresEspanoles(ObjectContainer db) {
        ArrayList autores = new ArrayList<Autor>();
        Query query = db.query();//declara un objeto Query
        query.constrain(Autor.class); //indica la clase a la que se aplicarán restricciones
        query.descend("nacionalidad").constrain("Espana");
        ObjectSet result = query.execute();
        while (result.hasNext()) {
            autores.add((Autor) result.next());
        }
        return autores;
    }

    //CONSULTAR LIBROS POR AUTOR
    public static ArrayList<Libro> consultarLibroAutor(ObjectContainer db, String nombreAutor) {
        ArrayList libros = new ArrayList<Libro>();
        Autor a = new Autor(nombreAutor, null, null, null);//Objeto Autor con patron de busqueda
        Libro l = new Libro(null, 0, null, null);
        l.setAutor(a);//se asocia el autor de busqueda al libro
        ObjectSet result = db.queryByExample(l); //Consulta los libros con los patrones indicados
        while (result.hasNext()) {
            libros.add((Libro) result.next());
        }
        return libros;
    }

    //CONSULTAR LIBROS ENTRE 2 PRECIOS
    public static ArrayList<Libro> consultaLibroEntrePrecios(ObjectContainer db, double precio1, double precio2) {
        ArrayList libros = new ArrayList<Libro>();
        Query query = db.query();
        Constraint intervalo2;
        query.constrain(Libro.class);
        if (precio1 <= precio2) {
            intervalo2 = query.descend("precio").constrain(precio2).smaller().equal();
            query.descend("precio").constrain(precio1).greater().equal().and(intervalo2);
        } else {
            intervalo2 = query.descend("precio").constrain(precio1).smaller().equal();
            query.descend("precio").constrain(precio2).greater().equal().and(intervalo2);
        }
        ObjectSet result = query.execute();
        while (result.hasNext()) {
            libros.add((Libro) result.next());
        }
        return libros;
    }

    //AUMENTA PRECIO DE LOS LIBROS 5%
    public static int actualizarPreciosLibros2(ObjectContainer db) {
        int total = 0;
        double precio = 0, porcentaje = 0, precioActual = 0;
        ObjectSet res = db.queryByExample(new Libro(null, 0, null, null));
        while (res.hasNext()) {
            Libro l = (Libro) res.next();
            System.out.println("Actualizando Precios: " + l);
            precioActual = l.getPrecio();
            porcentaje = 0.05 * precioActual;
            precio = precioActual + porcentaje;
            l.setPrecio(precio);
            db.store(l);
            total++;
        }
        return total;
    }

    //BORRAR LIBRO POR TITULO
    public static void borrarLibroTitulo(ObjectContainer db, String titulo) {
        Query query = db.query(); //declaración de un objeto query(). 
        query.constrain(Libro.class);//establece la clase a la que se aplicará la restricción
        query.descend("titulo").constrain(titulo);//establece la restricción de búsqueda
        ObjectSet resul = query.execute();//ejecuta consulta con restricción búsqueda

        while (resul.hasNext()) { //bucle que recupera los objetos charla y elimina de la BDOO
            Libro l = (Libro) resul.next();
            //System.out.println("Eliminando Libro: " + l);
            db.delete(l);
        }
    }

    //BORRAR LIBRO POR TITULO
    public static int borrarLibroTitulo2(ObjectContainer db, String titulo) {
        int total = 0;
        Query query = db.query(); //declaración de un objeto query(). 
        query.constrain(Libro.class);//establece la clase a la que se aplicará la restricción
        query.descend("titulo").constrain(titulo);//establece la restricción de búsqueda
        ObjectSet resul = query.execute();//ejecuta consulta con restricción búsqueda

        while (resul.hasNext()) { //bucle que recupera los objetos charla y elimina de la BDOO
            Libro l = (Libro) resul.next();
            //System.out.println("Eliminando Libro: " + l);
            db.delete(l);
            total++;
        }
        return total;
    }

    //verificamos si existe un libro
    public static boolean existeLibro(ObjectContainer db, String titulo) {
        Query query = db.query(); //declaración de un objeto query(). 
        query.constrain(Libro.class);//establece la clase a la que se aplicará la restricción
        query.descend("titulo").constrain(titulo);
        ObjectSet res = query.execute();
        if (!res.isEmpty()) { //si no está vacio devolvemos true
            return true;
        }
        return false;
    }

    //verificamos si existe un autor
    public static boolean existeAutor(ObjectContainer db, String nombre) {
        Query query = db.query(); //declaración de un objeto query(). 
        query.constrain(Autor.class);//establece la clase a la que se aplicará la restricción
        query.descend("nombre").constrain(nombre);
        ObjectSet res = query.execute();
        if (!res.isEmpty()) { //si no está vacio devolvemos true
            return true;
        }
        return false;
    }

}
