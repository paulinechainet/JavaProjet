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
public class DAO_Trimestre extends DAO<Trimestre>{
    
    /**
     * 
     * @param conn 
     */
    public DAO_Trimestre(Connection conn) {
        super(conn);
    }
    /**
     * 
     *  
     * @return 
     */
    @Override
    public boolean create(Trimestre obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO trimestre (numero,debut,fin,id_annee) VALUES(?,?,?,?)"
                    );
            statement.setObject(1,obj.getNumero(),Types.INTEGER);
            statement.setObject(2,obj.getDebut(), Types.INTEGER); 
            statement.setObject(3,obj.getFin(),Types.INTEGER); 
            statement.setObject(4,obj.getAnnee().getId(), Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Trimestre.class.getName()).log(Level.SEVERE, null, ex);
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
    public boolean delete(Trimestre obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM trimestre WHERE trimestre.id="+obj.getId()
                    );
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Trimestre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
/**
 * 
 *  
 * @return 
 */
    @Override
    public boolean update(Trimestre obj) {
         try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE trimestre numero=?,debut=?,fin=?,id_annee=? WHERE trimestre.id=?"
                    );
            statement.setObject(1,obj.getNumero(),Types.INTEGER);
            statement.setObject(2,obj.getDebut(), Types.VARCHAR); 
            statement.setObject(3,obj.getFin(),Types.VARCHAR); 
            statement.setObject(4,obj.getAnnee().getId(),Types.INTEGER); 
            statement.setObject(5,obj.getId(),Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Trimestre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
/**
 * 
 * @param id
 * @return 
 */
    @Override
    public Trimestre find(int id) {
        Trimestre e = null;
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "SELECT * FROM trimestre WHERE trimestre.id="+id
                    );
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                e = new Trimestre(rs.getInt("id"),rs.getInt("numero"),rs.getString("debut"),rs.getString("fin"));
                DAO_Annee anDAO = new DAO_Annee(this.connect);
                e.setAnnee(anDAO.find(rs.getInt("AnneeScolaire.id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Trimestre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }
    /**
     * 
     * @return  max_id
     */
        @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM trimestre");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Trimestre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }
}
