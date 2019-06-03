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

    public String attributs[]=
    {
        "Nom de l'élève",
        "Id inscription",
        "Trimestre",
        "Appréciation",
        "Moyenne"
    };


    public Bulletin(int id, Inscription inscription, Trimestre trimestre) {
        this.id = id;
        this.inscription = inscription;
        this.trimestre = trimestre;
    }

    public Bulletin(int id) {
        this.id = id;
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
    
    
}
