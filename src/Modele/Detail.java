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
public class Detail {

    private int nb_notes;
    private int id;
    private float moyenne;
    private Bulletin bulletin;
    private Enseignement enseignement;
    private String appreciation;
    public String attributs[]=
    {
        "Discipline",
        "Professeur",
        "Moyenne",
        "Appréciation"
    };

    /** CONSTRUCTEUR
     *
     * @param id
     */
    public Detail(int id)
    {
        this.id = id;
    }    


    /**
     * CONSTRUCTEUR
     * @param id
     * @param b
     * @param e
     * @param a
     */

    public Detail(int id, Bulletin b, Enseignement e, String a )
    {
      this.appreciation = a;
      this.bulletin = b;
      this.enseignement = e;
      this.id = id;
    }

    /**
     *GETTER
     * @return appreciatn 
     */
    public String getapre()
    {
        return this.appreciation;
    }

    /**SETTER 
     *
     * @param s
     */
    public void setapre(String s)
    {
        this.appreciation = s;
                
    }

    /**
     *GETTER
     * @return id 
     */
    public int getId()
    {
        return this.id;
    }

    /** SETTER
     *
     * @param n
     */
    public void setnb(int n)
    {
        this.nb_notes = n;       
    }

    /**
     *SETTER
     * @param e
     */
    public void setEnseignement(Enseignement e)
    {
        this.enseignement = e;
    }

    /**SETTER
     *
     * @param b
     */
    public void setBulletin(Bulletin b)
    {
        this.bulletin = b;
    }

    /**GETTER
     *
     * @return enseignement
     */
    public Enseignement getEnseignement()
    {
        return this.enseignement;
    }

    /**GETTER
     *
     * @return nombre de notes
     */
    public int getnb()
    {
        return this.nb_notes;
    }

    /**
     *GETTER
     * @return Bulletin
     */
    public Bulletin getBulletin()
    {
        return this.bulletin;
    }

    /**
     *GETTER
     * @return moyenne
     */
 
    public float getMoyenne()
    {
        return this.moyenne;
    }
    public void setMoyenne(float m)

    {
        this.moyenne = m;
    }

    /**
     * RECHERCHE BULLETIN
     * @param b
     * @param e
     * @throws UnsupportedOperationEXception
     */
    public void searchde(Bulletin b, Enseignement e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
