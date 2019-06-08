/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author grego
 */


public class Evaluation {
    private int id;
    private int note;
    private String appreciation;
    private Detail bulletin;
    private Personne enseignant;
   public String attributs[]=
    {
      "Nom de l'élève",
      "Discipline",
      "Note",
      "Appreciation"
    };

    public Evaluation(int id, int note, String appreciation, Detail bulletin,Personne enseignant) {
        this.id = id;
        this.note = note;
        this.appreciation = appreciation;
        this.bulletin = bulletin;
        this.enseignant = enseignant;
    }

    public Evaluation(int id, int note,String appreciation) {
        this.id = id;
        this.note = note;
        this.appreciation = appreciation;
    }

    public Evaluation() {
    }

    public int getId() {
        return id;
    }

    public int getNote() {
        return note;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public Detail getBulletin() {
        return bulletin;
    }

    public void setBulletin(Detail bulletin) {
        this.bulletin = bulletin;
    }

    public Personne getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Personne enseignant) {
        this.enseignant = enseignant;
    }
    
    
    
    
}
