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
    /**
     * type determine si la personne est un prof=0 ou un eleve=1
    */
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

    /**
     *CONSTRUCTEUR
     * @param id
     * @param nom
     * @param prenom
     * @param t
     */
    public Personne(int id, String nom, String prenom, int t) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        type = t;
    }

    /**
     *CONSTRUCTEUR PAR DEFAUT
     */
    public Personne()
    {
      id = -1;  
    }
    
    /**
     *GETTER
     * @return id de la personne
     */
    public int getId() {
        return id;
    }

    /**
     *Getter
     * @return nom de la personne 
     */
    public String getNom() {
        return nom;
    }

    /** GETTER 
     *
     * @return type
     */
    public int getType(){
        return type;
    }

    /**
     * SETTER
     *
     * @param t
     */
    public void setType(int t){
        type = t;
    }

    /**
     *Getter
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     *GETTER
     * @return classe de la personne
     */
    public Classe getClasse() {
        return classe;
    }

    /**
     *SETTER
     * @param classe
     */
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
    /**
     *GETTER
     * @return tableeBulletin soit l'integralité de sbulletin associé a la personne
     */
    public ArrayList<Bulletin> getBulletins() {
        return tableBulletins;
    }
     
    /**
     *GETTER
     * @return tableClasses
     */
    public ArrayList<Classe> getALClasse()
      {
          return tableClasses;
      }

    /**
     *Getter
     * @return tableDiscipline
     */
    public ArrayList<Discipline> getDiscipline()
              {
                  return tableDisciplines; 
              }
}
