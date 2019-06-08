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
    private int moyenne;
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
public Detail(int id)
    {
        this.id = id;
    }    
    public Detail(int id, Bulletin b, Enseignement e, String a )
    {
      this.appreciation = a;
      this.bulletin = b;
      this.enseignement = e;
      this.id = id;
    }
    public String getapre()
    {
        return this.appreciation;
    }
    public void setapre(String s)
    {
        this.appreciation = s;
                
    }
    public int getId()
    {
        return this.id;
    }
    public void setnb(int n)
    {
        this.nb_notes = n;       
    }
    public void setEnseignement(Enseignement e)
    {
        this.enseignement = e;
    }
    public void setBulletin(Bulletin b)
    {
        this.bulletin = b;
    }
    public Enseignement getEnseignement()
    {
        return this.enseignement;
    }
    public int getnb()
    {
        return this.nb_notes;
    }
    public Bulletin getBulletin()
    {
        return this.bulletin;
    }
    public int getMoyenne()
    {
        return this.moyenne;
    }
    public void setMoyenne(int m)
    {
        this.moyenne = m;
    }

    public void searchde(Bulletin b, Enseignement e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
