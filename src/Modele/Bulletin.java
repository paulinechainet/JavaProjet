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

public class Bulletin {

    private int id;
    private Personne P;
    private Inscription inscription;
     private Trimestre trimestre; 
    private Personne personne;
    private ArrayList<Evaluation> tableEvaluations = new ArrayList();
    private String Appreciation;
    private int moyenne;
    public String attributs[]=
    {
        "Nom de l'élève",
        "Début du Trimestre",
        "Fin du trimestre",
        "Appréciation",
        "Moyenne générale"
    };

    /**
     *Constructeur 
     * i
     * @param id
     * @param inscription
     * @param trimestre
     * @param Appreciation
     * @param moy
     */
    public Bulletin(int id, Inscription inscription, Trimestre trimestre, String Appreciation, int moy) {
        this.id = id;
        this.inscription = inscription;
        this.trimestre = trimestre;
        this.Appreciation = Appreciation;
        this.moyenne = moy;
    }

    /**
     *
     * @param id
     */
    public Bulletin(int id) {
        this.id = id;
    }

    /**
     *
     */
    public Bulletin() {
        
    }
    
    /**
     *
     * @return id du bulletin
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return l'inscription du bulletin
     */
    public Inscription getInscription() {
        return inscription;
    }

    /**
     *
     * @return le trimestre du bulletin
     */
    public Trimestre getTrimestre() {
        return trimestre;
    }
    
    /**
     *
     * @return la table d'eval du du bulletin
     */
    public  ArrayList<Evaluation> getEvaluation()
    {
        return tableEvaluations;
    }

    /**
     *
     * @return personne du bulletin
     */
    public Personne getPersonne()
    {
        return personne;
    }

    /**
     *
     * @param inscription du bulletin
     */
    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    /**
     *
     * @param trimestre du bulletin
     */
    public void setTrimestre(Trimestre trimestre) {
        this.trimestre = trimestre;
    }

    /**
     *
     * @param evaluations du bulletin
     */
    public void setEvaluations(ArrayList<Evaluation> evaluations) {
        this.tableEvaluations = evaluations;
    }

    /**
     *
     * @return appreciations du bulletin
     */
    public String getapre()
{
    return this.Appreciation;
}

    /**
     *
     * @param s du bulletin
     */
    public void setapre(String s)
{
    this.Appreciation = s;
}

    /**
     *
     * @param m du bulletin
     */
    public void setmoy(int m)
{
    this.moyenne = m;
}

    /**
     *
     * @return moyenne du bulletin
     */
    public int getmoy()
{
    return this.moyenne;
}
    
    
}
