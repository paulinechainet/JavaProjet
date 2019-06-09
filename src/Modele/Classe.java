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
public class Classe {

    private int id;
    private String nom;
    private Niveau niveau;
    private Annee annee;
    private ArrayList<Personne> tablePersonnes;
    public ArrayList<Discipline> tableDisciplines = new ArrayList();
    public String[] attributs = 
{
        "Nom",
        "Niveau",
        "Annee"
};

    /**
     * Constructeur
     * @param id
     * @param nom
     * @param niveau
     * @param annee
     */
    public Classe(int id, String nom, Niveau niveau, Annee annee) {
        this.id = id;
        this.nom = nom;
        this.niveau = niveau;
        this.annee = annee;
    }

    /**
     *Constructeur 
     * @param id
     * @param nom
     */
    public Classe(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    /**
     *Constructeur par defaut 
     */
    public Classe() {
        this.id = -1;
    }
    
    /**
     *GETTER
     * @return id 
     */
    public int getId() {
        return id;
    }

    /**
     * GETTER
     *
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * GETTTER
     *
     * @return niveau
     */
    public Niveau getNiveau() {
        return niveau;
    }

    /**GETTER
     *
     * @return annee
     */
    public Annee getAnnee() {
        return annee;
    }

    /**
     *GETTER
     * @return l'id de l'année
     */
    public int getan(){
        return annee.getId();
    }

    /**
     *SETTER
     * @param niveau
     */
    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    /**
     *SETTER
     * @param annee
     */
    public void setAnnee(Annee annee) {
        this.annee = annee;
    }
    
    /**
     *GETTER
     * @return table de personnes
     */
    public ArrayList<Personne> getPersonnes() {
        return tablePersonnes;
    }

    /**
     *SETTER
     * @param personnes
     */
    public void setEleves(ArrayList<Personne> personnes) {
        this.tablePersonnes = personnes;
    }

    /**
     *SETTER
     * @return table avec les disciplines
     */
    public ArrayList<Discipline> getDisciplines() {
        return tableDisciplines;
    }
}
