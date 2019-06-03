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
public class Classe {
    private int id;
    private String nom;
    private Niveau niveau;
    private Annee annee;
    private ArrayList<Personne> tablePersonnes;
    public ArrayList<Discipline> tableDisciplines = new ArrayList();
    
    public Classe(int id, String nom, Niveau niveau, Annee annee) {
        this.id = id;
        this.nom = nom;
        this.niveau = niveau;
        this.annee = annee;
    }

    public Classe(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public Annee getAnnee() {
        return annee;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public void setAnnee(Annee annee) {
        this.annee = annee;
    }
    
    public ArrayList<Personne> getPersonnes() {
        return tablePersonnes;
    }

    public void setEleves(ArrayList<Personne> personnes) {
        this.tablePersonnes = personnes;
    }

    
    

    public ArrayList<Discipline> getDisciplines() {
        return tableDisciplines;
    }
}
