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


public class Annee {

    /**
     *
     */
    private int id;

    /**
     *
     * @param id
     */
    public Annee(int id) {
        this.id = id;
    }

    /**
     *G
     * @return id de l'année
     */
    public int getId() {
        return id;
    }

    /**
     *SETTER
     * @param id
     */
    public void setId(int id)
{
    this.id=id;
}

}
