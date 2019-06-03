/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grego
 */

    public class DAOFactory {
    
    protected static final Connection conn;   
   
    static{
        Connection tmp = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            tmp = DriverManager.getConnection("jdbc:mysql://localhost:8888/ProjetJAVA","root","root");
         }catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
         }
        conn = tmp;
    }
    
 
  /**
  * Retourne un objet Professeur interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Personne(){
    return new DAO_Personne(conn);
  }

  /**
  * Retourne un objet Annee interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Annee(){
    return new DAO_Annee(conn);
  }
  
  /**
  * Retourne un objet Buleltin interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Bulletin(){
    return new DAO_Bulletin(conn);
  }
  
  /**
  * Retourne un objet Classe interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Classe(){
    return new DAO_Classe(conn);
  }
  
  
 
  /**
  * Retourne un objet Discipline interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Discipline(){
    return new DAO_Discipline(conn);
  }
  
  
 
  /**
  * Retourne un objet Evaluation interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Evaluation(){
    return new DAO_Evaluation(conn);
  }
  
 
  /**
  * Retourne un objet Niveau interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Niveau(){
    return new DAO_Niveau(conn);
  }
  
  /**
  * Retourne un objet Trimestre interagissant avec la BDD
  * @return DAO
  */
  public static DAO getDAO_Trimestre(){
    return new DAO_Trimestre(conn);
  }
  public static DAO getDAO_Inscription()
  {
      return new DAO_Inscription(conn);
  }
  
  public static DAO getDAO_Enseignement()
  {
      return new DAO_Enseignement(conn); 
  }
  
    } 
