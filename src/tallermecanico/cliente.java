/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallermecanico;

import java.awt.Toolkit;
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
public class cliente extends javax.swing.JFrame {
Object datos [][]={};
String titulo []={"Nombre","Apellido","DNI","Telefono","Dirección"};
public static DefaultTableModel md;
int filasel=-1;
    /**
     * Creates new form vehiculo
     */
    public cliente() {
        initComponents();
        md= new DefaultTableModel(datos,titulo);
        tbclientes.setModel(md);
        MostrarDatos();
        btnGuardar.setVisible(false);
    }
    public void limpia(){
        int a = tbclientes.getRowCount()-1;
        for (int i = a; i >= 0; i--) {
            md.removeRow(md.getRowCount()-1);
        }
        txtnom.setText("");
        txtape.setText("");
        txttel.setText("");
        txtdni.setText("");
        txtdir.setText("");
           
    }
    public void MostrarDatos(){
        try{
           java.sql.PreparedStatement ps = null;
           ResultSet rs = null;
           testCon conn = new testCon();
           java.sql.Connection con = conn.gettestCon();
           
           String sql = "SELECT `Nombre`,`Apellido`,`DNI`,`Telefono`,`Domicilio` FROM `cliente` WHERE 1 ";
           ps =con.prepareStatement(sql);
           rs=ps.executeQuery();
           while(rs.next()){
               md.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
           }
        } catch (SQLException ex) {
            System.out.println(ex );
        }   
        
    }
    public void Consultarcliente(){
        int valida=0;
        String v ="", v2="";
        if (txtdni1.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null,"Ingrese DNI");
        }else{
         try{
           java.sql.PreparedStatement ps = null;
           ResultSet rs = null;
           testCon conn = new testCon();
           java.sql.Connection con = conn.gettestCon();
           
           String sql = "SELECT `Nombre`,`Apellido`,`DNI`,`Telefono`,`Domicilio` FROM `cliente` WHERE DNI = '"+txtdni1.getText()+"'"  ;
             System.out.println(sql);
           ps =con.prepareStatement(sql);
           rs=ps.executeQuery();
           while(rs.next()){
               valida=1;
               System.out.println("vehículo"); 
               JOptionPane.showMessageDialog(null,String.valueOf(rs.getString(1))+" "+String.valueOf(rs.getString(2))+" "+String.valueOf(rs.getString(3))+" "+String.valueOf(rs.getString(4))+" "+String.valueOf(rs.getString(5)));
               v=String.valueOf(rs.getString(1));
           }
        } catch (SQLException ex) {
            System.out.println(ex );
        }   
        }
         if (valida<=0) {
            JOptionPane.showMessageDialog(null,"No se encontro la matricula");
        }
         for (int i = 0; i <tbclientes.getRowCount(); i++) {
                v2=tbclientes.getValueAt(i,0).toString();
             if (v.equalsIgnoreCase(v2)) {
                 tbclientes.changeSelection(i, 1,false,false);
             }
        }
    }
    public void Agregar(){
        PreparedStatement ps = null;
        testCon con = new testCon();
        Connection conn = con.gettestCon();
        String sql="INSERT INTO `cliente` (`Nombre`, `Apellido`, `DNI`, `Telefono`,`Domicilio`) VALUES ('"+txtnom.getText()+"','"+txtape.getText()+"','"+txtdni.getText()+"','"+txttel.getText()+"','"+txtdir.getText()+"');";
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
        filasel=tbclientes.getSelectedRow();
        if (filasel<=-1) {
            JOptionPane.showMessageDialog(null,"Seleccione un cliente");
        }else{
        filasel=tbclientes.getSelectedRow();
        int valor = JOptionPane.showConfirmDialog(null,"Esta seguro que desea eliminar este cliente?");
        if (valor==JOptionPane.YES_OPTION) {
        PreparedStatement ps = null;
        testCon con = new testCon();
        Connection conn = con.gettestCon();
        String sql="DELETE FROM `cliente` WHERE `cliente`.`DNI` = '"+tbclientes.getValueAt(filasel,2)+"'";
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
        filasel=tbclientes.getSelectedRow();
        if (filasel<=-1) {
            JOptionPane.showMessageDialog(null,"Seleccione un Cliente");
        }else{
        filasel=tbclientes.getSelectedRow();
        int valor = JOptionPane.showConfirmDialog(null,"Esta seguro que desea modificar este cliente?");
        if (valor==JOptionPane.YES_OPTION) {
        PreparedStatement ps = null;
        testCon con = new testCon();
        Connection conn = con.gettestCon();
        String sql="UPDATE `cliente` SET `DNI` = '"+txtdni.getText()+"', `Nombre` = '"+txtnom.getText()+"', `Apellido` = '"+txtape.getText()+"',`Telefono` = '"+txttel.getText()+"',`Domicilio` = '"+txtdir.getText()+"' WHERE `cliente`.`DNI` = '"+tbclientes.getValueAt(filasel,2)+"';";
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
        tbclientes = new javax.swing.JTable();
        txtdni1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtape = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txttel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        txtdir = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Telefono", "Dirrección"
            }
        ));
        jScrollPane1.setViewportView(tbclientes);

        txtdni1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdni1ActionPerformed(evt);
            }
        });

        jLabel1.setText("dni");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel2.setText("CLIENTES");

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Agregar");
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

        jLabel3.setText("Nombre");

        txtnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomActionPerformed(evt);
            }
        });
        txtnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnomKeyTyped(evt);
            }
        });

        jLabel4.setText("Apellido");

        txtape.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapeKeyTyped(evt);
            }
        });

        jLabel5.setText("Telefono");

        txttel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelKeyTyped(evt);
            }
        });

        jLabel6.setText("DNI");

        txtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdniKeyTyped(evt);
            }
        });

        btnGuardar.setText("Guardar Cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtdir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdirActionPerformed(evt);
            }
        });

        jLabel7.setText("Dirección");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
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
                                .addComponent(txtape, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(txtdni1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnGuardar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdni1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
        Consultarcliente();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       Agregar ();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    elimina();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       filasel=tbclientes.getSelectedRow();
        if (filasel<=-1) {
            JOptionPane.showMessageDialog(null,"Seleccione un vehiculo");
        }else{
    btnGuardar.setVisible(true);
    txtnom.setText(tbclientes.getValueAt(tbclientes.getSelectedRow(),0).toString());
    txtape.setText(tbclientes.getValueAt(tbclientes.getSelectedRow(),1).toString());
    txttel.setText(tbclientes.getValueAt(tbclientes.getSelectedRow(),3).toString());   
    txtdni.setText(tbclientes.getValueAt(tbclientes.getSelectedRow(),2).toString()); 
    txtdir.setText(tbclientes.getValueAt(tbclientes.getSelectedRow(),4).toString()); 
        }
    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       modifica();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtdirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdirActionPerformed

    private void txtdni1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdni1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdni1ActionPerformed

    private void txtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyTyped
        // TODO add your handling code here:
       
        if(txtdni.getText() .length() >= 4){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtdniKeyTyped

    private void txtnomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomKeyTyped
        // TODO add your handling code here:
        char validar=evt.getKeyChar();
        
        if(Character.isDigit(validar)){
            getToolkit().beep();
            
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Letras");
        }
    }//GEN-LAST:event_txtnomKeyTyped

    private void txtapeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapeKeyTyped
        // TODO add your handling code here:
         char validar=evt.getKeyChar();
        
        if(Character.isDigit(validar)){
            getToolkit().beep();
            
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Letras");
        }
    }//GEN-LAST:event_txtapeKeyTyped

    private void txttelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelKeyTyped
        // TODO add your handling code here:
         char validar=evt.getKeyChar();
        
        if(Character.isLetter(validar)){
            getToolkit().beep();
            
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Números");
        }
    }//GEN-LAST:event_txttelKeyTyped

    private void txtnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtnomActionPerformed

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
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cliente().setVisible(true);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbclientes;
    private javax.swing.JTextField txtape;
    private javax.swing.JTextField txtdir;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtdni1;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables
}
