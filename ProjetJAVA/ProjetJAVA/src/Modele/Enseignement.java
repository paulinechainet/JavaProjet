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

    public Enseignement(int id, Classe classe, Personne personne, Discipline discipline) {
        this.id = id;
        this.classe = classe;
        this.personne = personne;
        this.discipline = discipline;
    }

    public Enseignement(int id) {
        this.id = id;
    }
    

    public int getId() {
        return id;
    }

    public Classe getClasse() {
        return classe;
    }

    public Personne getPersonne() {
        return personne;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
    
}
