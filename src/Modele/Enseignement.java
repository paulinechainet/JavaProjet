/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author paulinechainet
 */
public class Enseignement {

    
    private int id;

    private Classe classe;

    private Personne personne;

    private Discipline discipline;
    public String attributs[]={
        "Classe",
        "Professeur",
        "Discipline"
    };

    public String attributs[]={
        "Classe",
        "Professeur",
        "Discipline"
    };

    /**
     *CONSTRUCTEUR
     * @param id
     * @param classe
     * @param personne
     * @param discipline
     */
    public Enseignement(int id, Classe classe, Personne personne, Discipline discipline) {
        this.id = id;
        this.classe = classe;
        this.personne = personne;
        this.discipline = discipline;
    }

    /**
     *CONSTRUCTEUR 
     * @param id
     */
    public Enseignement(int id) {
        this.id = id;
    }


    public Enseignement() {
        
    }
    

    /**
     *
     */
    public Enseignement() {
        
    }
    
    /**
     *GETTER
     * @return id del'enseingment
     */
    public int getId() {
        return id;
    }

    /**GETTER
     *
     * @return la classe
     */
    public Classe getClasse() {
        return classe;
    }

    /**
     *GETTER
     * @return personne
     */
    public Personne getPersonne() {
        return personne;
    }

    /**
     *GETTER
     * @return discipline
     */
    public Discipline getDiscipline() {
        return discipline;
    }

    /**
     *SETTER
     * @param classe
     */
    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    /**SETTER
     *
     * @param personne
     */
    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    /**
     *SETTER
     * @param discipline
     */
    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
    
}
