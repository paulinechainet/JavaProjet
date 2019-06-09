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

    /**
     *
     */
    private int id;

    /**
     *
     */
    private int note;

    /**
     *
     */
    private String appreciation;

    
    private Detail bulletin;
    private Enseignement enseignant;
   public String attributs[]=
    {
      "Nom de l'élève",
      "Discipline",
      "Note",
      "Appreciation"
    };
/** Constructeur
     *
     * @param id
     * @param note
     * @param appreciation
     * @param bulletin
     * @param enseignant
     */
    
    public Evaluation(int id, int note, String appreciation, Detail bulletin,Enseignement enseignant) {
        this.id = id;
        this.note = note;
        this.appreciation = appreciation;
        this.bulletin = bulletin;
        this.enseignant = enseignant;
    }

    /**Constructeur
     *
     * @param id
     * @param note
     * @param appreciation
     */
    public Evaluation(int id, int note,String appreciation) {
        this.id = id;
        this.note = note;
        this.appreciation = appreciation;
    }

    public Evaluation() {
    }


    /**Constructeur
     *
     */
    public Evaluation() {
    }

    /**
     *GETTER
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *getter 
     * @return note
     */
    public int getNote() {
        return note;
    }

    /**
     *getter
     * @return appreciation
     */
    public String getAppreciation() {
        return appreciation;
    }

    /**
     *GETTER
     * @return bulletin
     */

    public Detail getBulletin() {
        return bulletin;
    }

    /** SETTER
     *
     * @param bulletin
     */
    public void setBulletin(Detail bulletin) {
        this.bulletin = bulletin;
    }

    /**
     *GETTER
     * @return enseignant
     */
  
    public Enseignement getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignement enseignant) {

        this.enseignant = enseignant;
    }
    
    
    
    
}
