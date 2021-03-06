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


public class DAO_Annee extends DAO<Annee>{
      
    /**
     *
     * @param conn
     */
    public DAO_Annee(Connection conn) {
        super(conn);
    }
    
    /**
     * 
     * 
     * 
     * 
     * @return 
     */
    @Override
    public boolean create(Annee obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO anneeccolaire VALUES(?)"
                    );
            statement.setObject(1,obj.getId(), Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Annee.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }
/**
 * 
 * 
 *  
 * @return true
 */
    @Override
    public boolean delete(Annee obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM anneescolaire WHERE id="+obj.getId()
                    );
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Annee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
/**
 * 
 * 
 *  
 * @return true 
 */
    @Override
    public boolean update(Annee obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE annneescolaire SET id=? WHERE id=?"
                    );
            statement.setObject(1,obj.getId(), Types.INTEGER);
            
           // statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Annee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
/**
 * 
 * @param id
 * @return max_id
 */
    @Override
    public Annee find(int id) {
        Annee e = null;
        try {
            PreparedStatement statement = this.connect.prepareStatement( "SELECT * FROM anneescolaire WHERE id="+id );
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                e = new Annee(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Annee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }
    /**
     * 
     * 
     * @return max_id
     */
    
        @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM anneescolaire");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Annee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }


}
