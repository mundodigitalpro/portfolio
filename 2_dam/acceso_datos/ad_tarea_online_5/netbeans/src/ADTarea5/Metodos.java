package ADTarea5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

public class Metodos {

    // listar biblioteca
    public static String CONSULTA = "/biblioteca";
    //listar publicaciones 2002
    public static String CONSULTA0 = "/biblioteca/libros/libro[@publicacion=2002]";
    // listar publicaciones 2005
    public static String CONSULTA01 = "/biblioteca/libros/libro[@publicacion=2005]";
    //listar fechainicio
    public static String CONSULTA02 = "/biblioteca/prestamos/entrada/prestamo/fechainicio";
    //listar direccion 
    public static String CONSULTA03 = "/biblioteca/prestamos/entrada";
    // Listar Libros
    public static String CONSULTALIBROS = "/biblioteca/libros";
    // Listar Autores
    public static String CONSULTAAUTORES = "/biblioteca/libros/libro/autor";
    // Listar Prestamos
    public static String CONSULTAPRESTAMOS = "/biblioteca/prestamos";
    // 1. Título de los libros que se hayan públicado en 2002, y ordenalos alfabéticamente.
    public static String CONSULTA1 = "for $a in /biblioteca/libros/libro[@publicacion=2002] order by $a/titulo return $a/titulo/text()";
    // 2. Título de los libros que posean más de 1 autor.
    public static String CONSULTA2 = "for $titulo in /biblioteca/libros/libro let $autor := $titulo//autor where count($autor) > 1 order by $titulo/titulo return $titulo/titulo/text()";
    //3. Título, primer autor y páginas de los libros prestados.
    public static String CONSULTA3 = "for $libro in doc(\"colecciones.xml\")/biblioteca/libros/libro\n"
            + "for $prestado in doc(\"colecciones.xml\")/biblioteca/prestamos/entrada\n"
            + "where $prestado/titulo = $libro/titulo\n"
            + "return <resultado>{$libro/autor, $libro/paginas}</resultado>";
    //4. Nombre de cada lector y suma total de páginas de libros que le han prestado.
    public static String CONSULTA4 = "for $libro in doc(\"colecciones.xml\")/biblioteca/libros/libro\n"
            + "for $prestado in doc(\"colecciones.xml\")/biblioteca/prestamos/entrada\n"
            + "where $prestado/titulo = $libro/titulo\n"
            + "let $nombre := $prestado//nombre\n"
            + "group by $nombre\n"
            + "return <resultado>{$prestado/prestamo/lector/nombre, sum($libro/paginas) }</resultado>";

    //5. Insertar el nodo evaluacion y cuyo contenido sea 10 como último nodo en la publicacion=2007
    public static String CONSULTA5 = "update insert <evaluacion>10</evaluacion> into doc(\"colecciones.xml\")/biblioteca/libros/libro[@publicacion=2007]";
    //6. Sustituir el valor del nodo paginas con 700 en la publicacion=2005
    public static String CONSULTA6 = "update replace //libro[@publicacion=2005]/paginas with <paginas>700</paginas>";
    //7. Modificar el nombre del nodo inicio de cada documento de la colección Prestamos por fechainicio.
    public static String CONSULTA7 = "for $dato in /biblioteca/prestamos/entrada/prestamo/inicio return update rename $dato as 'fechainicio'";
    //8. Eliminar el nodo direccion de la tabla Prestamos.

    public static String CONSULTA8 = "for $direccion in /biblioteca/prestamos/entrada/prestamo/lector/direccion return update delete $direccion";
    public static String DRIVER = "org.exist.xmldb.DatabaseImpl";//Driver de Exist-DB
    public static Database DATABASE;
    public static Collection COLLECTION;
    public static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/coleccion"; // URI DE NUESTRA COLECCION
    public static String USER = "admin"; // Nombre de usuario de la BD 
    public static String PASSWORD = "1234"; // Contraseña
    public static XPathQueryService SERVICE;

    public static File FICHERO1 = new File("./consultas/consulta1.xq");
    public static File FICHERO2 = new File("./consultas/consulta2.xq");
    public static File FICHERO3 = new File("./consultas/consulta3.xq");
    public static File FICHERO4 = new File("./consultas/consulta4.xq");
    public static File FICHERO5 = new File("./consultas/consulta5.xq");
    public static File FICHERO6 = new File("./consultas/consulta6.xq");
    public static File FICHERO7 = new File("./consultas/consulta7.xq");
    public static File FICHERO8 = new File("./consultas/consulta8.xq");

