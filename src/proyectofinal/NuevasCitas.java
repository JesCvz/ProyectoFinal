/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Miguel Ruiz
 */
public class NuevasCitas extends javax.swing.JFrame {
    Connection con = null;
    Statement stmt = null;
    String titulos[] = {"Cita","ID_Paciente","Fecha"};
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String fila[] = new String[3];
    DefaultTableModel modelo;
    agregarclientes AC = new agregarclientes();
    /**
     * Creates new form NuevasCitas
     */
    public NuevasCitas() {
        initComponents();
        this.setTitle("Clientes");
        this.setResizable(false);
         try{
               LoginNutriSoft LG = new LoginNutriSoft();
               String url = LG.url;
               String usuario = LG.usuario;
               String contraseña = LG.contraseña; 
               Class.forName(LG.driver).newInstance();
                con = DriverManager.getConnection(url,usuario,contraseña);
                if(con!=null)
                    System.out.println("Se ha estableciso una conexion con la base de datos"+"\n"+url);
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Select* from citas");
                
                modelo = new DefaultTableModel(null,titulos);
                while(rs.next()){
                    fila[0]=rs.getString("id_citas");
                    fila[1]=rs.getString("pacientes_id");
                    fila[2]=rs.getString("Fecha");
                    modelo.addRow(fila);
                    
                }
                tabla_citas.setModel(modelo);
                TableColumn cm = tabla_citas.getColumn("Cita");
                TableColumn cn = tabla_citas.getColumn("ID_Paciente");
                TableColumn cd = tabla_citas.getColumn("Fecha");
                
         }
         catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
             JOptionPane.showMessageDialog(null,"Error al extraer los datos de la tabla");
         }
    }
public void registrar()
   {
       
       String cadena1, cadena2;
      cadena1 = sdf.format(txtfechaped.getDate()); //Nombre del empleado
      cadena2 = txtidcliente.getText();//Apellido Paterno
      
     if (cadena1.equals("") || (cadena2.equals(""))){
            
     javax.swing.JOptionPane.showMessageDialog(this,"Debe llenar todos los campos \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
     }
     
     else {
        try {
           
            LoginNutriSoft LG = new LoginNutriSoft();
            String url = LG.url;
            String usuario = LG.usuario;
            String contraseña = LG.contraseña; 
            System.out.print(url);
             Class.forName(LG.driver).newInstance(); 
             con = DriverManager.getConnection(url,usuario,contraseña); 
             if ( con != null ) 
                    System.out.println("Se ha establecido una conexión a la base de datos "); 
                  stmt = con.createStatement(); 
                        stmt.executeUpdate("INSERT INTO citas(`pacientes_id`, `Fecha`) VALUES('"+cadena2+"','"+cadena1+"')");
                        System.out.println("Los valores han sido agregados a la base de datos");
                        javax.swing.JOptionPane.showMessageDialog(this,"Registro exitoso! \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {}  
        
        finally {
            if (con != null) {
                try {
                    con.close();
                    stmt.close();
                } catch ( SQLException e ) { 
                         System.out.println( e.getMessage());
                }
            }
        }
         
        }
        this.txtidcliente.setText("");
        this.txtnomcliente.setText("");

        Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
            }
        };
        timer.schedule(tarea, 100);
      
      
   }
    public void refresh(){
        
        try{
               LoginNutriSoft LG = new LoginNutriSoft();
               String url = LG.url;
               String usuario = LG.usuario;
               String contraseña = LG.contraseña; 
               Class.forName(LG.driver).newInstance();
                con = DriverManager.getConnection(url,usuario,contraseña);
                if(con!=null)
                    System.out.println("Se ha estableciso una conexion con la base de datos"+"\n"+url);
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Select* from citas");
                
                modelo = new DefaultTableModel(null,titulos);
                while(rs.next()){
                    fila[0]=rs.getString("id_citas");
                    fila[1]=rs.getString("pacientes_id");
                    fila[2]=rs.getString("Fecha");
                    modelo.addRow(fila);
                    
                }
                tabla_citas.setModel(modelo);
                TableColumn cm = tabla_citas.getColumn("Cita");
                TableColumn cn = tabla_citas.getColumn("ID_Paciente");
                TableColumn cd = tabla_citas.getColumn("Fecha");
                
         }
         catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
             JOptionPane.showMessageDialog(null,"Error al extraer los datos de la tabla");
         }
        
    }
    
    public void borrar(){
        int fila = tabla_citas.getSelectedRow()+1;
        System.out.println(fila);
        
        if(fila==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe de seleccionar un registro","AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        
        else if(fila>=1){
            String valor = tabla_citas.getValueAt((fila-1), 0).toString();
            try{
               LoginNutriSoft LG = new LoginNutriSoft();
               String url = LG.url;
               String usuario = LG.usuario;
               String contraseña = LG.contraseña; 
               Class.forName(LG.driver).newInstance();
                con = DriverManager.getConnection(url,usuario,contraseña);
                
                if(con != null)
                    System.out.println("Se ha establecido una conexion a la base de datos"+"\n"+url);
                stmt = con.createStatement();
                stmt.executeUpdate("DELETE FROM citas WHERE id_citas = '"+valor+"'");
                
                System.out.println("El registro fue eliminado");
                
            }
            catch ( SQLException e){
                e.printStackTrace();
            }
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            }
            finally{
                if(con != null){
                    try{
                        con.close();
                        stmt.close();
                    }catch(SQLException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
            javax.swing.JOptionPane.showMessageDialog(this, "El registro fue eliminado!","AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            refresh();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_citas = new javax.swing.JTable();
        Logo = new javax.swing.JLabel();
        txtfechaped = new com.toedter.calendar.JCalendar();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        btnAgendar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        id_cliente_agregar = new javax.swing.JButton();
        txtidcliente = new javax.swing.JTextField();
        txtnomcliente = new javax.swing.JTextField();
        Actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabla_citas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id_citas", "Id_paciente", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_citas);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoYL.png"))); // NOI18N

        txtfechaped.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("MS PGothic", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Agenda de Citas");

        btnAgendar.setText("Agendar");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        jButton1.setText("Eliminar Cita");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnmenu.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.setFocusable(false);

        id_cliente_agregar.setText("Agregar Cliente");
        id_cliente_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_cliente_agregarActionPerformed(evt);
            }
        });

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Logo)
                        .addGap(169, 169, 169)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtfechaped, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtnomcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(47, 47, 47))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(id_cliente_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(83, 83, 83)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Logo)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfechaped, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(id_cliente_agregar)
                                .addGap(18, 18, 18)
                                .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtnomcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnAgendar)
                    .addComponent(Actualizar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
    registrar();
    refresh();
    // TODO add your handling code here:
    }//GEN-LAST:event_btnAgendarActionPerformed

    private void id_cliente_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_cliente_agregarActionPerformed
    AC.setVisible(true);           // TODO add your handling code here:
    }//GEN-LAST:event_id_cliente_agregarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_ActualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    borrar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(NuevasCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevasCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevasCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevasCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevasCitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JLabel Logo;
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton id_cliente_agregar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabla_citas;
    private com.toedter.calendar.JCalendar txtfechaped;
    public static javax.swing.JTextField txtidcliente;
    public static javax.swing.JTextField txtnomcliente;
    // End of variables declaration//GEN-END:variables
}
