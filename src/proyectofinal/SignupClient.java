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
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author strange
 */
public class SignupClient extends javax.swing.JFrame {
    Connection con =null;
    Statement stmt =null;
    String var,var2;


    /**
     * Creates new form SignupClient
     */
    public SignupClient() {
        initComponents();
        this.setTitle("Registro Clientes");
        this.setResizable(false);
    }
    
    public void registrar()
   {
       
       String cadena1, cadena2, cadena3, cadena4,cadena5,cadena6,cadena7;    
      cadena1 = NameTxtFieldClient.getText(); //Nombre del empleado
      cadena2 = LastnPaTxtFieldClient.getText();//Apellido Paterno
      cadena3 = LastnMaTxtFieldClient.getText();//Apellido Materno
      cadena4 = PhoneTxtFieldClient.getText();//Telefono del empleado
      cadena5 = EmailTxtFieldClient.getText();//Correo del empleado
      cadena6 = CityTxtFieldClient.getText();//Ciudad donde reside el cliente

     if (cadena1.equals("") || (cadena2.equals("")) || (cadena3.equals("")) || (cadena4.equals("")) || (cadena5.equals("")) || (cadena6.equals(""))){
            
     javax.swing.JOptionPane.showMessageDialog(this,"Debe llenar todos los campos \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
     }
     
     else {
        try {
           
            LoginNutriSoft LG = new LoginNutriSoft();
            String url = LG.url;
            String usuario = LG.usuario;
            String contraseña = LG.contraseña; 
            System.out.print(url);
             Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); 
             con = DriverManager.getConnection(url,usuario,contraseña); 
             if ( con != null ) 
                    System.out.println("Se ha establecido una conexión a la base de datos "); 
                  stmt = con.createStatement(); 
                        stmt.executeUpdate("INSERT INTO pacientes(`Nombre`, `Apellido Paterno`, `Apellido Materno`, `Telefono`, `correo electronico`, `Dirección`) VALUES('"+cadena1+"','"+cadena2+"','"+cadena3+"','"+cadena4+"','"+cadena5+"','"+cadena6+"')");
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
        this.NameTxtFieldClient.setText("");
        this.LastnPaTxtFieldClient.setText("");
        this.LastnMaTxtFieldClient.setText("");
        this.PhoneTxtFieldClient.setText("");  
        this.EmailTxtFieldClient.setText("");
        this.CityTxtFieldClient.setText("");
        Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
            InfoClientes.Actualizar.doClick();
            }
        };
        timer.schedule(tarea, 100);
      
      
   }
    
