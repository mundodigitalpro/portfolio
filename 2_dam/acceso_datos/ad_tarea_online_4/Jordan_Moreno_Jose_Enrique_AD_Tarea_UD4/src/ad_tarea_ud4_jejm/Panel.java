package ad_tarea_ud4_jejm;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Panel extends javax.swing.JFrame {


    private ObjectContainer db;

    /**
     * Creates new form Panel
     */
    public Panel() {
        initComponents();
        //crearBaseDatos();
        this.db = Metodos.crearBaseDatos();
        this.setTitle("AD UD4 Tarea Online JEJM");
        this.setLocationRelativeTo(null);
        
        tbResultado.setBackground(Color.WHITE);
        tbResultado.setSelectionForeground(Color.BLUE);
        txtAutor.setForeground(Color.DARK_GRAY);
        txtLibro.setForeground(Color.DARK_GRAY);
        txtValor1.setForeground(Color.DARK_GRAY);
        txtValor2.setForeground(Color.DARK_GRAY);
        Metodos.almacenarDatos(db);
    }

    private void mostrarAutores(ArrayList<Autor> autores) {
        Vector<String> tablaCabecera = new Vector<String>();
        Vector tablaDatos = new Vector();
        tablaCabecera.add("Nombre");
        tablaCabecera.add("Nacionalidad");
        tablaCabecera.add("Fecha de Nacimiento");
        tablaCabecera.add("Tipo");
        for (Autor autor : autores) {
            Vector<Object> columna = new Vector<Object>();
            columna.add(autor.getNombre());
            columna.add(autor.getNacionalidad());
            columna.add(autor.getFecha_nacimiento());
            columna.add(autor.getTipo());
            tablaDatos.add(columna);
        }
        tbResultado.setModel(new DefaultTableModel(tablaDatos, tablaCabecera));
    }

    private void mostrarLibros(ArrayList<Libro> libros) {
        Vector<String> tablaCabecera = new Vector<String>();
        Vector tablaDatos = new Vector();
        tablaCabecera.add("Titulo");
        tablaCabecera.add("Precio");
        tablaCabecera.add("Autor");
        tablaCabecera.add("Editorial");
        tablaCabecera.add("Tipo");

        for (Libro libro : libros) {
            Vector<Object> columna = new Vector<Object>();
            columna.add(libro.getTitulo());
            columna.add(libro.getPrecio());
            columna.add(libro.getAutor());
            columna.add(libro.getEditorial());
            columna.add(libro.getTipo());
            tablaDatos.add(columna);
        }
        tbResultado.setModel(new DefaultTableModel(tablaDatos, tablaCabecera));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultado = new javax.swing.JTable();
        btnListarAutores = new javax.swing.JButton();
        btnListarAutoresEspañoles = new javax.swing.JButton();
        btnConsultarLibrosAutor = new javax.swing.JButton();
        txtAutor = new javax.swing.JTextField();
        btnConsultarPrecios = new javax.swing.JButton();
        txtValor1 = new javax.swing.JTextField();
        txtValor2 = new javax.swing.JTextField();
        btnAumentaPrecios = new javax.swing.JButton();
        btnListarLibros = new javax.swing.JButton();
        btnBorrarLibro = new javax.swing.JButton();
        txtLibro = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbResultado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbResultado);

        btnListarAutores.setText("Listar Autores");
        btnListarAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarAutoresActionPerformed(evt);
            }
        });

        btnListarAutoresEspañoles.setText("Listar Autores Españoles");
        btnListarAutoresEspañoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarAutoresEspañolesActionPerformed(evt);
            }
        });

        btnConsultarLibrosAutor.setText("Consultar Libros por Autor");
        btnConsultarLibrosAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarLibrosAutorActionPerformed(evt);
            }
        });

        btnConsultarPrecios.setText("Consultar Precios");
        btnConsultarPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarPreciosActionPerformed(evt);
            }
        });

        txtValor1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValor1KeyTyped(evt);
            }
        });

        txtValor2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValor2KeyTyped(evt);
            }
        });

        btnAumentaPrecios.setText("Aumenta Precios 5%");
        btnAumentaPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumentaPreciosActionPerformed(evt);
            }
        });

        btnListarLibros.setText("Listar Libros");
        btnListarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarLibrosActionPerformed(evt);
            }
        });

        btnBorrarLibro.setText("Borrar Libro");
        btnBorrarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarLibroActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ad_tarea_ud4_jejm/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel2.setText("Desde:");

        jLabel3.setText("Hasta:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ad_tarea_ud4_jejm/biblioteca.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConsultarLibrosAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAutor))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBorrarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLibro))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConsultarPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValor1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtValor2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAumentaPrecios, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnListarAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnListarAutoresEspañoles, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnListarLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(178, 178, 178))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarAutores)
                    .addComponent(btnListarAutoresEspañoles)
                    .addComponent(btnListarLibros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultarLibrosAutor)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultarPrecios)
                    .addComponent(txtValor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAumentaPrecios)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtValor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrarLibro)
                    .addComponent(txtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnSalir)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarAutoresActionPerformed
        mostrarAutores(Metodos.consultarAutores(db));
    }//GEN-LAST:event_btnListarAutoresActionPerformed

    private void btnListarAutoresEspañolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarAutoresEspañolesActionPerformed
        mostrarAutores(Metodos.consultarAutoresEspanoles(db));
    }//GEN-LAST:event_btnListarAutoresEspañolesActionPerformed

    private void btnConsultarLibrosAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarLibrosAutorActionPerformed
        String nombreAutor = txtAutor.getText().toString();
        if (Metodos.existeAutor(db, nombreAutor)) {
            mostrarLibros(Metodos.consultarLibroAutor(db, nombreAutor));
        } else {
            JOptionPane.showMessageDialog(this, "El autor " + nombreAutor + " no existe, prueba con otro autor", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnConsultarLibrosAutorActionPerformed

    private void btnConsultarPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPreciosActionPerformed
        if (!txtValor1.getText().isEmpty() && !txtValor2.getText().isEmpty()
                && txtValor1.getText().matches("\\d*") && txtValor2.getText().matches("\\d*")) {
            double valor1 = Double.parseDouble(txtValor1.getText().toString());
            double valor2 = Double.parseDouble(txtValor2.getText().toString());
            mostrarLibros(Metodos.consultaLibroEntrePrecios(db, valor1, valor2));
        } else {
            JOptionPane.showMessageDialog(this, "Indica Precio Desde/Hasta", "Error campos vacíos", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnConsultarPreciosActionPerformed

    private void btnAumentaPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentaPreciosActionPerformed

        int total = Metodos.actualizarPreciosLibros2(db);
        mostrarLibros(Metodos.consultarLibros(db));
        JOptionPane.showMessageDialog(this, "Libros Actualizados:  " + total + " libros", "Libro Actualizado Correctamente", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAumentaPreciosActionPerformed

    private void btnListarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarLibrosActionPerformed
        mostrarLibros(Metodos.consultarLibros(db));
    }//GEN-LAST:event_btnListarLibrosActionPerformed

    private void btnBorrarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarLibroActionPerformed
        String titulo = txtLibro.getText().toString();
        if (Metodos.existeLibro(db, titulo)) {
            int total = Metodos.borrarLibroTitulo2(db, titulo);
            txtLibro.setText("");//Borra texto
            mostrarLibros(Metodos.consultarLibros(db));
            JOptionPane.showMessageDialog(this, "Libros Borrados:  " + total + " libros", "Libro Borrado Correctamente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "El libro " + titulo + " no existe, prueba con otro titulo", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarLibroActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "¿ Desea salir de la aplicación ?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            //limpiarFormulario();
            db.close();
            dispose();
        }

    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtValor1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValor1KeyTyped
        char TestChar = evt.getKeyChar();
        if (!(Character.isDigit(TestChar))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValor1KeyTyped

    private void txtValor2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValor2KeyTyped
        char TestChar = evt.getKeyChar();
        if (!(Character.isDigit(TestChar))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValor2KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAumentaPrecios;
    private javax.swing.JButton btnBorrarLibro;
    private javax.swing.JButton btnConsultarLibrosAutor;
    private javax.swing.JButton btnConsultarPrecios;
    private javax.swing.JButton btnListarAutores;
    private javax.swing.JButton btnListarAutoresEspañoles;
    private javax.swing.JButton btnListarLibros;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbResultado;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtLibro;
    private javax.swing.JTextField txtValor1;
    private javax.swing.JTextField txtValor2;
    // End of variables declaration//GEN-END:variables
}
