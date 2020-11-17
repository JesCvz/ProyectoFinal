/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;
import java.lang.Math;

/**
 *
 * @author strange
 */
public class ImcCalc extends javax.swing.JFrame {

    /**
     * Creates new form ImcCalc
     */
    public ImcCalc() {
        initComponents();
        this.setTitle("Calculadora IMC");
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBg = new javax.swing.JPanel();
        CalcTitle = new javax.swing.JLabel();
        MasaTxtF = new javax.swing.JTextField();
        AlturaTxtF = new javax.swing.JTextField();
        IMCTxtF = new javax.swing.JTextField();
        MasaLabel = new javax.swing.JLabel();
        AltLabel = new javax.swing.JLabel();
        IMCLabel = new javax.swing.JLabel();
        IMCCalcB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        CalcTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        CalcTitle.setText("Calcular IMC");

        MasaLabel.setText("Masa en kg:");

        AltLabel.setText("Altura en m:");

        IMCLabel.setText("IMC:");

        IMCCalcB.setText("Calcular");
        IMCCalcB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMCCalcBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBgLayout = new javax.swing.GroupLayout(PanelBg);
        PanelBg.setLayout(PanelBgLayout);
        PanelBgLayout.setHorizontalGroup(
            PanelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBgLayout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(CalcTitle)
                .addGap(91, 91, 91))
            .addGroup(PanelBgLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(PanelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MasaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AltLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IMCLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(PanelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IMCTxtF, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(AlturaTxtF)
                    .addComponent(MasaTxtF))
                .addGap(46, 46, 46)
                .addComponent(IMCCalcB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBgLayout.setVerticalGroup(
            PanelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBgLayout.createSequentialGroup()
                .addComponent(CalcTitle)
                .addGap(18, 18, 18)
                .addGroup(PanelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MasaTxtF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MasaLabel))
                .addGap(18, 18, 18)
                .addGroup(PanelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AlturaTxtF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AltLabel))
                .addGap(18, 18, 18)
                .addGroup(PanelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IMCTxtF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IMCLabel)
                    .addComponent(IMCCalcB))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void IMCCalcBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IMCCalcBActionPerformed
    calcular();        // TODO add your handling code here:
    }//GEN-LAST:event_IMCCalcBActionPerformed

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
            java.util.logging.Logger.getLogger(ImcCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImcCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImcCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImcCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImcCalc().setVisible(true);
            }
        });
    }
    
    public void calcular(){
        float x = Float.parseFloat(MasaTxtF.getText());
        float y = Float.parseFloat(AlturaTxtF.getText());
        float z;
        
        z = (float) (x/(Math.pow(y, 2)));
        String resultado = String.format("%.2f",z);
        
        IMCTxtF.setText(resultado);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AltLabel;
    private javax.swing.JTextField AlturaTxtF;
    private javax.swing.JLabel CalcTitle;
    private javax.swing.JButton IMCCalcB;
    private javax.swing.JLabel IMCLabel;
    private javax.swing.JTextField IMCTxtF;
    private javax.swing.JLabel MasaLabel;
    private javax.swing.JTextField MasaTxtF;
    private javax.swing.JPanel PanelBg;
    // End of variables declaration//GEN-END:variables
}