    public void consulta(){
         String cap="";
        ResultSet rs = null;
        var2 = idcliente.getText();
        String sql2 = "Select `id_paciente`,`Nombre`, `Apellido Paterno`, `Apellido Materno`, `Telefono`, `correo electronico`, `Dirección`  FROM pacientes where `id_paciente` = '"+var2+"'";
        
        try{
            LoginNutriSoft LG = new LoginNutriSoft();
               String url = LG.url;
               String usuario = LG.usuario;
               String contraseña = LG.contraseña; 
               Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        con = DriverManager.getConnection(url,usuario,contraseña);
        if(con != null)
            System.out.println("Se ha establicido una conexión a la base de datos"+"\n"+url);
        
        stmt = con.createStatement();
        rs = stmt.executeQuery(sql2);
        
        int i=1;
        if(!rs.next())
        {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontro ningun registro","AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        rs = stmt.executeQuery(sql2);
            while(rs.next()){
                String id = rs.getString("id_paciente");
                String ino = rs.getString("Nombre");
                String iap = rs.getString("Apellido Paterno");
                String iam = rs.getString("Apellido Materno");
                String it = rs.getString("Telefono");
                String ie = rs.getString("correo electronico");
                String idir = rs.getString("Dirección");
                System.out.println("Sitio Web"+(i++)+"\n"
                +id+"\n"
                +ino+"\n"
                +iap+"\n"
                +iam+"\n"
                +it+"\n"
                +ie+"\n"
                +idir+"\n"
                );
                
                NameTxtFieldClient.setText(ino);
                NameTxtFieldClient.setText(ino);
                LastnPaTxtFieldClient.setText(iap);
                LastnMaTxtFieldClient.setText(iam);
                PhoneTxtFieldClient.setText(it);
                EmailTxtFieldClient.setText(ie);
                CityTxtFieldClient.setText(idir);
                IDTxtFieldClient.setText(id);
                
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        catch(InstantiationException|IllegalAccessException|ClassNotFoundException ex){
        }
        finally{
            if(rs != null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            }
            if(stmt != null){
                try{
                    stmt.close();
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                }
            }
            if(con != null){
                try{
                    con.close();
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }
    }
       public void actualizar() {
        
       String cadena1, cadena2, cadena3, cadena4,cadena5,cadena6,cadena7;    
      cadena1 = NameTxtFieldClient.getText(); //Nombre del empleado
      cadena2 = LastnPaTxtFieldClient.getText();//Apellido Paterno
      cadena3 = LastnMaTxtFieldClient.getText();//Apellido Materno
      cadena4 = PhoneTxtFieldClient.getText();//Telefono del empleado
      cadena5 = EmailTxtFieldClient.getText();//Correo del empleado
      cadena6 = CityTxtFieldClient.getText();//Ciudad donde reside el cliente
     
    
     if (NameTxtFieldClient.getText().equals("")) {
         
         javax.swing.JOptionPane.showMessageDialog(this,"1-. Consulte el numero del empleado\n 2-. Actualice el dato deseado en el campo correspondiente","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
     }
     else {   
     
     try { 
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
                  ResultSet rs = stmt.executeQuery("select* from pacientes where id_paciente = '"+IDTxtFieldClient.getText()+"'");
                  if(rs.next()==false)
                  {
                      javax.swing.JOptionPane.showMessageDialog(this,"No existe un registro con ese numero de empleado!","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                  }
                  else
                  {
                  stmt.executeUpdate("update ignore pacientes set `Nombre` = '"+cadena1+"',`Apellido Paterno` = '"+cadena2+"', `Apellido Materno` = '"+cadena3+"', Telefono = '"+cadena4+"', `correo electronico` = '"+cadena5+"', Dirección = '"+cadena6+"' where id_paciente = '"+IDTxtFieldClient.getText()+"' "); 
                  System.out.println("Los valores han sido Actualizados"); 
                  javax.swing.JOptionPane.showMessageDialog(this,"Actualizado correctamente!","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
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
                      } catch( Exception e ) { 
                          System.out.println( e.getMessage()); 
                      } 
                  } 
     }
     
     } 
        limpiar();
        Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
            InfoClientes.Actualizar.doClick();
            }
        };
        timer.schedule(tarea, 100);
    }
    
    public void limpiar(){
    NameTxtFieldClient.setText("");
    NameTxtFieldClient.setText("");
    LastnPaTxtFieldClient.setText("");
    LastnMaTxtFieldClient.setText("");
    PhoneTxtFieldClient.setText("");
    EmailTxtFieldClient.setText("");
    CityTxtFieldClient.setText("");  
    IDTxtFieldClient.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HeaderRegClient = new javax.swing.JPanel();
        TitleRegClient = new javax.swing.JLabel();
        PanelRegClient = new javax.swing.JPanel();
        NameRegClient = new javax.swing.JLabel();
        LastnPaClient = new javax.swing.JLabel();
        LastMaClient = new javax.swing.JLabel();
        PhoneClient = new javax.swing.JLabel();
        EmailClient = new javax.swing.JLabel();
        CityClient = new javax.swing.JLabel();
        NameTxtFieldClient = new javax.swing.JTextField();
        LastnPaTxtFieldClient = new javax.swing.JTextField();
        LastnMaTxtFieldClient = new javax.swing.JTextField();
        PhoneTxtFieldClient = new javax.swing.JTextField();
        EmailTxtFieldClient = new javax.swing.JTextField();
        CityTxtFieldClient = new javax.swing.JTextField();
        IDTxtFieldClient = new javax.swing.JTextField();
        RegClient = new javax.swing.JButton();
        UpdateClient = new javax.swing.JButton();
        NameRegClient1 = new javax.swing.JLabel();
        bgColor = new javax.swing.JLabel();
        Consulta = new javax.swing.JButton();
        idcliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeaderRegClient.setBackground(new java.awt.Color(255, 255, 255));

        TitleRegClient.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        TitleRegClient.setText("REGISTRO DE CLIENTES");

        javax.swing.GroupLayout HeaderRegClientLayout = new javax.swing.GroupLayout(HeaderRegClient);
        HeaderRegClient.setLayout(HeaderRegClientLayout);
        HeaderRegClientLayout.setHorizontalGroup(
            HeaderRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderRegClientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleRegClient)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        HeaderRegClientLayout.setVerticalGroup(
            HeaderRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderRegClientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleRegClient)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(HeaderRegClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 240, 40));

        PanelRegClient.setBackground(new java.awt.Color(255, 255, 255));

        NameRegClient.setText("Nombre:");

        LastnPaClient.setText("Apellido paterno:");

        LastMaClient.setText("Apellido materno:");

        PhoneClient.setText("Celular:");

        EmailClient.setText("Email:");

        CityClient.setText("Ciudad:");

        EmailTxtFieldClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailTxtFieldClientActionPerformed(evt);
            }
        });

        IDTxtFieldClient.setEditable(false);
        IDTxtFieldClient.setBackground(new java.awt.Color(255, 255, 255));

        RegClient.setText("Registrar");
        RegClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegClientActionPerformed(evt);
            }
        });