    public static ResourceSet leerFichero1() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException, IOException {
        conexion();
        FileReader lector = new FileReader(FICHERO1); // Leemos el archivo
        BufferedReader buffer = new BufferedReader(lector); // Guardamos en el buffer la lectura del archivo
        String linea = buffer.readLine();
        ResourceSet resultado = SERVICE.query(linea);
        return resultado;
    }

    public static ResourceSet leerFichero2() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException, IOException {
        conexion();
        FileReader lector = new FileReader(FICHERO2); // Leemos el archivo
        BufferedReader buffer = new BufferedReader(lector); // Guardamos en el buffer la lectura del archivo
        String linea = buffer.readLine();
        ResourceSet resultado = SERVICE.query(linea);
        return resultado;
    }

    public static ResourceSet leerFichero3() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException, IOException {
        conexion();
        FileReader lector = new FileReader(FICHERO3); // Leemos el archivo
        BufferedReader buffer = new BufferedReader(lector); // Guardamos en el buffer la lectura del archivo
        String linea = buffer.readLine();
        ResourceSet resultado = SERVICE.query(linea);
        return resultado;
    }

    public static ResourceSet leerFichero4() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException, IOException {
        conexion();
        FileReader lector = new FileReader(FICHERO4); // Leemos el archivo
        BufferedReader buffer = new BufferedReader(lector); // Guardamos en el buffer la lectura del archivo
        String linea = buffer.readLine();
        ResourceSet resultado = SERVICE.query(linea);
        return resultado;
    }

    public static ResourceSet leerFichero5() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException, IOException {
        conexion();
        FileReader lector = new FileReader(FICHERO5); // Leemos el archivo
        BufferedReader buffer = new BufferedReader(lector); // Guardamos en el buffer la lectura del archivo
        String linea = buffer.readLine();
        SERVICE.query(linea);
        ResourceSet resultado = SERVICE.query(CONSULTALIBROS);//Consulta a lanzar de listado
        return resultado;
    }

    public static ResourceSet leerFichero6() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException, IOException {
        conexion();
        FileReader lector = new FileReader(FICHERO6); // Leemos el archivo
        BufferedReader buffer = new BufferedReader(lector); // Guardamos en el buffer la lectura del archivo
        String linea = buffer.readLine();
        SERVICE.query(linea);
        ResourceSet resultado = SERVICE.query(CONSULTA01);//Consulta a lanzar de listado
        return resultado;
    }

    public static ResourceSet leerFichero7() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException, IOException {
        conexion();
        FileReader lector = new FileReader(FICHERO7); // Leemos el archivo
        BufferedReader buffer = new BufferedReader(lector); // Guardamos en el buffer la lectura del archivo
        String linea = buffer.readLine();
        SERVICE.query(linea);
        ResourceSet resultado = SERVICE.query(CONSULTA02);//Consulta a lanzar de listado
        return resultado;
    }

    public static ResourceSet leerFichero8() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException, IOException {
        conexion();
        FileReader lector = new FileReader(FICHERO8); // Leemos el archivo
        BufferedReader buffer = new BufferedReader(lector); // Guardamos en el buffer la lectura del archivo
        String linea = buffer.readLine();
        SERVICE.query(linea);
        ResourceSet resultado = SERVICE.query(CONSULTA03);//Consulta a lanzar de listado
        return resultado;
    }

    public static void conexion() throws InstantiationException, XMLDBException, ClassNotFoundException, IllegalAccessException {
        Class cl = Class.forName(DRIVER);//Cargar el driver
        DATABASE = (Database) cl.newInstance(); //Instancia de la BD
        DATABASE.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(DATABASE); //Registrar la BD
        COLLECTION = DatabaseManager.getCollection(URI, USER, PASSWORD); //Accedemos a la colección
        SERVICE = (XPathQueryService) COLLECTION.getService("XPathQueryService", "1.0");
        SERVICE.setProperty("pretty", "true");
        SERVICE.setProperty("encoding", "ISO-8859-1");
    }

