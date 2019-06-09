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

public class Niveau {

    
    private int id;

    private String nom;

    public String[] attributs = 
    {
        "Nom"
    };

    /**
     * CONSTRUCTEUR
     *
     * @param id
     * @param nom
     */
    public Niveau(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    /**
     *GETTER
     * @return id associé au niveau
     */
    public int getId() {
        return id;
    }

    /**
     *GETTER
     * @return nom associé au niveau
     */
    public String getNom() {
        return nom;
    }
    
    
}
