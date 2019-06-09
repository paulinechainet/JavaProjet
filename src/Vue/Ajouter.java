/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Data;
import Modele.*;
import Modele.Personne;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author grego
 */
public class Ajouter extends javax.swing.JFrame {

    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<Integer> jComboBox7;
    private String choix, classe, discipline,prof,niveau,eleve;
    private JTextField[] saisie = new JTextField[10];
    private javax.swing.JButton bouton;
    private javax.swing.JPanel aff;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.ButtonGroup groupe;
    private Classe c;
    private Bulletin b;
    private Personne p,pr;
    private Discipline di;
    private Enseignement e;
    private int type = 3;
    private Data d;
    private Integer note;
    private int droit;

    public Ajouter(Data db, int dr, Personne p1) {
        Image img = Toolkit.getDefaultToolkit().createImage("Images/Ecole.jpg");
        this.setIconImage(img);
        d = db;
        droit = dr;
        pr = p1;
        groupe = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        ArrayList<Classe> tabc;
            ArrayList<Personne> tabp;
            ArrayList<Discipline> tabd;
            tabc = d.getallC();
            tabp = d.getP();
            tabd = d.getallDis();
            jComboBox2 = new javax.swing.JComboBox<>();
            jComboBox3 = new javax.swing.JComboBox<>();
            jComboBox4 = new javax.swing.JComboBox<>();
            jComboBox5 = new javax.swing.JComboBox<>();
            jComboBox6 = new javax.swing.JComboBox<>();
            jComboBox7 = new javax.swing.JComboBox<>();
            jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Choisir une classe"}));
            jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Choisir un professeur"}));
            jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Choisir une discipline"}));
            jComboBox2.setBounds(10, 0, 200, 30);
            jComboBox3.setBounds(230, 0, 200, 30);
            jComboBox4.setBounds(460, 0, 200, 30);
            for(int i =0;i<tabc.size();i++)
            {
             jComboBox2.addItem(tabc.get(i).getNom());   
            }
            for(int i =0;i<tabp.size();i++)
            {
             jComboBox3.addItem(tabp.get(i).getNom());   
            }
            for(int i =0;i<tabd.size();i++)
            {
             jComboBox4.addItem(tabd.get(i).getNom());   
            }
        tabd = d.getallDis();
           tabp = d.getP();
            jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Choisir un élève"}));
            jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Choisir un professeur"}));
            ArrayList<Personne> e = d.getE();
            for(int j=0;j<e.size();j++){
                jComboBox6.addItem(e.get(j).getNom());
            }
            jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Choisir une discipline"}));
            for(int i =0;i<tabd.size();i++)
            {
             jComboBox4.addItem(tabd.get(i).getNom());   
            }
            for(int i =0;i<tabp.size();i++)
            {
             jComboBox3.addItem(tabp.get(i).getNom());   
            }
            for(int i=1;i<21;i++){
                jComboBox7.addItem(i);
            }
        jRadioButton1.setText("Eleve");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Professeur");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        bouton = new javax.swing.JButton();
         bouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonActionPerformed(evt);
            }
        });
        aff = new javax.swing.JPanel();
        aff.setBounds(10, 80, 800, 800);
        this.add(aff);
        bouton.setText("Ajouter");
        jComboBox1 = new javax.swing.JComboBox<>();
        
        if(droit == 0){
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Ajouter un(e)", "Personne", "Classe", "Enseignement","Discipline","Evaluation"}));
        }
        else jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Ajouter une","Evaluation"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
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
private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        type = 1;
    }                                             

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        type = 0;
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
                saisie[1] = new JTextField(1);
                saisie[1].setText("Nom");
                saisie[1].setBounds(10, 0, 150, 30);
                aff.add(saisie[1]);
                ArrayList<Niveau> tabn;
                tabn = d.getallNiv();
                for(int e = 0; e<tabn.size();e++){
                    jComboBox5.addItem(tabn.get(e).getNom());
                }
                jComboBox5.setBounds(180, 0, 250, 30);
            bouton.setBounds(10,40 , 200, 30);
            aff.add(bouton);
            aff.add(jComboBox5);
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
            jRadioButton1.setBounds(10, 50 * i -20, 80, 30);
            jRadioButton2.setBounds(100,50 * i -20, 200, 30);
            groupe.add(jRadioButton1);
            groupe.add(jRadioButton2);
            bouton.setBounds(10,10 + 50 * i, 200, 30);
            aff.add(bouton);
            aff.add(jRadioButton1);
            aff.add(jRadioButton2);
            

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
            bouton.setBounds(10,20 + 50 * i, 200, 30);
            aff.add(bouton);
        }
        if (choix == "Enseignement") {
            initjpanel();
            aff.add(jComboBox2);
            aff.add(jComboBox3);
            aff.add(jComboBox4);
            bouton.setBounds(10,40, 200, 30);
            aff.add(bouton);

        }
        if (choix == "Ecole") {
            initjpanel();
            saisie[1] = new JTextField(1);
            saisie[1].setText("Nom de l'ecole");
            saisie[1].setBounds(10, 0, 150, 30);
            aff.add(saisie[1]);
            bouton.setBounds(10,40 , 200, 30);
            aff.add(bouton);
        }
        if (choix == "Discipline") {
            initjpanel();
            saisie[1] = new JTextField(1);
            saisie[1].setText("Nom de la discipline");
            saisie[1].setBounds(10, 0, 150, 30);
            aff.add(saisie[1]);
            bouton.setBounds(10,40 , 200, 30);
            aff.add(bouton);
        }
        if(choix == "Evaluation")
        {
            initjpanel();
            String ins;
            jComboBox3.setBounds(320, 0, 150, 30);
            jComboBox6.setBounds(10, 0, 150, 30);
            jComboBox4.setBounds(165, 0, 150, 30);
            JLabel a = new JLabel();
            a.setText("Choissisez la note à attribuer");
            a.setBounds(10, 40, 180, 30);
            JLabel a2 = new JLabel();
            a2.setText("Saisissez une appréciation");
            a2.setBounds(10, 110, 380, 30);
            saisie[1] = new JTextField(1);
            saisie[1].setBounds(10, 145, 450, 40);
            jComboBox7.setBounds(10, 75, 150, 30);
            aff.add(jComboBox6);
            if(droit == 0){aff.add(jComboBox3);}
            aff.add(jComboBox4);
            aff.add(a);
            aff.add(a2);
            aff.add(saisie[1]);
            aff.add(jComboBox7);
            bouton.setBounds(10,220 , 200, 30);
            aff.add(bouton);
            
           
        }
}
    private void boutonActionPerformed(java.awt.event.ActionEvent evt)
    {
        initjpanel();
        if(choix == "Personne" && type !=3)
        {
            d.addp(-1,saisie[0].getText(),saisie[1].getText(),type);
        }
           if(choix == "Classe")
        {
           d.addc(niveau, saisie[1].getText(), 2019);
        }
           if (choix == "Discipline") {
               d.addisci(saisie[1].getText());
           }
           if(choix == "Enseignement")
        {
            ArrayList<Personne> tabp;
                    tabp = d.getP();
            Personne p1 = null;
            Discipline di1= null;
            Classe c1 = null;
            ArrayList<Classe> tabc; 
                    tabc = d.getallC();
            ArrayList<Discipline> tabd;
                    tabd = d.getallDis();
            for(int i = 0;i<tabd.size();i++)
            {
                if (tabd.get(i).getNom().equals(discipline)){
                    di1 = tabd.get(i);
                }
            }
            for(int i = 0;i<tabp.size();i++)
            {
                if (tabp.get(i).getNom().equals(prof)){
                    p1 = tabp.get(i);
                }
            }
            for(int i = 0;i<tabc.size();i++)
            {

                if (tabc.get(i).getNom().equals(classe)){
                    c1 = tabc.get(i);
                }
            }
            d.addenseignement(c1, p1, di1);
        }
           if(choix == "Evaluation")
        {
            if(droit!=0)
            {
                prof = pr.getNom();
            }
            ArrayList<Detail> tabd;
            p = d.searchp(eleve);
            Inscription in = d.searchinscrit(p.getId());
            Trimestre t = d.searcht(3, 2018);
            b = d.searchbulletin(in.getId(), t.getId());
            if( b ==null){
                d.addb(in, t,saisie[1].getText());
                b = d.searchbulletin(in.getId(), t.getId());
            }
            tabd = d.searchd(b.getId());
            Enseignement e = d.searchenseignement(prof, discipline);
                if(e!=null){  
            Detail de = d.search1d(e);
            if(de == null){
             d.addetail(b, e);   
            }
                 de = d.search1d(e);
                 d.addeval(note,saisie[1].getText(),de , e);
                }
                else
                {
                    initjpanel();
                    JLabel trouve = new JLabel();
                    trouve.setText("Le professeur n'enseigne pas cette matière");
                    trouve.setBounds(10, 10, 300, 30);
                    aff.add(trouve);
                }
            }
    }   
            
        
     private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {
         JComboBox cb = (JComboBox) evt.getSource();
        classe = (String) cb.getSelectedItem();
     }
     private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {
         JComboBox cb = (JComboBox) evt.getSource();
        prof = (String) cb.getSelectedItem();
     }
     private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {
         JComboBox cb = (JComboBox) evt.getSource();
        discipline = (String) cb.getSelectedItem();
     }
      private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {
         JComboBox cb = (JComboBox) evt.getSource();
        niveau = (String) cb.getSelectedItem();
     }
      private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {
          JComboBox cb = (JComboBox) evt.getSource();
        eleve = (String) cb.getSelectedItem();
     }
      private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {
          JComboBox cb = (JComboBox) evt.getSource();
      note = (Integer) cb.getSelectedItem();
     }
}
