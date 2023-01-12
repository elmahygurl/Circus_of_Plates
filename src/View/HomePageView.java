
package View;

import Control.GameController;
import static java.lang.System.exit;
import Control.EasyLevel;
import Control.HardLevel;
import Control.MediumLevel;
import Control.OurWorld;

public class HomePageView extends javax.swing.JFrame  {
    public HomePageView() {
        initComponents();
        this.setSize(515, 378);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        easyLevel = new javax.swing.JButton();
        mediumLevel = new javax.swing.JButton();
        hardLevel = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("FUN");
        setBounds(new java.awt.Rectangle(0, 0, 500, 700));
        getContentPane().setLayout(null);

        easyLevel.setBackground(new java.awt.Color(255, 51, 51));
        easyLevel.setFont(new java.awt.Font("Tempus Sans ITC", 3, 24)); // NOI18N
        easyLevel.setText("Easy ");
        easyLevel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        easyLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                easyLevelActionPerformed(evt);
            }
        });
        getContentPane().add(easyLevel);
        easyLevel.setBounds(190, 200, 120, 30);

        mediumLevel.setBackground(new java.awt.Color(255, 51, 51));
        mediumLevel.setFont(new java.awt.Font("Tempus Sans ITC", 3, 24)); // NOI18N
        mediumLevel.setText("Medium");
        mediumLevel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mediumLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediumLevelActionPerformed(evt);
            }
        });
        getContentPane().add(mediumLevel);
        mediumLevel.setBounds(190, 240, 120, 30);

        hardLevel.setBackground(new java.awt.Color(255, 51, 51));
        hardLevel.setFont(new java.awt.Font("Tempus Sans ITC", 3, 24)); // NOI18N
        hardLevel.setText("Hard");
        hardLevel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hardLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardLevelActionPerformed(evt);
            }
        });
        getContentPane().add(hardLevel);
        hardLevel.setBounds(190, 280, 120, 30);

        exit.setBackground(new java.awt.Color(255, 51, 51));
        exit.setFont(new java.awt.Font("Tempus Sans ITC", 3, 24)); // NOI18N
        exit.setText("Exit");
        exit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(410, 10, 84, 37);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ready to have some fun?");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 130, 310, 80);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HOME0.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 500, 340);

        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 500, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void easyLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_easyLevelActionPerformed
    GameController gameController = new GameController(() -> new OurWorld(new EasyLevel(), 1000, 700));   
    gameController.start();
    this.setVisible(false);

/*gameController = GameEngine.start("Hello", new OurWorld(new EasyLevel(), 800, 500), menuBar, Color.white);*/    }//GEN-LAST:event_easyLevelActionPerformed

    private void mediumLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediumLevelActionPerformed
        // TODO add your handling code here:
        GameController gameController = new GameController(() -> new OurWorld(new MediumLevel(), 1000, 700));   
        gameController.start();
        this.setVisible(false);
    }//GEN-LAST:event_mediumLevelActionPerformed

    private void hardLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hardLevelActionPerformed
        // TODO add your handling code here:
        GameController gameController = new GameController(() -> new OurWorld(new HardLevel(), 1000, 700));
        gameController.start();
        this.setVisible(false);
    }//GEN-LAST:event_hardLevelActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        exit(0);
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(HomePageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePageView().setVisible(true);
            }
           
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton easyLevel;
    private javax.swing.JButton exit;
    private javax.swing.JButton hardLevel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton mediumLevel;
    // End of variables declaration//GEN-END:variables

}
