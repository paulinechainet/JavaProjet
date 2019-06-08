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
    String Appreciation;
    private int moyenne;

    public String attributs[]=
    {
        "Nom de l'élève",
        "Début du Trimestre",
        "Fin du trimestre",
        "Appréciation",
        "Moyenne générale"
    };


    public Bulletin(int id, Inscription inscription, Trimestre trimestre, String Appreciation) {
        this.id = id;
        this.inscription = inscription;
        this.trimestre = trimestre;
        this.Appreciation = Appreciation;
    }

    public Bulletin(int id) {
        this.id = id;
    }

    public Bulletin() {
        
    }
    
    
    
    public int getId() {
        return id;
    }


    public Inscription getInscription() {
        return inscription;
    }

    public Trimestre getTrimestre() {
        return trimestre;
    }
    
    public  ArrayList<Evaluation> getEvaluation()
    {
        return tableEvaluations;
    }

    public Personne getPersonne()
    {
        return personne;
    }
    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public void setTrimestre(Trimestre trimestre) {
        this.trimestre = trimestre;
    }

public void setEvaluations(ArrayList<Evaluation> evaluations) {
        this.tableEvaluations = evaluations;
    }
public String getapre()
{
    return this.Appreciation;
}
public void setapre(String s)
{
    this.Appreciation = s;
}
public void setmoy(int m)
{
    this.moyenne = m;
}
public int getmoy()
{
    return this.moyenne;
}
    
    
}
