/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import Modele.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grego
 */
public class DAO_Classe extends DAO<Classe>{
   private ArrayList <Classe> cla;
    
  /**
   * 
   * @param conn 
   */
    public DAO_Classe(Connection conn) {
        super(conn);
    }
     /**
      * 
      *  
      * @return 
      */
    @Override
    public boolean create(Classe obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO classe (`nom`,`Niveau.id`,`AnneeScolaire.id`) VALUES(?,?,?)"
                    ); 
            statement.setObject(1,obj.getNom(),Types.VARCHAR); 
            statement.setObject(2,obj.getNiveau().getId(),Types.INTEGER);
            statement.setObject(3,obj.getAnnee().getId(),Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Classe.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }
/**
 * 
 *  
 * @return 
 */
    @Override
    public boolean delete(Classe obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM classe WHERE id="+obj.getId()
                    );
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Classe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
/**
 * 
 * 
 *  
 * @return 
 */
    @Override
    public boolean update(Classe obj) {
         try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE classe SET nom=?,`Niveau.id`=?,`AnneeScolaire.id`=? WHERE id=?"
                    ); 
            statement.setObject(1,obj.getNom(),Types.VARCHAR); 
            statement.setObject(2,obj.getNiveau().getId(),Types.INTEGER);
            statement.setObject(3,obj.getAnnee().getId(),Types.INTEGER); 
            statement.setObject(4,obj.getId(),Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Classe.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return true;
    }
/**
 * 
 * 
 * @param id
 * @return 
 */
    @Override
    public Classe find(int id) {
        Classe e = null;
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "SELECT * FROM classe WHERE classe.id="+id
                    );
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                e = new Classe(rs.getInt("id"),rs.getString("nom"));
                DAO_Niveau nivDAO = new DAO_Niveau(this.connect);
                DAO_Annee anDAO = new DAO_Annee(this.connect);
                e.setNiveau(nivDAO.find(rs.getInt("Niveau.id")));
                e.setAnnee(anDAO.find(rs.getInt("AnneeScolaire.id")));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Classe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }
    /**
     * 
     * 
     * @return 
     */
        @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM classe");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Classe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }
}

