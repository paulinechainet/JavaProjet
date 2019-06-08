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
public class DAO_Bulletin extends DAO<Bulletin> {
  
    public DAO_Bulletin(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Bulletin obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO Bulletin (Inscription.id,Trimestre.id,appreciation) VALUES(?,?,?)"
                    );
            statement.setObject(1,obj.getInscription().getId(),Types.INTEGER);
            statement.setObject(2,obj.getTrimestre().getId(),Types.INTEGER);
            statement.setObject(3,obj.getapre(),Types.VARCHAR); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Bulletin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public boolean delete(Bulletin obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM bulletin WHERE bulletin.id="+obj.getId()
                    );
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Bulletin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public boolean update(Bulletin obj) {
         try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE bulletin SET `Inscription.id`=?,`Trimestre.id`=? WHERE id=?"
                    );
            statement.setObject(1,obj.getInscription().getId(),Types.INTEGER);
            statement.setObject(2,obj.getTrimestre().getId(),Types.INTEGER); 
            statement.setObject(3,obj.getId(),Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Bulletin.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return true;
    }

    @Override
    public Bulletin find(int id) {
        Bulletin e = null;
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "SELECT * FROM bulletin WHERE bulletin.id="+id
                    );
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                e = new Bulletin(rs.getInt("id"));
                DAO_Inscription inscriDAO = new DAO_Inscription(this.connect);
                DAO_Trimestre trimDAO = new DAO_Trimestre(this.connect);
                e.setInscription(inscriDAO.find(rs.getInt("Inscription.id")));
                e.setTrimestre(trimDAO.find(rs.getInt("Trimestre.id")));
                e.setapre(rs.getString("Appreciation"));
                e.setmoy(rs.getInt("Moyenneg"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Bulletin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }
    
        @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM bulletin");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Bulletin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }
}

