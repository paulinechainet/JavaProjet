/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Data;
import Modele.Personne;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author grego
 */
public class Login extends javax.swing.JFrame{

    /**
     *
     */
    private javax.swing.JComboBox<String> jComboBox1;

    /**
     *
     */
    private javax.swing.JPanel aff;

    /**
     *
     */
    private javax.swing.JPasswordField jPasswordField1;

    /**
     *
     */
    private javax.swing.JTextField jTextField1;

    /**
     *
     */
    private javax.swing.JLabel j1;

    /**
     *
     */
    private javax.swing.JLabel j2;

    /**
     *
     */
    private javax.swing.JLabel j3;

    /**
     *
     */
    private javax.swing.JButton bouton;

    /**
     *
     */
    private String choix;

    /**
     *
     */
    private Personne p;

    /**
     *
     */
    Data datab = new Data();

    /**
     * Initialisation et creation du jpannel de login
     */
    public Login(){
    Image img = Toolkit.getDefaultToolkit().createImage("Images/Ecole.jpg");
        this.setIconImage(img);
jComboBox1 = new javax.swing.JComboBox<>();
        aff = new javax.swing.JPanel();
        j1 = new javax.swing.JLabel();
        j1.setText("Login :");
        j1.setBounds(40, 10, 100, 20);
        j2 = new javax.swing.JLabel();
        j2.setText("Mot de passe :");
        j2.setBounds(40, 70, 100, 20);
        j3 = new javax.swing.JLabel();
        j3.setText("Connexion en cours...");
        j3.setBounds(40, 170, 100, 20);
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField1.setBounds(40, 95,200 , 30);
        jTextField1 = new javax.swing.JTextField();
        jTextField1.setBounds(40, 35, 200, 30);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Se connecter en tant que","Eleve","Professeur","Administrateur" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        bouton = new javax.swing.JButton();
        bouton.setText("Se connecter");
         bouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonActionPerformed(evt);
            }
        });
         bouton.setBounds(40, 145,200 , 30);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        
        aff = new javax.swing.JPanel();
        aff.setBounds(10, 40, 250, 250);
        this.add(aff);
        this.setTitle("Connexion");
        pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
                                           
    /**
     *jComboBox1ActionPerformed
     * @param evt
     */
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        JComboBox cb = (JComboBox)evt.getSource();
         choix = (String)cb.getSelectedItem();
         rafraichir();
    }   

    /**
     * Rafraichissement de la jframe
     */
    private void rafraichir(){
aff.setLayout(null);
aff.removeAll();
             aff.add(j1);
             aff.add(j2);
             aff.add(jPasswordField1);
             aff.add(jTextField1);
             aff.add(bouton);
         this.repaint();
}

    /**
     * boutonActionPerformed
     * @param evt
     */
    private void boutonActionPerformed(java.awt.event.ActionEvent evt)
    {
        if(choix == "Eleve" && jTextField1 != null && jPasswordField1!=null)
        {
            datab.LoadPersonne();
            p = datab.verife(jTextField1.getText());
            if(p!=null)//Si la connexion est validée
            {
                int a =1;
                datab.LoadAllData();
                this.dispose();
                new Notes(p,datab);
            }
            else{
                aff.setLayout(null);
                aff.removeAll();
                JLabel erreur = new javax.swing.JLabel();
                erreur.setText("Identifiant ou mot de passe incorrect");
                erreur.setBounds(10, 40, 250, 20);
                aff.add(erreur);
                this.repaint();
            }
            
        }
        if(choix == "Professeur" && jTextField1 != null && jPasswordField1!=null)
        {
            datab.LoadPersonne();
            p = datab.verifp(jTextField1.getText());
            if(p!=null)//Si la connexion est validée
            {
               int a = 2; 
               datab.LoadAllData();  
            new Menu(datab,a,p);
            this.dispose();
            }
            else{
                aff.setLayout(null);
                aff.removeAll();
                JLabel erreur = new javax.swing.JLabel();
                erreur.setText("Identifiant ou mot de passe incorrect");
                erreur.setBounds(10, 40, 250, 20);
                aff.add(erreur);
                this.repaint();
            }
            
        }
        if (choix == "Administrateur" &&  jTextField1.getText().equals("root"))
        {
            int a = 0;
            Personne p = null;
              datab.LoadAllData();  
            new Menu(datab,a,p);
            this.dispose();
        }
    }
}
