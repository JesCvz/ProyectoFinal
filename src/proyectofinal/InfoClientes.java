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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


/**
 *
 * @author strange
 */
public class InfoClientes extends javax.swing.JFrame {
    Connection con = null;
    Statement stmt = null;
    String titulos[] = {"Id","Nombre","Apellido Mat","Apellido Pat","Telefono","Email","Direccion"};
    String fila[] = new String[7];
    DefaultTableModel modelo;
    SignupClient SC= new SignupClient();

    /**
     * Creates new form InfoClientes
     */
    public InfoClientes() {
        initComponents();
        this.setTitle("Clientes");
        this.setResizable(false);
         try{
               LoginNutriSoft LG = new LoginNutriSoft();
               String url = LG.url;
               String usuario = LG.usuario;
               String contraseña = LG.contraseña; 
               Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                con = DriverManager.getConnection(url,usuario,contraseña);
                if(con!=null)
                    System.out.println("Se ha estableciso una conexion con la base de datos"+"\n"+url);
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Select* from pacientes");
                
                modelo = new DefaultTableModel(null,titulos);
                while(rs.next()){
                    fila[0]=rs.getString("id_paciente");
                    fila[1]=rs.getString("Nombre");
                    fila[2]=rs.getString("Apellido Paterno");
                    fila[3]=rs.getString("Apellido Materno");
                    fila[4]=rs.getString("Telefono");
                    fila[5]=rs.getString("correo electronico");
                    fila[6]=rs.getString("Dirección");
                    
                    modelo.addRow(fila);
                    
                }
                tabla_cli.setModel(modelo);
                TableColumn cm = tabla_cli.getColumn("Id");
                TableColumn cn = tabla_cli.getColumn("Nombre");
                TableColumn cd = tabla_cli.getColumn("Apellido Mat");
                TableColumn ct = tabla_cli.getColumn("Apellido Pat");
                TableColumn cb = tabla_cli.getColumn("Telefono");
                TableColumn ch = tabla_cli.getColumn("Email");
                TableColumn cr = tabla_cli.getColumn("Direccion");
                
         }
         catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
             JOptionPane.showMessageDialog(null,"Error al extraer los datos de la tabla");
         }
    }
    
    public void refresh(){
        try{
               LoginNutriSoft LG = new LoginNutriSoft();
               String url = LG.url;
               String usuario = LG.usuario;
               String contraseña = LG.contraseña; 
               Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                con = DriverManager.getConnection(url,usuario,contraseña);
                if(con!=null)
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Select* from pacientes");
                
                modelo = new DefaultTableModel(null,titulos);
                while(rs.next()){
                    fila[0]=rs.getString("id_paciente");
                    fila[1]=rs.getString("Nombre");
                    fila[2]=rs.getString("Apellido Paterno");
                    fila[3]=rs.getString("Apellido Materno");
                    fila[4]=rs.getString("Telefono");
                    fila[5]=rs.getString("correo electronico");
                    fila[6]=rs.getString("Dirección");
                    
                    modelo.addRow(fila);
                    
                }
                tabla_cli.setModel(modelo);
                TableColumn cm = tabla_cli.getColumn("Id");
                TableColumn cn = tabla_cli.getColumn("Nombre");
                TableColumn cd = tabla_cli.getColumn("Apellido Mat");
                TableColumn ct = tabla_cli.getColumn("Apellido Pat");
                TableColumn cb = tabla_cli.getColumn("Telefono");
                TableColumn ch = tabla_cli.getColumn("Email");
                TableColumn cr = tabla_cli.getColumn("Direccion");
                
         }
         catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
             JOptionPane.showMessageDialog(null,"");
         }
        
    }
    
    
    public void consulta(){
       int fila = tabla_cli.getSelectedRow()+1;
        System.out.println(fila);
    
    
    
    if(fila==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe de seleccionar un registro","AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    
    
    else if (fila>=0) {
     
     try { 
         String valor = tabla_cli.getValueAt((fila-1), 0).toString();
            LoginNutriSoft LG = new LoginNutriSoft();
               String url = LG.url;
               String usuario = LG.usuario;
               String contraseña = LG.contraseña; 
               Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                  con = DriverManager.getConnection(url,usuario,contraseña); 
                  if ( con != null ) 
                    System.out.println("Se ha establecido una conexión a la base de datos " +  
                                       "\n " + url ); 
  
                  stmt = con.createStatement(); 
                  ResultSet rs = stmt.executeQuery("select* from pacientes where id_paciente = '"+valor+"'");
                  
                  while(rs.next())
                  {
                      idcliente.setText(rs.getString("id_paciente"));
                      System.out.print(rs.getString("id_paciente"));
                  }
                  
                  SignupClient.idcliente.setText(idcliente.getText());
                  if(SC.isVisible()==true)
                    {
                    SC.dispose();
                    SC.setVisible(true);
                    SC.consulta();
                    }
                    else
                    {
                    SC.setVisible(true);
                    SC.consulta();
                    } 
                  } 
                  catch( SQLException e ) { 
                      e.printStackTrace(); 
                  } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
        } 
  
              finally { 
                  if ( con != null ) { 
                      try    { 
                          con.close(); 
                          stmt.close(); 
                      } catch( SQLException e ) { 
                          System.out.println( e.getMessage()); 
                      } 
                  } 
     }
    
     } 
    }
