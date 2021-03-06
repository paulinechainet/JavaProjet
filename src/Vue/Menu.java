/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Data;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import Modele.*;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author grego
 */
public class Menu extends javax.swing.JFrame {

    /**
     *
     */
    private Image img;

    /**
     *
     */
    private javax.swing.JLabel eleves;

    /**
     *
     */
    private Data datab = new Data();

    /**
     *
     */
    private int nb;

    /**
     *
     */
    private int droit;

    /**
     *
     */
    private Personne p;

    /**
     * Creates new form Menu
     * @param db
     * @param c
     * @param pe
     */
    public Menu(Data db, int c, Personne pe) {
        initComponents();
        datab = db;
        p = pe;
        droit = c;
        img = Toolkit.getDefaultToolkit().createImage("Images/Ecole.jpg");

        this.setIconImage(img);
        eleves = new javax.swing.JLabel();
        eleves.setBounds(10,50,160,30);
        this.add(eleves);
        this.setTitle("Gestion de l'école");
        this.setVisible(true);
        nb = datab.nbeleves();
        eleves.setText("Nombre d'élèves : "+nb);
    }
    
    /**
     * Initialisation des composants 
     */
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Rechercher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ajouter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Modifier");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Supprimer");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Bienvenue dans votre espace gestion école");

        Icon image = new ImageIcon( "Images/Graphique.png" );
        jLabel2.setIcon(image);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * jButton4ActionPerformed
     * @param evt
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new Modifier(0,datab,droit);
    }                                        

    /**
     * jButton1ActionPerformed
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new Rechercher(datab);
    }                                        

    /**
     *jLabel2MouseClicked
     * @param evt
     */
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {                                     
      new Reporting(datab);
    }                                    

    /**
     *jButton2ActionPerformed
     * @param evt
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new Ajouter(datab,droit,p);
    }                                        

    /**
     * jButton3ActionPerformed
     * @param evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new Modifier(1,datab,droit);
    }                                        

    // Variables declaration - do not modify                     

    /**
     *
     */
    private javax.swing.JButton jButton1;

    /**
     *
     */
    private javax.swing.JButton jButton2;

    /**
     *
     */
    private javax.swing.JButton jButton3;

    /**
     *
     */
    private javax.swing.JButton jButton4;

    /**
     *
     */
    private javax.swing.JLabel jLabel1;

    /**
     *
     */
    private javax.swing.JLabel jLabel2;
    // End of variables declaration                   
}