        UpdateClient.setText("Actualizar");
        UpdateClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateClientActionPerformed(evt);
            }
        });

        NameRegClient1.setText("ID:");

        javax.swing.GroupLayout PanelRegClientLayout = new javax.swing.GroupLayout(PanelRegClient);
        PanelRegClient.setLayout(PanelRegClientLayout);
        PanelRegClientLayout.setHorizontalGroup(
            PanelRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegClientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelRegClientLayout.createSequentialGroup()
                        .addGroup(PanelRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NameRegClient)
                            .addComponent(LastnPaClient)
                            .addComponent(LastMaClient)
                            .addComponent(EmailClient)
                            .addComponent(PhoneClient))
                        .addGap(45, 45, 45)
                        .addGroup(PanelRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelRegClientLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(PanelRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NameTxtFieldClient, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(LastnPaTxtFieldClient)
                                    .addComponent(LastnMaTxtFieldClient)
                                    .addComponent(PhoneTxtFieldClient)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegClientLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(EmailTxtFieldClient, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelRegClientLayout.createSequentialGroup()
                        .addGroup(PanelRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CityClient)
                            .addComponent(NameRegClient1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IDTxtFieldClient, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CityTxtFieldClient, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(PanelRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateClient, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(RegClient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        PanelRegClientLayout.setVerticalGroup(
            PanelRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegClientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegClientLayout.createSequentialGroup()
                        .addGroup(PanelRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameRegClient)
                            .addComponent(NameTxtFieldClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LastnPaClient)
                            .addComponent(LastnPaTxtFieldClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelRegClientLayout.createSequentialGroup()
                        .addComponent(UpdateClient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RegClient)))
                .addGap(17, 17, 17)
                .addGroup(PanelRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LastnMaTxtFieldClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LastMaClient))
                .addGap(21, 21, 21)
                .addGroup(PanelRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PhoneTxtFieldClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PhoneClient))
                .addGap(18, 18, 18)
                .addGroup(PanelRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailTxtFieldClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailClient))
                .addGap(18, 18, 18)
                .addGroup(PanelRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CityTxtFieldClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CityClient))
                .addGap(18, 18, 18)
                .addGroup(PanelRegClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDTxtFieldClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameRegClient1))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        getContentPane().add(PanelRegClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 450, 350));

        bgColor.setBackground(new java.awt.Color(255, 255, 255));
        bgColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/white-background-2.jpg"))); // NOI18N
        getContentPane().add(bgColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 390));

        Consulta.setText("Consulta");
        Consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaActionPerformed(evt);
            }
        });
        getContentPane().add(Consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        idcliente.setEditable(false);
        getContentPane().add(idcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EmailTxtFieldClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailTxtFieldClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailTxtFieldClientActionPerformed

    private void RegClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegClientActionPerformed
        registrar();  

    // TODO add your handling code here:
    }//GEN-LAST:event_RegClientActionPerformed

    private void ConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConsultaActionPerformed

    private void UpdateClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateClientActionPerformed
    actualizar();        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateClientActionPerformed

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
            java.util.logging.Logger.getLogger(SignupClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CityClient;
    public javax.swing.JTextField CityTxtFieldClient;
    public static javax.swing.JButton Consulta;
    private javax.swing.JLabel EmailClient;
    public javax.swing.JTextField EmailTxtFieldClient;
    private javax.swing.JPanel HeaderRegClient;
    public javax.swing.JTextField IDTxtFieldClient;
    private javax.swing.JLabel LastMaClient;
    public javax.swing.JTextField LastnMaTxtFieldClient;
    private javax.swing.JLabel LastnPaClient;
    public javax.swing.JTextField LastnPaTxtFieldClient;
    private javax.swing.JLabel NameRegClient;
    private javax.swing.JLabel NameRegClient1;
    public javax.swing.JTextField NameTxtFieldClient;
    private javax.swing.JPanel PanelRegClient;
    private javax.swing.JLabel PhoneClient;
    public javax.swing.JTextField PhoneTxtFieldClient;
    private javax.swing.JButton RegClient;
    private javax.swing.JLabel TitleRegClient;
    private javax.swing.JButton UpdateClient;
    private javax.swing.JLabel bgColor;
    public static javax.swing.JTextField idcliente;
    // End of variables declaration//GEN-END:variables
}
