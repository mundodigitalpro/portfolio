package consultorait.ui;

import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.*;
import consultorait.entity.*;

public class PanelConsulta extends javax.swing.JFrame {

    public PanelConsulta() {
        initComponents();
    }
    //Consulta 1: Apellido, nombre, salario y número de empleado con un salario inferior a 1600.
    private static String CONSULTA1 = "from Empleados where salario < 1600";

    private void ejecutaConsulta1() {
        ejecutaHQLConsulta1(CONSULTA1);
    }
    //Consulta 2: Número de empleado, departamento y salario de los empleados, ordenados de menor a mayor salario.
    private static String CONSULTA2 = "from Empleados order by salario";

    private void ejecutaConsulta2() {
        ejecutaHQLConsulta2(CONSULTA2);
    }

    //Consulta 3: Datos de empleados cuyo departamento no esté en GRANADA.
    private static String CONSULTA3 = "from Empleados e where e.departamentos IN (select d.deptNo from Departamentos d where d.loc <> 'GRANADA')";

    private void ejecutaConsulta3() {
        ejecutaHQLConsulta3(CONSULTA3);
    }

    //Consulta 4: Apellido, salario y número de departamento de los empleados cuyo salario sea mayor que el máximo salario del departamento 10.
    //private static String CONSULTA4 = "select e.apellido, e.salario, e.departamentos from Empleados e where e.salario > (select max (e.salario) from Empleados e where e.departamentos = 10)";
    private static String CONSULTA4 = "from Empleados e where e.salario > (select max (e.salario) from Empleados e where e.departamentos = 10)";

    private void ejecutaConsulta4() {
        ejecutaHQLConsulta4(CONSULTA4);
    }

    private static String CONSULTA5 = "from Empleados e where e.salario < any (select e.salario from Empleados e where e.departamentos = 20)";

    private void ejecutaConsulta5() {
        ejecutaHQLConsulta5(CONSULTA5);
    }
    
    //Consulta 6: Mostrar nombre y total de empleados de aquellos departamentos con más de un empleado adscrito. Ordena el resultado por número de empleado.
    private static String CONSULTA6 = "from Empleados e group by e.departamentos having count(*) > 1 order by e.empNo";

    private void ejecutaConsulta6() {
        ejecutaHQLConsulta6(CONSULTA6);
    }

