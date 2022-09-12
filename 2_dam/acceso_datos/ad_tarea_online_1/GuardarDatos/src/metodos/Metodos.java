package metodos;

import alumno.Alumno;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodos {

    public static Vector vPrincipal = new Vector();
    public static int contadorPrincipal = 0;

    // PROCEDIMIENTO PARA GUARDAR DATOS EN 1 VECTOR
    public void guardar(Alumno unAlumno) {
        vPrincipal.addElement(unAlumno);
    }



    //PROCEDIMIENTO PARA GUARDAR EN UN ARCHIVO
    public void guardarArchivo(Alumno alumno) {
        try {
            FileWriter fw = new FileWriter("alumnos.dat", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(alumno.getNombre());
            pw.print("|" + alumno.getEmail());
            pw.print("|" + alumno.getTelefono());
            pw.println("|" + alumno.getEdad());
            pw.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //PROCEDIMIENTO PARA MOSTRAR LOS DATOS EN UN jTable
    public DefaultTableModel listaAlumnos() {

        //CREAMOS UN VECTOR QUE CONTENGA NOMBRE , EMAIL, TELEFONO ,EDAD 
        Vector cabeceras = new Vector();
        cabeceras.addElement("Nombre");
        cabeceras.addElement("Email");
        cabeceras.addElement("Telefono");
        cabeceras.addElement("Edad");

        // CREAMOS UN MODELO DE TABLA PARA AGREGAR EL VECTOR, EN LA UBICACION 0
        DefaultTableModel mdlTabla = new DefaultTableModel(cabeceras, 0);

        try {
            FileReader fr = new FileReader("alumnos.dat");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d = br.readLine()) != null) {
                StringTokenizer dato = new StringTokenizer(d, "|");
                Vector x = new Vector();
                while (dato.hasMoreTokens()) {
                    x.addElement(dato.nextToken());
                }
                mdlTabla.addRow(x);
                //contadorPrincipal++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return mdlTabla;
    }

    //PROCEDIMIENTO PARA POBLAR UN Jcombobox CON LAS EDADES
    public void cboEdad(JComboBox edades) {
        edades.removeAllItems();
        for (int i = 18; i < 60; i++) {
            edades.addItem(i);
        }
    }
    
    // PROCEDIMIENTO PARA CONTAR LOS REGISTROS
    public static int contador() {
         contadorPrincipal=0;
        try {
            FileReader fr = new FileReader("alumnos.dat");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d = br.readLine()) != null) {
                contadorPrincipal++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return contadorPrincipal;
    }
    


    public static boolean esNumerico(String valor) {
        try {
            if (valor != null) {
                Integer.parseInt(valor);
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
        return false;
    }
    
    

}
