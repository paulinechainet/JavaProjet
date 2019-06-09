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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grego
 */

public class DAO_Personne extends DAO<Personne>   
{
/**
 * 
 * @param conn 
 */
    public DAO_Personne(Connection conn) {
        super(conn);
    }
    
    /**
     * 
     *  
     * @return boolean
     */
    
    @Override
    public boolean create(Personne obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO Personne (nom,prenom,type) VALUES(?,?,?)"
                    );
            statement.setObject(1,obj.getNom(),Types.VARCHAR); 
            statement.setObject(2,obj.getPrenom(),Types.VARCHAR);
            statement.setObject(3,obj.getType(),Types.INTEGER);
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Personne.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }
    /**
     * 
     *  
     * @return boolean
     */

    @Override
    public boolean delete(Personne obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM Personne WHERE id="+obj.getId()
                    );
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Personne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
/**
 * 
 *  
 * @return  boolean
 */
    @Override
    public boolean update(Personne obj) {
       try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE Personne SET nom=?, prenom=? WHERE id=?"
                    );
            statement.setObject(1,obj.getNom(),Types.VARCHAR); 
            statement.setObject(2,obj.getPrenom(),Types.VARCHAR);
            statement.setObject(3,obj.getId(),Types.INTEGER);
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Personne.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return true;
    }
/**
 * 
 * @param id
 * @return e
 */
    @Override
    public Personne find(int id) {
        Personne e = null;
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "SELECT * FROM Personne WHERE id="+id
                    );
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                e = new Personne(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Personne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }
    /**
     * 
     * @return max_id
     */
        @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM Personne");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Personne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }
}