    public static ResourceSet consultaAutores() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        conexion();
        ResourceSet result = SERVICE.query(CONSULTAAUTORES);//Consulta a lanzar
        return result;
    }

    public static ResourceSet consultaPrestamos() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        conexion();
        ResourceSet result = SERVICE.query(CONSULTAPRESTAMOS);//Consulta a lanzar
        return result;
    }

    public static ResourceSet consultaLibros() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        conexion();
        ResourceSet result = SERVICE.query(CONSULTALIBROS);//Consulta a lanzar
        return result;
    }

    public static ResourceSet consulta0() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        conexion();
        ResourceSet result = SERVICE.query(CONSULTA);//Consulta a lanzar
        return result;
    }

    public static ResourceSet consulta1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        conexion();
        ResourceSet result = SERVICE.query(CONSULTA1);//Consulta a lanzar
        return result;
    }

    public static ResourceSet consulta2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        conexion();
        ResourceSet result = SERVICE.query(CONSULTA2);//Consulta a lanzar
        return result;
    }

    public static ResourceSet consulta3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        conexion();
        ResourceSet result = SERVICE.query(CONSULTA3);//Consulta a lanzar
        return result;
    }

    public static ResourceSet consulta4() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        conexion();
        ResourceSet result = SERVICE.query(CONSULTA4);//Consulta a lanzar
        return result;
    }

    //5 Insertar el nodo evaluacion y cuyo contenido sea 10 como último nodo en la publicacion=2007  No devuelve nada
    public static ResourceSet consulta5() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        String driver = "org.exist.xmldb.DatabaseImpl"; //Driver
        Class cl = Class.forName(driver);//Cargar el driver
        Database database = (Database) cl.newInstance(); //Instancia de la BD
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database); //Registrar la BD
        Collection col = DatabaseManager.getCollection("xmldb:exist://localhost:8080/exist/xmlrpc/db/coleccion", "admin", "1234"); //Accedemos a la colección
        XPathQueryService service0 = (XPathQueryService) col.getService("XPathQueryService", "1.0");
        XPathQueryService service = (XPathQueryService) col.getService("XPathQueryService", "1.0");
        service.setProperty("pretty", "true");
        service.setProperty("encoding", "ISO-8859-1");
        service0.query(CONSULTA5);//Consulta a lanzar de actualizacion
        ResourceSet result = service.query(CONSULTA0);//Consulta a lanzar de listado
        return result;
    }

    // 6 Sustituir el valor del nodo paginas con 700 en la publicacion=2005
    public static ResourceSet consulta6() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        String driver = "org.exist.xmldb.DatabaseImpl"; //Driver
        Class cl = Class.forName(driver);//Cargar el driver
        Database database = (Database) cl.newInstance(); //Instancia de la BD
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database); //Registrar la BD
        Collection col = DatabaseManager.getCollection("xmldb:exist://localhost:8080/exist/xmlrpc/db/coleccion", "admin", "1234"); //Accedemos a la colección
        XPathQueryService service0 = (XPathQueryService) col.getService("XPathQueryService", "1.0");
        XPathQueryService service = (XPathQueryService) col.getService("XPathQueryService", "1.0");
        service.setProperty("pretty", "true");
        service.setProperty("encoding", "ISO-8859-1");
        service0.query(CONSULTA6);//Consulta a lanzar de actualizacion
        ResourceSet result = service.query(CONSULTA01);//Consulta a lanzar de listado
        return result;
    }

    // 7.  Modificar el nombre del nodo inicio de cada documento de la colección Prestamos por fechainicio.
    public static ResourceSet consulta7() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        String driver = "org.exist.xmldb.DatabaseImpl"; //Driver
        Class cl = Class.forName(driver);//Cargar el driver
        Database database = (Database) cl.newInstance(); //Instancia de la BD
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database); //Registrar la BD
        Collection col = DatabaseManager.getCollection("xmldb:exist://localhost:8080/exist/xmlrpc/db/coleccion1", "admin", "1234"); //Accedemos a la colección
        XPathQueryService service0 = (XPathQueryService) col.getService("XPathQueryService", "1.0");
        XPathQueryService service = (XPathQueryService) col.getService("XPathQueryService", "1.0");
        service.setProperty("pretty", "true");
        service.setProperty("encoding", "ISO-8859-1");
        service0.query(CONSULTA7);//Consulta a lanzar de actualizacion
        ResourceSet result = service.query(CONSULTA02);//Consulta a lanzar de listado
        return result;
    }

    // 8 . Eliminar el nodo direccion de la tabla Prestamos.
    public static ResourceSet consulta8() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        String driver = "org.exist.xmldb.DatabaseImpl"; //Driver
        Class cl = Class.forName(driver);//Cargar el driver
        Database database = (Database) cl.newInstance(); //Instancia de la BD
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database); //Registrar la BD
        Collection col = DatabaseManager.getCollection("xmldb:exist://localhost:8080/exist/xmlrpc/db/coleccion1", "admin", "1234"); //Accedemos a la colección
        XPathQueryService service0 = (XPathQueryService) col.getService("XPathQueryService", "1.0");
        XPathQueryService service = (XPathQueryService) col.getService("XPathQueryService", "1.0");
        service.setProperty("pretty", "true");
        service.setProperty("encoding", "ISO-8859-1");
        service0.query(CONSULTA8);//Consulta a lanzar de actualizacion
        ResourceSet result = service.query(CONSULTA03);//Consulta a lanzar de listado
        return result;
    }

}
