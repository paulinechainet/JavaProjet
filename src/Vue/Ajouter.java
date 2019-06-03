/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Data;
import Modele.*;
import Modele.Personne;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author grego
 */
public class Ajouter extends javax.swing.JFrame {

    private javax.swing.JComboBox<String> jComboBox1;
    private String choix;
    private JTextField[] saisie = new JTextField[10];
    private javax.swing.JButton bouton;
    private javax.swing.JPanel aff;
    private Classe c;
    private Bulletin b;
    private Personne p;
    private Data d;

    public Ajouter(Data db) {
        d = db;
        bouton = new javax.swing.JButton();
         bouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonActionPerformed(evt);
            }
        });
        aff = new javax.swing.JPanel();
        aff.setBounds(10, 80, 400, 600);
        this.add(aff);
        bouton.setText("Ajouter");
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Choisissez la table à modifier", "Personne", "Classe", "Niveau", "Ecole", "Inscription", "Bulletin",}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(700, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(400, Short.MAX_VALUE))
        );

        pack();
        this.setVisible(true);
    }

    public void initjpanel() {
        
        aff.setLayout(null);
        aff.removeAll();
        this.repaint();
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        JComboBox cb = (JComboBox) evt.getSource();
        choix = (String) cb.getSelectedItem();
        if(choix == "Choisissez la table à modifier")
            {
             initjpanel();
            }
        int i;
        if (choix == "Classe") {
            initjpanel();
            c = new Classe(0, "");
            for (i = 0; i < c.attributs.length; i++) {
                saisie[i] = new JTextField(1);
                saisie[i].setText(c.attributs[i]);
                saisie[i].setBounds(10, 50 * i, 250, 30);
                aff.add(saisie[i]);
            }
            bouton.setBounds(10,40 + 50 * i, 200, 30);
            aff.add(bouton);
        }
        if (choix == "Personne") {
            initjpanel();
            p = new Personne();
            for (i = 0; i < p.attributs.length-1; i++) {
                saisie[i] = new JTextField(1);
                saisie[i].setText(p.attributs[i]);
                saisie[i].setBounds(10, 50 * i, 250, 30);
                aff.add(saisie[i]);
            }
            bouton.setBounds(10,40 + 50 * i, 200, 30);
            aff.add(bouton);
            

        }
        if (choix == "Bulletin") {
            initjpanel();
            b = new Bulletin(1);
            for (i = 1; i < b.attributs.length; i++) {
                saisie[i] = new JTextField(1);
                saisie[i].setText(b.attributs[i]);
                saisie[i].setBounds(10, 50 * i, 250, 30);
                aff.add(saisie[i]);
            }
            bouton.setBounds(10,40 + 50 * i, 200, 30);
            aff.add(bouton);
        }
        if (choix == "Ecole") {

        }
        if (choix == "Ecole") {

        }
}
    private void boutonActionPerformed(java.awt.event.ActionEvent evt)
    {
        initjpanel();
        if(choix == "Personne")
        {
            d.addp(-1,saisie[0].getText(),saisie[1].getText());
        }
           if(choix == "Classe")
        {
            d.addc()
        }
           if(choix == "Bulletin")
        {
            
        }
           if(choix == "Bulletin")
        {
            
        }
    }
}
