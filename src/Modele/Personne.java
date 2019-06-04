/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 *
 * @author grego
 */
public class Personne {
    private int id;
    private String nom;
    private String prenom;
     private Classe classe;
     private int type;
     private ArrayList<Classe> tableClasses= new ArrayList();
    private ArrayList<Bulletin> tableBulletins = new ArrayList();
    private ArrayList<Discipline> tableDisciplines=new ArrayList();
    public String[] attributs = 
{
        "Nom",
        "Prénom",
        "Fonction"
};

    public Personne(int id, String nom, String prenom, int t) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        type = t;
    }
    public Personne()
    {
      id = -1;  
    }
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    public int getType(){
        return type;
    }
    public void setType(int t){
        type = t;
    }

    public String getPrenom() {
        return prenom;
    }
    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
      public ArrayList<Bulletin> getBulletins() {
        return tableBulletins;
    }
     
      public ArrayList<Classe> getALClasse()
      {
          return tableClasses;
      }
      public ArrayList<Discipline> getDiscipline()
              {
                  return tableDisciplines; 
              }
}
