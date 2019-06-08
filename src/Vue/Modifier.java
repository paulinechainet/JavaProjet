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
import Modele.*;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

public class Modifier extends javax.swing.JFrame{
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<Integer> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel trouve;
    private javax.swing.JTextField texte;
    private javax.swing.JTextField texte2;
    private javax.swing.JButton bouton;
    private javax.swing.JButton bouton2;
    private javax.swing.JButton bouton3;
    private String choix;
    private javax.swing.JPanel jP;
    private int annee;
    Classe c,c1;
    Personne p;
    Inscription i;
    Bulletin b;
    Niveau n;
    Trimestre t;
    Detail de;
    Evaluation ev = new Evaluation();
    private Data d;
    private int sup;
    private int trimestre;
    public Modifier(int a, Data db)
    {
        d = db;
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        trouve = new javax.swing.JLabel();
        jP = new javax.swing.JPanel();
        jP.setLayout(null);
        jP.setBounds(10, 80, 1000, 800);
        jLabel2.setBounds(10, 0, 400, 25);
        bouton = new javax.swing.JButton();
        bouton2 = new javax.swing.JButton();
        bouton3 = new javax.swing.JButton();
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Trimestre","1er trimestre","2e trimestre","3e trimestre", }));
        jComboBox3.setBounds(550,30,80,25);
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new Integer[] {2016, 2017, 2018, 2019, }));
        jComboBox2.setBounds(350,30,80,25);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choisissez la table à modifier","Personne", "Classe", "Evaluation", "Ecole", "Inscription","Bulletin", }));
        bouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonActionPerformed(evt);
            }
        });
        bouton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouton2ActionPerformed(evt);
            }
        });
        bouton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouton3ActionPerformed(evt);
            }
        });
        bouton3.setBounds(530, 130, 200, 30);
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
            texte2 = new javax.swing.JTextField();
             texte2.setBounds (10,30,300,25);
             texte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texte2ActionPerformed(evt);
            }
        });
             sup = a;
        if(a == 1)
        {
          this.setTitle("Mise à jour");
          bouton.setText("Modifier");
          bouton2.setText("Ajouter un eleve");
        }
        if(a == 0)
        {
          this.setTitle("Suppresion");
          bouton.setText("Supprimer");
          bouton2.setText("Supprimer un eleve");
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
        if(choix == "Classe")
        {
            rafraichir();
            c = d.searchc(texte.getText(),annee);
            if(c.getId()!=-1)
            {
            jTable = new javax.swing.JTable();
            jScrollPane1 = new javax.swing.JScrollPane();
            DefaultTableModel tableModel = new DefaultTableModel();
            for(int i = 0; i<c.attributs.length;i++)
            {
              tableModel.addColumn(c.attributs[i]);  
            }
            n = c.getNiveau();
            tableModel.addRow(new Object[]{ c.getNom(), n.getNom(),c.getan()});
            jTable.setModel(tableModel);                   
             jScrollPane1.setViewportView(jTable);
             jScrollPane1.setBounds (20,100,500,40);
             bouton.setBounds(530, 100, 100, 30);
             bouton2.setBounds(640,100,150,30);
             jP.add(jScrollPane1);
             jP.add(bouton);
             jP.add(bouton2);
            }
            else
            {
             trouve.setBounds(20,80,500,40);
              trouve.setText("Aucune classe correspondante");
              jP.add(trouve);   
            }
             
            
        }
        if(choix == "Personne")
        {
            String s,ins;
            rech = texte.getText();
            rafraichir();
            p = d.searchp(rech);
            if(p.getId()!=-1)//L'id est négatif si aucune personne ne correspond à la recherche
            {
                if(p.getType() == 1)
                {
                    s = "Eleve";
                }
                else{
                    s ="Professeur";
                }
                c= d.inscrit(p.getId());
            if(c == null)
            {
                ins = "Aucune";
            }
            else
            {
                ins = c.getNom();
            }
              jTable = new javax.swing.JTable();
            jScrollPane1 = new javax.swing.JScrollPane();
            DefaultTableModel tableModel = new DefaultTableModel();
            for(int i = 0; i<p.attributs.length;i++)
            {
              tableModel.addColumn(p.attributs[i]);  
            }
            if(p.getType()== 1){
                tableModel.addColumn("Classe");
             tableModel.addRow(new Object[]{ p.getNom(), p.getPrenom(), s,ins});   
            }
            else{
            tableModel.addRow(new Object[]{ p.getNom(), p.getPrenom(), s});
            
            }
            jTable.setModel(tableModel);                   
             jScrollPane1.setViewportView(jTable);
             jScrollPane1.setBounds (20,120,500,40);
            bouton.setBounds(530, 130, 100, 30);
             jP.add(jScrollPane1);
             jP.add(bouton);   
            }
            else
            {
              trouve.setBounds(20,80,500,40);
              trouve.setText("Aucune personne correspondante");
              jP.add(trouve);
            }
         
        }
        if(choix == "Bulletin")
        {
            rafraichir();
            p = d.searchp(texte.getText());
            if(p.getId()!=-1 && p.getType()!=0){
            i = d.searchinscrit(p.getId());
            t = d.searcht(trimestre, annee);
            b = d.searchbulletin(i.getId(), t.getId());
            
            if(b!= null){
            de = d.searchd(b.getId());
            jTable = new javax.swing.JTable();
            jTable2 = new javax.swing.JTable();
            
            jScrollPane1 = new javax.swing.JScrollPane();
            DefaultTableModel tableModel = new DefaultTableModel();
            for(int i = 0; i<b.attributs.length;i++)
            {
              tableModel.addColumn(b.attributs[i]);  
            }
            tableModel.addRow(new Object[]{p.getNom(),t.getDebut(),t.getFin(),b.getapre(),b.getmoy()});
            //tableModel.setRowCount(0);//Vider la table
            jTable.setModel(tableModel);                   
             jScrollPane1.setViewportView(jTable);
             jScrollPane1.setBounds (20,120,900,40);
             DefaultTableModel tableModel2 = new DefaultTableModel();
             jScrollPane12 = new javax.swing.JScrollPane();
             for(int i = 0; i<de.attributs.length;i++)
            {
              tableModel2.addColumn(de.attributs[i]);  
            }
             tableModel2.addRow(new Object[]{de.getEnseignement().getDiscipline().getNom(),de.getEnseignement().getPersonne().getNom(),de.getMoyenne(),de.getapre()});
            jTable2.setModel(tableModel2);
            jScrollPane12.setViewportView(jTable2);
            jScrollPane12.setBounds (20,200,900,40);
            bouton.setBounds(530, 130, 100, 30);
             jP.add(jScrollPane1);
             jP.add(jScrollPane12);
             jP.add(bouton); 
            }
            else
            {
               trouve.setBounds(20,80,500,40);
              trouve.setText("Aucune bulletin correspondant à la recherche");
              jP.add(trouve);  
            }
            }
            else
            {
               trouve.setBounds(20,80,500,40);
              trouve.setText("Aucune eleve correspondant");
              jP.add(trouve); 
            }
            
        }
        if(choix == "Evaluation")
        {
            rafraichir();
            String s,ins;
            rech = texte.getText();
            rafraichir();
            p = d.searchp(rech);
            if(p.getId()!=-1 && p.getType() == 1)//L'id est négatif si aucune personne ne correspond à la recherche
            {      
                c= d.inscrit(p.getId());
            if(c == null)
            {
                ins = "Aucune";
            }
            else
            {
                ins = c.getNom();
            }
              jTable = new javax.swing.JTable();
            jScrollPane1 = new javax.swing.JScrollPane();
            DefaultTableModel tableModel = new DefaultTableModel();
            for(int i = 0; i<p.attributs.length;i++)
            {
              tableModel.addColumn(p.attributs[i]);  
            }
                tableModel.addColumn("Classe");
             tableModel.addRow(new Object[]{ p.getNom(), p.getPrenom(), "Eleve",ins});   
            jTable.setModel(tableModel);                   
             jScrollPane1.setViewportView(jTable);
             jScrollPane1.setBounds (20,120,500,40);
            bouton.setBounds(530, 130, 100, 30);
             jP.add(jScrollPane1);
            i = d.searchinscrit(p.getId());
            t = d.searcht(trimestre, annee);
            b = d.searchbulletin(i.getId(), t.getId());
            if(b!=null){
            de = d.searchd(b.getId());
            ArrayList <Evaluation> eval;
            eval = d.searchNote(de.getId());
            jTable2 = new javax.swing.JTable();
            jScrollPane12 = new javax.swing.JScrollPane();
            DefaultTableModel tableModel2 = new DefaultTableModel();
            for(int i = 1; i<ev.attributs.length;i++)
            {
              tableModel2.addColumn(ev.attributs[i]);  
            }
            for(int i=0; i<eval.size();i++){
                tableModel2.addRow(new Object[]{de.getEnseignement().getDiscipline().getNom(),eval.get(i).getNote(),eval.get(i).getAppreciation()}); 
            }
            jTable2.setModel(tableModel2);                   
            jScrollPane12.setViewportView(jTable2);
            jScrollPane12.setBounds (20,180,500,40);
            jP.add(jScrollPane12);
            }
            else
            {
               trouve.setBounds(20,150,500,40);
              trouve.setText("Aucune note correspondante");
              jP.add(trouve); 
            }
            }
            else
            {
              trouve.setBounds(20,80,500,40);
              trouve.setText("Aucun eleve correspondant");
              jP.add(trouve);
            }
            
        }
        if(choix == "Inscription")
        {
            String ins;
            rafraichir();
            p = d.searchp(texte.getText());
            if(p.getId()!=-1 && p.getType()!=0){
            jTable = new javax.swing.JTable();
            jScrollPane1 = new javax.swing.JScrollPane();
            DefaultTableModel tableModel = new DefaultTableModel();
            for(int i = 0; i<p.attributs.length-1;i++)
            {
              tableModel.addColumn(p.attributs[i]);  
            }
            tableModel.addColumn("Classe");
            c= d.inscrit(p.getId());
            if(c == null)
            {
                ins = "Aucune";
            }
            else
            {
                ins = c.getNom();
            }
            tableModel.addRow(new Object[]{ p.getNom(), p.getPrenom(),ins});
            jTable.setModel(tableModel);                   
             jScrollPane1.setViewportView(jTable);
             jScrollPane1.setBounds (20,120,500,40);
             bouton.setBounds(530, 130, 100, 30);
             jP.add(bouton);
             jP.add(jScrollPane1);
            }
            else
            {
              trouve.setBounds(20,80,500,40);
              trouve.setText("Aucune eleve correspondant");
              jP.add(trouve);
            }
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
    private void bouton2ActionPerformed(java.awt.event.ActionEvent evt)
    {
        jP.setLayout(null);
        jP.removeAll();
        texte2.setText("Rechercher l'éleve");
        jP.add(texte2);
        this.repaint();
    }
    private void bouton3ActionPerformed(java.awt.event.ActionEvent evt)
    {
        rafraichir();
        c1 = d.searchc(c.getNom(), annee);
       d.modifinscrit(jTable.getValueAt(0, 2).toString(), p.getId(), c1, p);
        
    }
    private void boutonActionPerformed(java.awt.event.ActionEvent evt)
    {
       rafraichir();
            if(choix == "Personne")
        {
            int type;
            if(jTable.getValueAt(0,2).toString().equals("Eleve"))
            {
               type = 1;
            }
            else if(jTable.getValueAt(0,2).toString().equals("Professeur"))
            {
                type = 0;
            }
            else//Si l'utilisateur se trompe dans sa saisie le type n'est pas modifié
            {
                type = p.getType();
            }
            if(sup==1)
            {
            d.modifp(p.getId(), jTable.getValueAt(0,0).toString(), jTable.getValueAt(0,1).toString(),type);
            }
            else
            {
            d.supprp(p.getId());
            }
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
          jP.add(jComboBox2);
        }
        else if(choix == "Personne")
        {
          jLabel2.setText("Rechercher par nom ou par prénom une "+ choix +" :");  
        }
        else if(choix == "Bulletin")
        {
            jP.add(jComboBox2);
            jP.add(jComboBox3);
          jLabel2.setText("Rechercher par nom ou par prénom un élève");
        }
        else if(choix == "Evaluation")
        {
            jLabel2.setText("Rechercher par nom ou par prénom un élève");
            jP.add(jComboBox2);
            jP.add(jComboBox3);
            
        }
        else jLabel2.setText("Rechercher dans : "+ choix);
        jP.add(jLabel2);
        jP.add(texte);
        this.repaint();
    }
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        JComboBox cb = (JComboBox)evt.getSource();
         annee = (Integer)cb.getSelectedItem();
    } 
    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        JComboBox cb = (JComboBox)evt.getSource();
         String sele = (String)cb.getSelectedItem();
         if(sele == "1er trimestre")
         {
             trimestre = 1;
         }
         else if(sele == "2e trimestre")
         {
             trimestre = 2;
         }
         else
         {
             trimestre = 3;
         }
    }
    private void texte2ActionPerformed(java.awt.event.ActionEvent evt)
    {
        String ins;
        Personne p1;
         p = d.searchp(texte2.getText());
        if(p.getId()!=-1 && p.getType()==1){
            jTable = new javax.swing.JTable();
            jScrollPane1 = new javax.swing.JScrollPane();
            DefaultTableModel tableModel = new DefaultTableModel();
            for(int i = 0; i<p.attributs.length-1;i++)
            {
              tableModel.addColumn(p.attributs[i]);  
            }
            tableModel.addColumn("Classe");
            c1= d.inscrit(p.getId());
            if(c1 == null)
            {
                ins = "Aucune";
            }
            else
            {
                ins = c1.getNom();
            }
            tableModel.addRow(new Object[]{ p.getNom(), p.getPrenom(),ins});
             jTable.setModel(tableModel);                   
             jScrollPane1.setViewportView(jTable);
             jScrollPane1.setBounds (20,120,500,40);
             bouton3.setText("Inscrire l'eleve en "+ texte.getText());
               jP.add(jScrollPane1);
             jP.add(bouton3);
             this.repaint();
            }
            else
            {
              trouve.setBounds(20,80,500,40);
              trouve.setText("Aucune eleve correspondant");
              jP.add(trouve);
              this.repaint();
            }
    }
}