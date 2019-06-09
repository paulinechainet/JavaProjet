/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Data;
import Modele.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author grego
 */
public class Notes extends javax.swing.JFrame{
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private String choix;
    private Data db = new Data();
    private Classe c;
    private Personne p;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable2;
    private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JPanel jP;
    public Notes(Personne p1, Data d){
        db= d;
        p = p1;
        Init();
        Image img = Toolkit.getDefaultToolkit().createImage("Images/Ecole.jpg");
        this.setIconImage(img);
        this.setTitle("Mes résultats");
        this.setVisible(true);
    }
    public void Init()
{
    jP = new javax.swing.JPanel();
        jP.setLayout(null);
        jP.setBounds(10, 80, 1000, 600);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    jComboBox1 = new javax.swing.JComboBox<>();
    jLabel1 = new javax.swing.JLabel();
    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afficher :","Notes","Bulletin", }));
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
        this.add(jP);
        pack();
    }
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) { 

        JComboBox cb = (JComboBox)evt.getSource();
         choix = (String)cb.getSelectedItem();
         ArrayList<Evaluation> e = new ArrayList();
         Evaluation e1 = new Evaluation();
         if(choix == "Notes"){
             String ins;
             rafraichir();
             e = db.getallEv();
             jTable = new javax.swing.JTable();
                jScrollPane1 = new javax.swing.JScrollPane();
                DefaultTableModel tableModel = new DefaultTableModel();
                for(int i = 0; i<e1.attributs.length;i++)
            {
              tableModel.addColumn(e1.attributs[i]);  
            }
            for(int i=0; i<e.size();i++){
                if(e.get(i).getBulletin().getBulletin().getInscription().getPersonne().getId() == p.getId()){
                 tableModel.addRow(new Object[]{e.get(i).getBulletin().getBulletin().getInscription().getPersonne().getNom(),e.get(i).getBulletin().getEnseignement().getDiscipline().getNom(),e.get(i).getNote(),e.get(i).getAppreciation()});    
                }
                
            }
            jTable.setModel(tableModel);                   
            jScrollPane1.setViewportView(jTable);
            jScrollPane1.setBounds (20,120,500,140);
            jP.add(jScrollPane1);
         }
         if(choix =="Bulletin")
         {
             rafraichir();
          ArrayList<Bulletin> tabb;
          ArrayList<Detail> tabd;
                Bulletin b = new Bulletin();
                jScrollPane12 = new javax.swing.JScrollPane();
             Detail de = new Detail(1);
             DefaultTableModel tableModel2 = new DefaultTableModel();
             for(int i = 0; i<de.attributs.length;i++)
            {
              tableModel2.addColumn(de.attributs[i]);  
            }
            jTable = new javax.swing.JTable();
            jTable2 = new javax.swing.JTable();
            jScrollPane1 = new javax.swing.JScrollPane();
            DefaultTableModel tableModel = new DefaultTableModel();
            tabb = db.getallB();
            for(int i = 0; i<b.attributs.length;i++)
            {
              tableModel.addColumn(b.attributs[i]);  
            }
            for(int i=0;i<tabb.size();i++)
            {
              if(tabb.get(i).getInscription().getPersonne().getId() == p.getId()){
                  tableModel.addRow(new Object[]{p.getNom(),tabb.get(i).getTrimestre().getDebut(),tabb.get(i).getTrimestre().getFin(),tabb.get(i).getapre(),tabb.get(i).getmoy()});
                  tabd = db.searchd(tabb.get(i).getId());
                  for(int j =0; j<tabd.size();j++){
                 tableModel2.addRow(new Object[]{tabd.get(j).getEnseignement().getDiscipline().getNom(),tabd.get(j).getEnseignement().getPersonne().getNom(),tabd.get(j).getMoyenne(),tabd.get(j).getapre()});
             }
              }
            }
             
            jTable2.setModel(tableModel2);
            jScrollPane12.setViewportView(jTable2);
            jScrollPane12.setBounds (20,200,900,120);
             jP.add(jScrollPane1);
             jP.add(jScrollPane12);
            jTable.setModel(tableModel);                   
             jScrollPane1.setViewportView(jTable);
             jScrollPane1.setBounds (20,120,900,100);
             jP.add(jScrollPane1);   
         }
    }
    void rafraichir(){
        jP.setLayout(null);
        jP.removeAll();
        this.repaint();
    }
}