public void borrar(){
        InfoClientes Cl = new InfoClientes();
        int fila = tabla_cli.getSelectedRow()+1;
        System.out.println(fila);
        
        if(fila==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe de seleccionar un registro","AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        
        else if(fila>=1){
            String valor = tabla_cli.getValueAt((fila-1), 0).toString();
            try{
               LoginNutriSoft LG = new LoginNutriSoft();
               String url = LG.url;
               String usuario = LG.usuario;
               String contraseña = LG.contraseña; 
               Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                con = DriverManager.getConnection(url,usuario,contraseña);
                
                if(con != null)
                    System.out.println("Se ha establecido una conexion a la base de datos"+"\n"+url);
                stmt = con.createStatement();
                stmt.executeUpdate("DELETE FROM pacientes WHERE id_paciente = '"+valor+"'");
                
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

        InfoCBg = new javax.swing.JPanel();
        idcliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_cli = new javax.swing.JTable();
        ClientReg = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        ClientRmv1 = new javax.swing.JButton();
        Consultar = new javax.swing.JButton();
        MenuClientInfo = new javax.swing.JMenuBar();
        BackToMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabla_cli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id_paciente", "Nombre", "A_paterno", "A_materno", "Telefono", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_cli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabla_cliKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_cli);

        ClientReg.setText("Registrar");
        ClientReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientRegActionPerformed(evt);
            }
        });

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        ClientRmv1.setText("Eliminar");
        ClientRmv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientRmv1ActionPerformed(evt);
            }
        });

        Consultar.setText("Consultar");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InfoCBgLayout = new javax.swing.GroupLayout(InfoCBg);
        InfoCBg.setLayout(InfoCBgLayout);
        InfoCBgLayout.setHorizontalGroup(
            InfoCBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoCBgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoCBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoCBgLayout.createSequentialGroup()
                        .addGroup(InfoCBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InfoCBgLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(idcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Actualizar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ClientReg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Consultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClientRmv1)))
                .addContainerGap())
        );
        InfoCBgLayout.setVerticalGroup(
            InfoCBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoCBgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoCBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InfoCBgLayout.createSequentialGroup()
                        .addGroup(InfoCBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ClientReg)
                            .addComponent(ClientRmv1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Consultar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(InfoCBgLayout.createSequentialGroup()
                        .addComponent(idcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Actualizar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        BackToMenu.setText("Menu");
        MenuClientInfo.add(BackToMenu);

        setJMenuBar(MenuClientInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InfoCBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InfoCBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ClientRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientRegActionPerformed
        SC.setVisible(true);  
        SC.limpiar();
    }//GEN-LAST:event_ClientRegActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
    refresh();        // TODO add your handling code here:
    }//GEN-LAST:event_ActualizarActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
    consulta();       // TODO add your handling code here:
    }//GEN-LAST:event_ConsultarActionPerformed

    private void ClientRmv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientRmv1ActionPerformed
    borrar();        // TODO add your handling code here:
    }//GEN-LAST:event_ClientRmv1ActionPerformed

    private void tabla_cliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_cliKeyPressed
        int car = evt.getKeyCode();
        if(car==127)
        {
            borrar();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_tabla_cliKeyPressed

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
            java.util.logging.Logger.getLogger(InfoClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Actualizar;
    private javax.swing.JMenu BackToMenu;
    private javax.swing.JButton ClientReg;
    private javax.swing.JButton ClientRmv1;
    private javax.swing.JButton Consultar;
    private javax.swing.JPanel InfoCBg;
    private javax.swing.JMenuBar MenuClientInfo;
    public static javax.swing.JTextField idcliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_cli;
    // End of variables declaration//GEN-END:variables
}
