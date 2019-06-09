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

public class Inscription {

   
    private int id;
    private Personne personne;
    private Classe classe;

    /**
     * Constructeur
     * @param id
     * @param personne
     * @param classe
     */
    public Inscription(int id, Personne personne, Classe classe) {
        this.id = id;
        this.personne = personne;
        this.classe = classe;
    }

    /**
     *CONSTRUCTEUR
     * @param id
     */
    public Inscription(int id) {
        this.id = id;
    }
    
    /**
     *GETTER
     * @return id de l'inscription
     */
    public int getId() {
        return id;
    }

    /**
     *GETTER 
     * @return personne inscrite
     */
    public Personne getPersonne() {
        return personne;
    }

    /**
     *GETTER
     * @return classe d'inscirption
     */
    public Classe getClasse() {
        return classe;
    }

    /**SETTER
     *
     * @param personne
     */
    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    /**SETTER
     *
     * @param classe
     */
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
    
}
