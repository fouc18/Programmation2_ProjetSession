package Visual;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mainui;

import java.awt.FlowLayout;
import javax.swing.*;
import java.io.IOException;
import java.io.*;
import javax.imageio.*;


/**
 *
 * @author lsfez
 */
public class nmapo extends JFrame {

    /**
     * Creates new form
     */
    public nmapo() {
        super("App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("\\Visual\\interface.jpg")))));

        } catch (IOException e) {
            e.printStackTrace();

        }
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        Debuter = new javax.swing.JLabel();
        Redemarrer = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        Congestion = new javax.swing.JLabel();
        Fluide = new javax.swing.JLabel();
        GH = new javax.swing.JLabel();
        HD = new javax.swing.JLabel();
        CD = new javax.swing.JLabel();
        BC = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();
        CH = new javax.swing.JLabel();
        AG = new javax.swing.JLabel();
        AB = new javax.swing.JLabel();
        FE = new javax.swing.JLabel();
        AF = new javax.swing.JLabel();
        GF = new javax.swing.JLabel();
        HE = new javax.swing.JLabel();
        ED = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Debuter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Debuter.setText("Débuter");
        Debuter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Debuter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Debuter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DebuterMouseClicked(evt);
            }
        });
        getContentPane().add(Debuter, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 193, 110, 31));

        Redemarrer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Redemarrer.setText("Redémarrer");
        Redemarrer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Redemarrer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RedemarrerMouseClicked(evt);
            }
        });
        getContentPane().add(Redemarrer, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 193, 110, 31));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 36, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, 36, -1));

        Congestion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Congestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CongestionMouseClicked(evt);
            }
        });
        getContentPane().add(Congestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 550, 270, 40));

        Fluide.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Fluide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FluideMouseClicked(evt);
            }
        });
        getContentPane().add(Fluide, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 270, 40));

        GH.setForeground(new java.awt.Color(255, 255, 255));
        GH.setIcon(new javax.swing.ImageIcon("\\Visual\\GH.png")); // NOI18N
        getContentPane().add(GH, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 434, -1, 20));

        HD.setIcon(new javax.swing.ImageIcon("\\Visual\\HD.png")); // NOI18N
        getContentPane().add(HD, new org.netbeans.lib.awtextra.AbsoluteConstraints(855, 434, -1, 20));

        CD.setIcon(new javax.swing.ImageIcon("\\Visual\\CD.png")); // NOI18N
        getContentPane().add(CD, new org.netbeans.lib.awtextra.AbsoluteConstraints(847, 363, -1, 75));

        BC.setIcon(new javax.swing.ImageIcon("\\Visual\\BC.png")); // NOI18N
        getContentPane().add(BC, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 357, -1, 10));

        BG.setIcon(new javax.swing.ImageIcon("\\Visual\\BG.png")); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(742, 370, -1, -1));

        CH.setIcon(new javax.swing.ImageIcon("\\Visual\\CH.png")); // NOI18N
        getContentPane().add(CH, new org.netbeans.lib.awtextra.AbsoluteConstraints(743, 368, -1, -1));

        AG.setIcon(new javax.swing.ImageIcon("\\Visual\\AG.png")); // NOI18N
        getContentPane().add(AG, new org.netbeans.lib.awtextra.AbsoluteConstraints(684, 437, -1, -1));

        AB.setIcon(new javax.swing.ImageIcon("\\Visual\\AB.png")); // NOI18N
        getContentPane().add(AB, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 360, -1, -1));

        FE.setIcon(new javax.swing.ImageIcon("\\Visual\\FE.png")); // NOI18N
        getContentPane().add(FE, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 535, -1, -1));

        AF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        AF.setIcon(new javax.swing.ImageIcon("\\Visual\\AF.png")); // NOI18N
        getContentPane().add(AF, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 448, 110, -1));

        GF.setIcon(new javax.swing.ImageIcon("\\Visual\\GF.png")); // NOI18N
        getContentPane().add(GF, new org.netbeans.lib.awtextra.AbsoluteConstraints(739, 449, -1, -1));

        HE.setIcon(new javax.swing.ImageIcon("\\Visual\\HE.png")); // NOI18N
        getContentPane().add(HE, new org.netbeans.lib.awtextra.AbsoluteConstraints(838, 450, -1, -1));

        ED.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ED.setIcon(new javax.swing.ImageIcon("\\Visual\\ED.png")); // NOI18N
        getContentPane().add(ED, new org.netbeans.lib.awtextra.AbsoluteConstraints(832, 438, 90, -1));

        pack();
    }// </editor-fold>                        

    private void DebuterMouseClicked(java.awt.event.MouseEvent evt) {                                     
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be Débuter.");
    }                                    

    private void RedemarrerMouseClicked(java.awt.event.MouseEvent evt) {                                        
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be Redémarrer.");
    }                                       

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String Depart = jTextField1.getText();
    }                                           

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String Arrivée = jTextField2.getText();
    }                                           

    private void FluideMouseClicked(java.awt.event.MouseEvent evt) {                                    
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be Circulation Fluide.");
    }                                   

    private void CongestionMouseClicked(java.awt.event.MouseEvent evt) {                                        
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be Circulation Fluide.");
    }                                       
    
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
            java.util.logging.Logger.getLogger(nmapo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nmapo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nmapo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nmapo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nmapo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JLabel AB;
    private javax.swing.JLabel AF;
    private javax.swing.JLabel AG;
    private javax.swing.JLabel BC;
    private javax.swing.JLabel BG;
    private javax.swing.JLabel CD;
    private javax.swing.JLabel CH;
    private javax.swing.JLabel Congestion;
    private javax.swing.JLabel Debuter;
    private javax.swing.JLabel ED;
    private javax.swing.JLabel FE;
    private javax.swing.JLabel Fluide;
    private javax.swing.JLabel GF;
    private javax.swing.JLabel GH;
    private javax.swing.JLabel HD;
    private javax.swing.JLabel HE;
    private javax.swing.JLabel Redemarrer;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration                   
}
