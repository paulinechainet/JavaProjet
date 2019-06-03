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

    public Inscription(int id, Personne personne, Classe classe) {
        this.id = id;
        this.personne = personne;
        this.classe = classe;
    }

    public Inscription(int id) {
        this.id = id;
    }
    
    

    public int getId() {
        return id;
    }

    public Personne getPersonne() {
        return personne;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
    
}
