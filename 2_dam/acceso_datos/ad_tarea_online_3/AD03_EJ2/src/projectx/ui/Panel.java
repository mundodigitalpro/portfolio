package projectx.ui;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.*;
import projectx.entidad.*;
import projectx.entidad.Empleado;
import projectx.entidad.Departamento;
import projectx.util.HibernateUtil;
import projectx.util.Utilidades;

public class Panel extends javax.swing.JFrame {

    public Panel() {
        initComponents();
    }

    //CONSULTA COMPLETA
    private static String CONSULTA = "from Empleado";

    private void ejecutaConsulta() {
        ejecutaHQLConsulta(CONSULTA);
    }

    private void ejecutaHQLConsulta(String hql) {
        try {
            Session session = projectx.util.HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query consulta = session.createQuery(hql);
            List resultList = consulta.list();
            mostrarResultados(resultList);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    //MOSTRAR RESULTADOS COMPLETO
    private void mostrarResultados(List resultList) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Codigo");
        tableHeaders.add("Nombre");
        tableHeaders.add("Fecha");
        tableHeaders.add("Salario");
        tableHeaders.add("Departamento");
        tableHeaders.add("Jefe");

        for (Object o : resultList) {
            Empleado empleado = (Empleado) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(empleado.getCodEmp());
            oneRow.add(empleado.getNomEmp());
            oneRow.add(empleado.getFechaIngreso());
            oneRow.add(empleado.getSalario());
            oneRow.add(empleado.getDepartamento());
            oneRow.add(empleado.getEmpleado());

            tableData.add(oneRow);
        }
        tbResultado.setModel(new DefaultTableModel(tableData, tableHeaders));
    }

    //Consulta: Empleados con salario superior a 1000 € (mostrar su nombre, número de departamento y salario)".
    private static String CONSULTA1 = "from Empleado where salario > 1000";

    private void ejecutaConsulta1() {
        ejecutaHQLConsulta1(CONSULTA1);
    }

    private void ejecutaHQLConsulta1(String hql) {
        try {
            Session session = projectx.util.HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query consulta = session.createQuery(hql);
            List resultList = consulta.list();
            mostrarResultados1(resultList);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    //MOSTRAR RESULTADOS
    private void mostrarResultados1(List resultList) {
        Vector<String> tableHeaders = new Vector<>();
        Vector tableData = new Vector();
        //tableHeaders.add("Codigo");
        tableHeaders.add("Nombre");
        //tableHeaders.add("Fecha");
        tableHeaders.add("Salario");
        tableHeaders.add("Departamento");
        //tableHeaders.add("Jefe");

        for (Object o : resultList) {
            Empleado empleado = (Empleado) o;
            Vector<Object> oneRow = new Vector<Object>();
            //oneRow.add(empleado.getCodEmp());
            oneRow.add(empleado.getNomEmp());
            //oneRow.add(empleado.getFechaIngreso());
            oneRow.add(empleado.getSalario());
            oneRow.add(empleado.getDepartamento());
            //oneRow.add(empleado.getEmpleado());

            tableData.add(oneRow);
        }
        tbResultado.setModel(new DefaultTableModel(tableData, tableHeaders));
    }

    // METODO INSERTAR
    public void insertar() {
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        Date fecha = new Date();
        Float salario = Float.valueOf(txtSalario.getText());
        Departamento departamento = new Departamento();
        departamento.setCodDepto(txtDepartamento.getText());
        Empleado jefe = new Empleado();
        jefe.setCodEmp(txtJefe.getText());
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Empleado empleado = new Empleado();
            empleado.setCodEmp(codigo);
            empleado.setNomEmp(nombre);
            empleado.setFechaIngreso(fecha);
            empleado.setSalario(salario);
            empleado.setEmpleado(jefe);
            empleado.setDepartamento(departamento);
            session.save(empleado);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
    }
    

    

    //METODO ACTUALIZAR con OBJETOS
    public void actualizar() {
        String codigo = txtCodigo.getText();
        Float salario = Float.valueOf(txtSalario.getText());
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Empleado empleado = (Empleado) session.get(Empleado.class, codigo);
            empleado.setSalario(salario);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
    }

    //METODO ACTUALIZAR HQL
    public void actualizarHQL() {
        String codigo = txtCodigo.getText();
        Float salario = Float.valueOf(txtSalario.getText());
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //session.createQuery("update Empleado set salario=" + salario + " where codEmp=" + "'" + codigo + "'").executeUpdate();
            session.createQuery("update Empleado set salario=" + salario + " where codEmp=" + "'" + codigo + "'").executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
    }

    //METODO BORRAR HQL
    public void borrarHQL() {
        String codigo = txtCodigo.getText();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.createQuery("delete from Empleado where codEmp=" + "'" + codigo + "'").executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
    }

    //METODO INSERTAR HQL
        /**
     Query qry = session.createQuery("insert into Product(productId,proName,price)
     select i.itemId,i.itemName,i.itemPrice from Items i where i.itemId= ?");
     
     **/
        public void insertarHQL() {
        String codigo = txtCodigo.getText();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.createQuery("insert into Empleado(codEmp,departamento,empleado,nomEmp,fechaIngreso,salario)where codEmp=" + "'" + codigo + "'").executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
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
        btConsulta = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblSalario = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        lblJefe = new javax.swing.JLabel();
        txtJefe = new javax.swing.JTextField();
        lblDepartamento = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        btConsulta.setText("Consulta: \"Empleados con salario superior a 1000 €\"");
        btConsulta.setToolTipText("Ejercicio");
        btConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultaActionPerformed(evt);
            }
        });

        txtFecha.setEditable(false);
        txtFecha.setEnabled(false);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        lblCodigo.setText("Codigo Empleado");

        lblNombre.setText("Nombre Empleado");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        lblFecha.setText("Fecha Ingreso");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblSalario.setText("Salario");

        txtSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioActionPerformed(evt);
            }
        });

        lblJefe.setText("Jefe");

        txtJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJefeActionPerformed(evt);
            }
        });

        lblDepartamento.setText("Departamento");

        txtDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartamentoActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btListar.setText("Listar");
        btListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre)
                                    .addComponent(lblFecha))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblCodigo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInsertar)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(312, 312, 312))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSalario)
                            .addComponent(lblJefe)
                            .addComponent(lblDepartamento))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(btConsulta)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(133, 133, 133)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(516, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblCodigo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsertar)
                            .addComponent(btnActualizar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrar)
                            .addComponent(btListar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFecha)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblSalario))
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJefe)
                    .addComponent(txtJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartamento)
                    .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btConsulta)
                .addGap(32, 32, 32))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(508, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultaActionPerformed
        ejecutaConsulta1();
    }//GEN-LAST:event_btConsultaActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioActionPerformed

    private void txtJefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJefeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJefeActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        insertar();
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void txtDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartamentoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //actualizar();
        actualizarHQL();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        borrarHQL();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarActionPerformed
        ejecutaConsulta();
    }//GEN-LAST:event_btListarActionPerformed

//     /* Entity Manager gestor de persistencia*/
//    private static EntityManager manager;
//    private static EntityManagerFactory emf;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

//        /* Crear el gestor de persistencia*/
//        emf = Persistence.createEntityManagerFactory("Persistencia");
//        manager = emf.createEntityManager();
//        
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
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (java.lang.InstantiationException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton btConsulta;
    private javax.swing.JButton btListar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblJefe;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JTable tbResultado;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtJefe;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables

}
