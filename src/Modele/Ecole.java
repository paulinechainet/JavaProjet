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
public class Ecole {
    
    private int id; 
    private String nom; 
    public String[] attributs = 
    {
      
        "Nom"
    };
    public Ecole (int id, String nom)
    {
        this.id=id;
        this.nom=nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
            
}
