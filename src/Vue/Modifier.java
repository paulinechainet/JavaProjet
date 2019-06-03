/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

/**
 *
 * @author grego
 */
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import Controleur.*;
import Modele.Bulletin;
import Modele.Classe;
import Modele.Personne;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

public class Modifier extends javax.swing.JFrame{
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField texte;
    private javax.swing.JButton bouton;
    private String choix;
    private javax.swing.JPanel jP;
    private boolean recherche;
    Classe c;
    Personne p;
    Bulletin b;
    private Data d;
    public Modifier(int a, Data db)
    {
        d = db;
        recherche = true;
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jP = new javax.swing.JPanel();
        jP.setLayout(null);
        jP.setBounds(10, 80, 800, 600);
        jLabel2.setBounds(10, 0, 400, 25);
        bouton = new javax.swing.JButton();
        
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choisissez la table à modifier","Personne", "Classe", "Niveau", "Ecole", "Inscription","Bulletin", }));
        bouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonActionPerformed(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        texte = new javax.swing.JTextField();
             texte.setBounds (10,30,300,25);
             texte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texteActionPerformed(evt);
            }
        });
        if(a == 1)
        {
          this.setTitle("Mise à jour");
          bouton.setText("Modifier");
        }
        if(a == 0)
        {
          this.setTitle("Suppresion");
          bouton.setText("Supprimer");
        }
        Init();
        this.setVisible(true);
    }
        
public void Init()
{
   javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel1)))
                .addContainerGap(700, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(400, Short.MAX_VALUE))
        );
        pack();
    }
    private void texteActionPerformed(java.awt.event.ActionEvent evt)
    {
        
        String rech = texte.getText();
        System.out.println(texte.getText());
        if(choix == "Classe")
        {
            rafraichir();
            //DAO_Classe d = new DAO_Classe();
            //c = d.recherche(texte.getText());
            c = new Classe(1,rech);
            jTable = new javax.swing.JTable();
            jScrollPane1 = new javax.swing.JScrollPane();
            DefaultTableModel tableModel = new DefaultTableModel();
            for(int i = 0; i<c.attributs.length;i++)
            {
              tableModel.addColumn(c.attributs[i]);  
            }
            tableModel.addRow(new Object[]{ c.getNom(), c.getAnnee(), c.getNiveau()});
            jTable.setModel(tableModel);                   
             jScrollPane1.setViewportView(jTable);
             jScrollPane1.setBounds (20,100,500,40);
             bouton.setBounds(530, 130, 100, 30);
             jP.add(jScrollPane1);
             jP.add(bouton);
             
            
        }
        if(choix == "Personne")
        {
            rafraichir();
            d.affichage();
            p = new Personne(1,rech,rech);
         jTable = new javax.swing.JTable();
            jScrollPane1 = new javax.swing.JScrollPane();
            DefaultTableModel tableModel = new DefaultTableModel();
            for(int i = 0; i<p.attributs.length;i++)
            {
              tableModel.addColumn(p.attributs[i]);  
            }
            tableModel.addRow(new Object[]{ p.getPrenom(), p.getNom()});
            //tableModel.setRowCount(0);//Vider la table
            jTable.setModel(tableModel);                   
             jScrollPane1.setViewportView(jTable);
             jScrollPane1.setBounds (20,120,500,40);
            bouton.setBounds(530, 130, 100, 30);
             jP.add(jScrollPane1);
             jP.add(bouton); 
        }
        if(choix == "Bulletin")
        {
            rafraichir();
         b = new Bulletin(1);
         jTable = new javax.swing.JTable();
            jScrollPane1 = new javax.swing.JScrollPane();
            DefaultTableModel tableModel = new DefaultTableModel();
            for(int i = 0; i<b.attributs.length;i++)
            {
              tableModel.addColumn(b.attributs[i]);  
            }
            tableModel.addRow(new Object[]{});
            //tableModel.setRowCount(0);//Vider la table
            jTable.setModel(tableModel);                   
             jScrollPane1.setViewportView(jTable);
             jScrollPane1.setBounds (20,120,500,40);
            bouton.setBounds(530, 130, 100, 30);
             jP.add(jScrollPane1);
             jP.add(bouton); 
            
        }
        if(choix == "Ecole")
        {
            rafraichir();
            //Recherche dans classe
        }
        
    }
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) { 
        Init();
        JComboBox cb = (JComboBox)evt.getSource();
         choix = (String)cb.getSelectedItem();
            
            if(choix != "Choisissez la table à modifier")
            {
             rafraichir();
             this.add(jP);
            }
            
            
            
    }
    private void boutonActionPerformed(java.awt.event.ActionEvent evt)
    {
       jScrollPane1.setVisible(false);
           bouton.setVisible(false);
            this.repaint();
            if(choix == "Bulletin")
        {
            
        }
           if(choix == "Bulletin")
        {
            
        }
           if(choix == "Bulletin")
        {
            
        }
           if(choix == "Bulletin")
        {
            
        }
    }
    public void rafraichir()
    {
        jP.setLayout(null);
        jP.removeAll();
        if(choix == "Classe")
        {
          jLabel2.setText("Rechercher par nom une "+ choix+ " :");  
        }
        else if(choix == "Personne")
        {
          jLabel2.setText("Rechercher par nom ou par prénom une "+ choix +" :");  
        }
        else if(choix == "Bulletin")
        {
          jLabel2.setText("Rechercher par nom ou par prénom un "+ choix +" :");
        }
        else jLabel2.setText("Rechercher dans : "+ choix);
        jP.add(jLabel2);
        jP.add(texte);
        this.repaint();
    }
}