    private void ejecutaHQLConsulta1(String hql) {
        try {
            Session session = consultorait.util.HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query consulta = session.createQuery(hql);
            List resultList = consulta.list();
            mostrarResultados1(resultList);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    //Apellido, nombre, salario y número de empleado
    private void mostrarResultados1(List resultList) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Apellido");
        tableHeaders.add("Salario");
        tableHeaders.add("Empleado No");
        for (Object o : resultList) {
            Empleados empleados = (Empleados) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(empleados.getApellido());
            oneRow.add(empleados.getSalario());
            oneRow.add(empleados.getEmpNo());
            tableData.add(oneRow);
        }
        tbResultado.setModel(new DefaultTableModel(tableData, tableHeaders));
    }

    private void ejecutaHQLConsulta2(String hql) {
        try {
            Session session = consultorait.util.HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query consulta = session.createQuery(hql);
            List resultList = consulta.list();
            mostrarResultados2(resultList);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    //Número de empleado, departamento y salario de los empleados, ordenados de menor a mayor salario.
    private void mostrarResultados2(List resultList) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Empleado No");
        tableHeaders.add("Departamento No");
        tableHeaders.add("Salario");
        for (Object o : resultList) {
            Empleados empleados = (Empleados) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(empleados.getEmpNo());
            //oneRow.add(empleados.getDepartamentos());
            oneRow.add(empleados.getDepartamentos().getDeptNo());
            oneRow.add(empleados.getSalario());
            tableData.add(oneRow);
        }
        tbResultado.setModel(new DefaultTableModel(tableData, tableHeaders));
    }

    private void ejecutaHQLConsulta3(String hql) {
        try {
            Session session = consultorait.util.HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query consulta = session.createQuery(hql);
            List resultList = consulta.list();
            mostrarResultados3(resultList);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    //Consulta 3: Datos de empleados cuyo departamento no esté en GRANADA.
    private void mostrarResultados3(List resultList) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Empleado No");
        tableHeaders.add("Departamento No");
        tableHeaders.add("Apellido");
        tableHeaders.add("Oficio");
        tableHeaders.add("Direccion");
        tableHeaders.add("Fecha Alta");
        tableHeaders.add("Salario");
        tableHeaders.add("Comision");
        for (Object o : resultList) {
            Empleados empleados = (Empleados) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(empleados.getEmpNo());
            //oneRow.add(empleados.getDepartamentos());
            oneRow.add(empleados.getDepartamentos().getDeptNo());
            oneRow.add(empleados.getApellido());
            oneRow.add(empleados.getOficio());
            oneRow.add(empleados.getDir());
            oneRow.add(empleados.getFechaAlt());
            oneRow.add(empleados.getSalario());
            oneRow.add(empleados.getComision());
            tableData.add(oneRow);
        }
        tbResultado.setModel(new DefaultTableModel(tableData, tableHeaders));
    }

    private void ejecutaHQLConsulta4(String hql) {
        try {
            Session session = consultorait.util.HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query consulta = session.createQuery(hql);
            List resultList = consulta.list();
            mostrarResultados4(resultList);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    //Consulta 4: Apellido, salario y número de departamento de los empleados cuyo salario sea mayor que el máximo salario del departamento 10.
    private void mostrarResultados4(List resultList) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Apellido");
        tableHeaders.add("Salario");
        tableHeaders.add("Departamento No");

        for (Object o : resultList) {
            Empleados empleados = (Empleados) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(empleados.getApellido());
            oneRow.add(empleados.getSalario());
            oneRow.add(empleados.getDepartamentos().getDeptNo());

            tableData.add(oneRow);
        }
        tbResultado.setModel(new DefaultTableModel(tableData, tableHeaders));
    }

    private void ejecutaHQLConsulta5(String hql) {
        try {
            Session session = consultorait.util.HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query consulta = session.createQuery(hql);
            List resultList = consulta.list();
            mostrarResultados5(resultList);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    //Consulta 5: Empleados con salario menor que alguno de los empleados del departamento 20.
    private void mostrarResultados5(List resultList) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Apellido");
        tableHeaders.add("Salario");
        tableHeaders.add("Departamento No");

        for (Object o : resultList) {
            Empleados empleados = (Empleados) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(empleados.getApellido());
            oneRow.add(empleados.getSalario());
            oneRow.add(empleados.getDepartamentos().getDeptNo());

            tableData.add(oneRow);
        }
        tbResultado.setModel(new DefaultTableModel(tableData, tableHeaders));
    }
    
    
    private void ejecutaHQLConsulta6(String hql) {
        try {
            Session session = consultorait.util.HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query consulta = session.createQuery(hql);
            List resultList = consulta.list();
            mostrarResultados6(resultList);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    //Consulta 6: Mostrar nombre y total de empleados de aquellos departamentos con más de un empleado adscrito. Ordena el resultado por número de empleado.
    private void mostrarResultados6(List resultList) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Numero");
        tableHeaders.add("Apellido");
        tableHeaders.add("Salario");
        tableHeaders.add("Departamento No");

        for (Object o : resultList) {
            Empleados empleados = (Empleados) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(empleados.getEmpNo());
            oneRow.add(empleados.getApellido());
            oneRow.add(empleados.getSalario());
            oneRow.add(empleados.getDepartamentos().getDeptNo());

            tableData.add(oneRow);
        }
        tbResultado.setModel(new DefaultTableModel(tableData, tableHeaders));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultado = new javax.swing.JTable();
        btConsulta1 = new javax.swing.JButton();
        btConsulta2 = new javax.swing.JButton();
        btConsulta3 = new javax.swing.JButton();
        btConsulta4 = new javax.swing.JButton();
        btConsulta5 = new javax.swing.JButton();
        btConsulta6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("TAREA AD3");

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

        btConsulta1.setText("Consulta1");
        btConsulta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsulta1ActionPerformed(evt);
            }
        });

        btConsulta2.setText("Consulta2");
        btConsulta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsulta2ActionPerformed(evt);
            }
        });

        btConsulta3.setText("Consulta3");
        btConsulta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsulta3ActionPerformed(evt);
            }
        });

        btConsulta4.setText("Consulta4");
        btConsulta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsulta4ActionPerformed(evt);
            }
        });

        btConsulta5.setText("Consulta5");
        btConsulta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsulta5ActionPerformed(evt);
            }
        });

        btConsulta6.setText("Consulta6");
        btConsulta6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsulta6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(256, 256, 256)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btConsulta1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btConsulta2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btConsulta3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btConsulta4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btConsulta5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btConsulta6)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btConsulta2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btConsulta1)
                        .addComponent(btConsulta3)
                        .addComponent(btConsulta4)
                        .addComponent(btConsulta5)
                        .addComponent(btConsulta6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConsulta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsulta1ActionPerformed
        ejecutaConsulta1();
    }//GEN-LAST:event_btConsulta1ActionPerformed

    private void btConsulta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsulta2ActionPerformed
        ejecutaConsulta2();
    }//GEN-LAST:event_btConsulta2ActionPerformed

    private void btConsulta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsulta3ActionPerformed
        ejecutaConsulta3();
    }//GEN-LAST:event_btConsulta3ActionPerformed

    private void btConsulta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsulta4ActionPerformed
        ejecutaConsulta4();
    }//GEN-LAST:event_btConsulta4ActionPerformed

    private void btConsulta5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsulta5ActionPerformed
        ejecutaConsulta5();
    }//GEN-LAST:event_btConsulta5ActionPerformed

    private void btConsulta6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsulta6ActionPerformed
         ejecutaConsulta6();
    }//GEN-LAST:event_btConsulta6ActionPerformed

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
            java.util.logging.Logger.getLogger(PanelConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (java.lang.InstantiationException ex) {
            Logger.getLogger(PanelConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConsulta1;
    private javax.swing.JButton btConsulta2;
    private javax.swing.JButton btConsulta3;
    private javax.swing.JButton btConsulta4;
    private javax.swing.JButton btConsulta5;
    private javax.swing.JButton btConsulta6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbResultado;
    // End of variables declaration//GEN-END:variables

}
