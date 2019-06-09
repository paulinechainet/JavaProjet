package Vue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JPanel;
import Controleur.Data;
import Modele.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.JDialog;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author paulinechainet
 */
public class Reporting extends javax.swing.JFrame{

    /**
     *
     */
    private Data db = new Data();

    /**
     *
     */
    private ArrayList<Bulletin> tabb;

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
     * Creation du reporting
     * @param d
     */
    public Reporting(Data d) {
       initComponents();
       db = d;
       Image img = Toolkit.getDefaultToolkit().createImage("Images/Ecole.jpg");
        this.setIconImage(img);
       this.setTitle("Reporting");
       this.setVisible(true);
   }

    /**
     * Creation des report selon matiere
     */
    public void matiere(){
       JDialog ratioHommeFemmeJdialog = new JDialog();
			ratioHommeFemmeJdialog.setTitle("Repartition des moyennes inférieures à 10");
			ArrayList<Discipline> tabd = db.getallDis();
                        int tab[] = new int[tabd.size()];
                        tabb = db.getallB();
                        for(int i=0;i<tabb.size();i++)
                        {
                         ArrayList<Detail> tabde = db.searchd(tabb.get(i).getId());
                         for(int j=0;j<tabde.size();j++){
                            for(int k=0;k<tabd.size();k++){
                               if(tabde.get(j).getEnseignement().getDiscipline().getId() == tabd.get(k).getId()){
                                   tab[k]++;
                               } 
                            }
                        }
                        }
                        
                        final DefaultPieDataset pieDataset = new DefaultPieDataset();

                        for(int i=0; i<tabd.size();i++)
                        {
                         pieDataset.setValue(tabd.get(i).getNom(), tab[i]);   
                        }

			final JFreeChart pieChart = ChartFactory.createPieChart("Moyenne inférieur à 10", pieDataset, true, false, false);
			final ChartPanel cPanel = new ChartPanel(pieChart);

			ratioHommeFemmeJdialog.add(cPanel);


			ratioHommeFemmeJdialog.pack();
			ratioHommeFemmeJdialog.setVisible(true);
   }

    /**
     * creation du chart de repartition
     */
    public void repartition()
   {
      JDialog ratioHommeFemmeJdialog = new JDialog();
       ratioHommeFemmeJdialog.setTitle("Répartition générale");
        Map<String, Integer> niveau = new HashMap<String, Integer>();
        ArrayList<Niveau> tabc = db.getallNiv();
        ArrayList<Classe> tabclasse = db.getallC();
        ArrayList<Personne> tabp = db.getE();
       System.out.println(tabc.size());
                        for(int i=0;i<tabc.size();i++)
                        {
                            int eleve =0;
                            float moyenne =0;
                            int id = tabc.get(i).getId();
                            for(int j=0;j<tabp.size();j++)
                            {
                                Inscription in = db.searchinscrit(tabp.get(j).getId());
                                if(in.getClasse().getNiveau().getId() == tabc.get(i).getId())
                                {
                                  eleve++; 
                                }
                                for(int k=0; k<tabclasse.size();k++){
                                    if(in.getClasse().getId() == tabclasse.get(k).getId()){
                                        
                                    }
                                }
                            }
                            niveau.put(tabc.get(i).getNom(),eleve);
                            
                            
                        }
                        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                        for (int i = 0; i < tabc.size(); i++) {
				dataset.addValue(niveau.get(tabc.get(i).getNom()), tabc.get(i).getNom() , new Integer(i));
			}
                        final JFreeChart barChart = ChartFactory.createBarChart("Eleves par niveau", "Niveau", "Nombre d'eleves",dataset, PlotOrientation.VERTICAL, true, true, false);
			
			final ChartPanel cPanel = new ChartPanel(barChart);

			ratioHommeFemmeJdialog.add(cPanel);
                        ratioHommeFemmeJdialog.pack();
			ratioHommeFemmeJdialog.setVisible(true);
   }

    /**
     * creation du chart selon la moyenne
     */
    public void Moyennesge()
   {
       JDialog ratioHommeFemmeJdialog = new JDialog();
			ratioHommeFemmeJdialog.setTitle("Moyenne générale");
			tabb = db.getallB();

			int notehaute = 0;
			int notehaute2 = 0;
                        int notebasse = 0;
                        int notebasse2 = 0;

			for (int i =0; i<tabb.size();i++) {
				if (tabb.get(i).getmoy() >= 15) {
					notehaute++;
				}
                                else if(tabb.get(i).getmoy() >=10 && tabb.get(i).getmoy()<15){
					notehaute2++;
				}
                                else if(tabb.get(i).getmoy() >=5 && tabb.get(i).getmoy()<10)
                                {
                                    notebasse2++;
                                }
                                else
                                {
                                    notebasse++;
                                }
                        }
                        final DefaultPieDataset pieDataset = new DefaultPieDataset();

			pieDataset.setValue("15-20", notehaute);
			pieDataset.setValue("10-15", notehaute2);
                        pieDataset.setValue("5-10", notebasse2);
                        pieDataset.setValue("0-5", notebasse);

			final JFreeChart pieChart = ChartFactory.createPieChart("Moyenne générale", pieDataset, true, false, false);
			final ChartPanel cPanel = new ChartPanel(pieChart);

			ratioHommeFemmeJdialog.add(cPanel);


			ratioHommeFemmeJdialog.pack();
			ratioHommeFemmeJdialog.setVisible(true);
   }
                                         
    /**
     *jButton1ActionPerformed
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Moyennesge();
    } 
                                         
    /**
     *jButton2ActionPerformed
     * @param evt
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        repartition();
    } 
                                         
    /**
     *jButton3ActionPerformed
     * @param evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       matiere();
    } 

    /**
     *initComponents
     */
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1.setText("Rapports sur les moyennes générales");

        jButton2.setText("Rapport sur la répartition des classe");

        jButton3.setText("Rapport sur les moyennes inférieures à 10");

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }  
}
