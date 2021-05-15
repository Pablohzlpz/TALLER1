/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallermecanico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tuito
 */
public class vehiculo extends javax.swing.JFrame {
Object datos [][]={};
String titulo []={"Matricula","Marca","Modelo"};
public static DefaultTableModel md;
int filasel=-1;
    /**
     * Creates new form vehiculo
     */
    public vehiculo() {
        initComponents();
        md= new DefaultTableModel(datos,titulo);
        tbVehiculos.setModel(md);
        MostrarDatos();
        btnGuardar.setVisible(false);
    }
    public void limpia(){
        int a = tbVehiculos.getRowCount()-1;
        for (int i = a; i >= 0; i--) {
            md.removeRow(md.getRowCount()-1);
        }
        txtmat2.setText("");
        txtmar.setText("");
        txtmod.setText("");
        txtdni.setText("");
           
    }
    public void MostrarDatos(){
        try{
           java.sql.PreparedStatement ps = null;
           ResultSet rs = null;
           testCon conn = new testCon();
           java.sql.Connection con = conn.gettestCon();
           
           String sql = "SELECT `Matricula`,`Marca`,`Modelo` FROM `vehículo` WHERE 1 ";
           ps =con.prepareStatement(sql);
           rs=ps.executeQuery();
           while(rs.next()){
               md.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
           }
        } catch (SQLException ex) {
            System.out.println(ex );
        }   
        
    }
    public void ConsultarVehiculo(){
        int valida=0;
        String v ="", v2="";
        if (txtmat.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null,"Ingrese una matricula");
        }else{
         try{
           java.sql.PreparedStatement ps = null;
           ResultSet rs = null;
           testCon conn = new testCon();
           java.sql.Connection con = conn.gettestCon();
           
           String sql = "SELECT `Matricula`,`Marca`,`Modelo` FROM `vehículo` WHERE `Matricula`='"+txtmat.getText()+"'";
           ps =con.prepareStatement(sql);
           rs=ps.executeQuery();
           while(rs.next()){
               valida=1;
               System.out.println("vehículo"); 
               JOptionPane.showMessageDialog(null,String.valueOf(rs.getString(1))+" "+String.valueOf(rs.getString(2))+" "+String.valueOf(rs.getString(3)));
               v=String.valueOf(rs.getString(1));
           }
        } catch (SQLException ex) {
            System.out.println(ex );
        }   
        }
         if (valida<=0) {
            JOptionPane.showMessageDialog(null,"No se encontro la matricula");
        }
         for (int i = 0; i <tbVehiculos.getRowCount(); i++) {
                v2=tbVehiculos.getValueAt(i,0).toString();
             if (v.equalsIgnoreCase(v2)) {
                 tbVehiculos.changeSelection(i, 1,false,false);
             }
        }
    }
    public void Ingresa(){
        PreparedStatement ps = null;
        testCon con = new testCon();
        Connection conn = con.gettestCon();
        String sql="INSERT INTO `vehículo` (`Matricula`, `Marca`, `Modelo`, `DNI`) VALUES ('"+txtmat2.getText()+"','"+txtmar.getText()+"','"+txtmod.getText()+"','"+txtdni.getText()+"');";
        System.out.println(sql);
        try{
        ps = conn.prepareStatement(sql);
        ps.execute();
    }catch(SQLException e){
        System.out.println(e);
    }
    limpia();
    MostrarDatos();
    }
    public void elimina(){
        filasel=tbVehiculos.getSelectedRow();
        if (filasel<=-1) {
            JOptionPane.showMessageDialog(null,"Seleccione un vehiculo");
        }else{
        filasel=tbVehiculos.getSelectedRow();
        int valor = JOptionPane.showConfirmDialog(null,"Esta seguro que desea eliminar este vehiculo?");
        if (valor==JOptionPane.YES_OPTION) {
        PreparedStatement ps = null;
        testCon con = new testCon();
        Connection conn = con.gettestCon();
        String sql="DELETE FROM `vehículo` WHERE `vehículo`.`Matricula` = '"+tbVehiculos.getValueAt(filasel,0)+"'";
        System.out.println(sql);
        try{
        ps = conn.prepareStatement(sql);
        ps.execute();
    }catch(SQLException e){
        System.out.println(e);
    }
    limpia();
    MostrarDatos();    
        }    
        }    
    }
    public void modifica(){
        filasel=tbVehiculos.getSelectedRow();
        if (filasel<=-1) {
            JOptionPane.showMessageDialog(null,"Seleccione un vehiculo");
        }else{
        filasel=tbVehiculos.getSelectedRow();
        int valor = JOptionPane.showConfirmDialog(null,"Esta seguro que desea modificar este vehiculo?");
        if (valor==JOptionPane.YES_OPTION) {
        PreparedStatement ps = null;
        testCon con = new testCon();
        Connection conn = con.gettestCon();
        String sql="UPDATE `vehículo` SET `Matricula` = '"+txtmat2.getText()+"', `Marca` = '"+txtmar.getText()+"', `Modelo` = '"+txtmod.getText()+"' WHERE `vehículo`.`Matricula` = '"+tbVehiculos.getValueAt(filasel,0)+"';";
        System.out.println(sql);
        try{
        ps = conn.prepareStatement(sql);
        ps.execute();
    }catch(SQLException e){
        System.out.println(e);
    }
    limpia();
    MostrarDatos();    
        }    
        }
        txtdni.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVehiculos = new javax.swing.JTable();
        txtmat = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtmat2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtmar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtmod = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Matricula", "Marca", "Modelo"
            }
        ));
        jScrollPane1.setViewportView(tbVehiculos);

        jLabel1.setText("Matricula");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel2.setText("VEHICULOS");

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ingresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("Matricula");

        jLabel4.setText("Marca");

        jLabel5.setText("Modelo");

        jLabel6.setText("DNI");

        btnGuardar.setText("Guardar Cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtmar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtmat2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtmod, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(txtmat, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnGuardar))
                            .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton4)
                            .addComponent(jButton3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtmat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtmod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardar)
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConsultarVehiculo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       Ingresa();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    elimina();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       filasel=tbVehiculos.getSelectedRow();
        if (filasel<=-1) {
            JOptionPane.showMessageDialog(null,"Seleccione un vehiculo");
        }else{
    btnGuardar.setVisible(true);
    txtdni.setVisible(false);
    txtmat2.setText(tbVehiculos.getValueAt(tbVehiculos.getSelectedRow(),0).toString());
    txtmar.setText(tbVehiculos.getValueAt(tbVehiculos.getSelectedRow(),1).toString());
    txtmod.setText(tbVehiculos.getValueAt(tbVehiculos.getSelectedRow(),2).toString());        
        }
    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       modifica();
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbVehiculos;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtmar;
    private javax.swing.JTextField txtmat;
    private javax.swing.JTextField txtmat2;
    private javax.swing.JTextField txtmod;
    // End of variables declaration//GEN-END:variables
}
