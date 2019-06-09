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

public class Trimestre {

    /**
     *
     */
    private int id;

    /**
     *
     */
    private int numero;

    /**
     *
     */
    private String debut;

    /**
     *
     */
    private String fin;

    /**
     *
     */
    private Annee annee;

    /**
     *CONSTRUCTEUR
     * @param id
     * @param numero
     * @param debut
     * @param fin
     * @param annee
     */
    public Trimestre(int id, int numero, String debut, String fin, Annee annee) {
        this.id = id;
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
        this.annee = annee;
    }

    /**
     *CONSTRUCTEUR
     * @param id
     * @param numero
     * @param debut
     * @param fin
     */
    public Trimestre(int id, int numero, String debut, String fin) {
        this.id = id;
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
    }

    /**
     *CONSTRUCTEUR
     * @param numero
     * @param debut
     * @param fin
     * @param annee
     */
    public Trimestre(int numero, String debut, String fin, Annee annee) {
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
        this.annee = annee;
    }
    
    /**
     * GETTER
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *GETTER
     * @return numéro
     */
    public int getNumero() {
        return numero;
    }

    /**
     *GETTER
     * @return debut
     */
    public String getDebut() {
        return debut;
    }

    /**
     *GETTER
     * @return fin
     */
    public String getFin() {
        return fin;
    }

    /**
     *GETTER
     * @return annee
     */
    public Annee getAnnee() {
        return annee;
    }

    /**
     *SETTER
     * @param annee
     */
    public void setAnnee(Annee annee) {
        this.annee = annee;
    }
    
    
}
