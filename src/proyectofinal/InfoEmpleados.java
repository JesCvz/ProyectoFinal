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

public class InfoEmpleados extends javax.swing.JFrame {

   Connection con = null;
    Statement stmt = null;
    String titulos[] = {"Id","Nombre","Apellido Mat","Apellido Pat","Telefono","Email"};
    String fila[] = new String[6];
    DefaultTableModel modelo;
    SignupEmple1 SE= new SignupEmple1();
    
    public InfoEmpleados() {
        initComponents();
        this.setTitle("Empleados");
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
                ResultSet rs = stmt.executeQuery("Select* from empleados");
                
                modelo = new DefaultTableModel(null,titulos);
                while(rs.next()){
                    fila[0]=rs.getString("id_empleados");
                    fila[1]=rs.getString("Nombre");
                    fila[2]=rs.getString("Apellido_Paterno");
                    fila[3]=rs.getString("Apellido_Materno");
                    fila[4]=rs.getString("Telefono");
                    fila[5]=rs.getString("correo_electronico");
                    
                    modelo.addRow(fila);
                    
                }
                tabla_emp.setModel(modelo);
                TableColumn cm = tabla_emp.getColumn("Id");
                TableColumn cn = tabla_emp.getColumn("Nombre");
                TableColumn cd = tabla_emp.getColumn("Apellido Mat");
                TableColumn ct = tabla_emp.getColumn("Apellido Pat");
                TableColumn cb = tabla_emp.getColumn("Telefono");
                TableColumn ch = tabla_emp.getColumn("Email");
                
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
               Class.forName(LG.driver).newInstance();
                con = DriverManager.getConnection(url,usuario,contraseña);
                if(con!=null)
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Select* from empleados");
                
                modelo = new DefaultTableModel(null,titulos);
                while(rs.next()){
                    fila[0]=rs.getString("id_empleados");
                    fila[1]=rs.getString("Nombre");
                    fila[2]=rs.getString("Apellido_Paterno");
                    fila[3]=rs.getString("Apellido_Materno");
                    fila[4]=rs.getString("Telefono");
                    fila[5]=rs.getString("correo_electronico");
                    
                    modelo.addRow(fila);
                    
                }
                tabla_emp.setModel(modelo);
                TableColumn cm = tabla_emp.getColumn("Id");
                TableColumn cn = tabla_emp.getColumn("Nombre");
                TableColumn cd = tabla_emp.getColumn("Apellido Mat");
                TableColumn ct = tabla_emp.getColumn("Apellido Pat");
                TableColumn cb = tabla_emp.getColumn("Telefono");
                TableColumn ch = tabla_emp.getColumn("Email");
                
         }
         catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
             JOptionPane.showMessageDialog(null,"Error al extraer los datos de la tabla");
         }
        
    }
    
     public void consulta(){
       int fila = tabla_emp.getSelectedRow()+1;
        System.out.println(fila);
    
    
    
    if(fila==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe de seleccionar un registro","AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    
    
    else if (fila>=0) {
     
     try { 
         String valor = tabla_emp.getValueAt((fila-1), 0).toString();
            LoginNutriSoft LG = new LoginNutriSoft();
               String url = LG.url;
               String usuario = LG.usuario;
               String contraseña = LG.contraseña; 
               Class.forName(LG.driver).newInstance();
                  con = DriverManager.getConnection(url,usuario,contraseña); 
                  if ( con != null ) 
                    System.out.println("Se ha establecido una conexión a la base de datos " +  
                                       "\n " + url ); 
  
                  stmt = con.createStatement(); 
                  ResultSet rs = stmt.executeQuery("select* from empleados where id_empleados = '"+valor+"'");
                  System.out.println("id_empleados" + "");
                  while(rs.next())
                  {
                      idcliente.setText(rs.getString("id_empleados"));
                      System.out.println(rs.getString("id_empleados"));
                  }
                  
                  SignupEmple1.idcliente.setText(idcliente.getText());
                  if(SE.isVisible()==true)
                    {
                    SE.dispose();
                    SE.setVisible(true);
                    SE.consulta();
                    }
                    else
                    {
                    SE.setVisible(true);
                    SE.consulta();
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
        int fila = tabla_emp.getSelectedRow()+1;
        System.out.println(fila);
        
        if(fila==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe de seleccionar un registro","AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        
        else if(fila>=1){
            String valor = tabla_emp.getValueAt((fila-1), 0).toString();
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
                stmt.executeUpdate("DELETE FROM empleados WHERE id_empleados = '"+valor+"'");
                
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

        InfoEmpBg = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_emp = new javax.swing.JTable();
        EmployReg = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        EmployRmv = new javax.swing.JButton();
        Consultar = new javax.swing.JButton();
        idcliente = new javax.swing.JTextField();
        MenuEmployInfo = new javax.swing.JMenuBar();
        BackToMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());

        InfoEmpBg.setBackground(new java.awt.Color(255, 255, 255));

        tabla_emp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id_empleado", "Nombre", "A_paterno", "A_materno", "Telefono", "E-mail"
            }
        ));
        tabla_emp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabla_empKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tabla_empKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_emp);

        EmployReg.setText("Registrar");
        EmployReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployRegActionPerformed(evt);
            }
        });

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        EmployRmv.setText("Eliminar");
        EmployRmv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployRmvActionPerformed(evt);
            }
        });

        Consultar.setText("Consulta");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InfoEmpBgLayout = new javax.swing.GroupLayout(InfoEmpBg);
        InfoEmpBg.setLayout(InfoEmpBgLayout);
        InfoEmpBgLayout.setHorizontalGroup(
            InfoEmpBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoEmpBgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoEmpBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoEmpBgLayout.createSequentialGroup()
                        .addComponent(Actualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EmployReg)
                        .addGap(11, 11, 11)
                        .addComponent(Consultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EmployRmv)))
                .addContainerGap())
        );
        InfoEmpBgLayout.setVerticalGroup(
            InfoEmpBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoEmpBgLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(InfoEmpBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmployReg)
                    .addComponent(Actualizar)
                    .addComponent(EmployRmv)
                    .addComponent(Consultar))
                .addContainerGap())
        );

        BackToMenu.setText("Menu");
        MenuEmployInfo.add(BackToMenu);

        setJMenuBar(MenuEmployInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InfoEmpBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(344, 344, 344)
                    .addComponent(idcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(285, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InfoEmpBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(idcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(65, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EmployRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployRegActionPerformed
    SE.setVisible(true);       
    SE.limpiar();// TODO add your handling code here:
    }//GEN-LAST:event_EmployRegActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
    refresh();        // TODO add your handling code here:
    }//GEN-LAST:event_ActualizarActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
    consulta();        // TODO add your handling code here:
    }//GEN-LAST:event_ConsultarActionPerformed

    private void EmployRmvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployRmvActionPerformed
    borrar();        // TODO add your handling code here:
    }//GEN-LAST:event_EmployRmvActionPerformed

    private void tabla_empKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_empKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_empKeyTyped

    private void tabla_empKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_empKeyPressed
        int car = evt.getKeyCode();
        if(car==127)
        {
            borrar();
        }           // TODO add your handling code here:
    }//GEN-LAST:event_tabla_empKeyPressed

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
            java.util.logging.Logger.getLogger(InfoEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Actualizar;
    private javax.swing.JMenu BackToMenu;
    private javax.swing.JButton Consultar;
    private javax.swing.JButton EmployReg;
    private javax.swing.JButton EmployRmv;
    private javax.swing.JPanel InfoEmpBg;
    private javax.swing.JMenuBar MenuEmployInfo;
    public static javax.swing.JTextField idcliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_emp;
    // End of variables declaration//GEN-END:variables
}
