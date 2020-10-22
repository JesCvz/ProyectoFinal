/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 * @author strange
 */
public class LoginNutriSoft extends javax.swing.JFrame {

    /**
     * Creates new form LoginNutriSoft
     */
    public LoginNutriSoft() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogoLogin = new javax.swing.JLabel();
        bgColor = new javax.swing.JLabel();
        bgLogin = new javax.swing.JPanel();
        UserTxtField = new javax.swing.JTextField();
        PassTxtField = new javax.swing.JPasswordField();
        UserTxt = new javax.swing.JLabel();
        PassTxt = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton();
        SignupBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoOfLogin.png"))); // NOI18N
        getContentPane().add(LogoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 150, 121));

        bgColor.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(bgColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        bgLogin.setBackground(new java.awt.Color(255, 255, 255));

        UserTxt.setText("Usuario:");

        PassTxt.setText("Contraseña:");

        LoginBtn.setText("Ingresar");

        SignupBtn.setText("Registrarse");

        javax.swing.GroupLayout bgLoginLayout = new javax.swing.GroupLayout(bgLogin);
        bgLogin.setLayout(bgLoginLayout);
        bgLoginLayout.setHorizontalGroup(
            bgLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLoginLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(bgLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SignupBtn)
                    .addComponent(LoginBtn)
                    .addGroup(bgLoginLayout.createSequentialGroup()
                        .addGroup(bgLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UserTxt)
                            .addComponent(PassTxt))
                        .addGap(18, 18, 18)
                        .addGroup(bgLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UserTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(PassTxtField))))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        bgLoginLayout.setVerticalGroup(
            bgLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLoginLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(bgLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserTxt))
                .addGap(18, 18, 18)
                .addGroup(bgLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PassTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PassTxt))
                .addGap(18, 18, 18)
                .addComponent(LoginBtn)
                .addGap(18, 18, 18)
                .addComponent(SignupBtn)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(bgLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 400, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LoginNutriSoft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginNutriSoft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginNutriSoft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginNutriSoft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginNutriSoft().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginBtn;
    private javax.swing.JLabel LogoLogin;
    private javax.swing.JLabel PassTxt;
    private javax.swing.JPasswordField PassTxtField;
    private javax.swing.JButton SignupBtn;
    private javax.swing.JLabel UserTxt;
    private javax.swing.JTextField UserTxtField;
    private javax.swing.JLabel bgColor;
    private javax.swing.JPanel bgLogin;
    // End of variables declaration//GEN-END:variables
}
