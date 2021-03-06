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


public class DAO_Evaluation extends DAO<Evaluation>{
    
    public DAO_Evaluation(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Evaluation obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO evaluation (`note`,`appreciation`,`DetailBulletin.id`,`Enseignement.id`) VALUES(?,?,?,?)"
                    );
            statement.setObject(1,obj.getNote(),Types.INTEGER); 
            statement.setObject(2,obj.getAppreciation(),Types.VARCHAR);
            statement.setObject(3,obj.getBulletin().getId(),Types.INTEGER); 
            statement.setObject(4,obj.getEnseignant().getId(),Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Evaluation.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(Evaluation obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM evaluation WHERE evaluation.id="+obj.getId()
                    );
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Evaluation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public boolean update(Evaluation obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE evaluation SET note=?,`appreciation`=?,`DetailBulletin.id`=?,`Enseignement.id`=? WHERE id=?"
                    );
            statement.setObject(1,obj.getNote(),Types.INTEGER); 
            statement.setObject(2,obj.getAppreciation(),Types.VARCHAR);
            statement.setObject(3,obj.getBulletin().getId(),Types.INTEGER); 
            statement.setObject(4,obj.getEnseignant().getId(),Types.INTEGER);
            statement.setObject(5,obj.getId(),Types.INTEGER);
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Evaluation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public Evaluation find(int id) {
        Evaluation e = null;
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "SELECT * FROM evaluation WHERE evaluation.id="+id
                    );
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                e = new Evaluation(rs.getInt("id"),rs.getInt("note"),rs.getString("appreciation"));
                DAO_Detail buDAO = new DAO_Detail(this.connect);

                DAO_Enseignement enDAO = new DAO_Enseignement(this.connect);
                e.setBulletin(buDAO.find(rs.getInt("DetailBulletin.id")));
                e.setEnseignant(enDAO.find(rs.getInt("Enseignement.id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Evaluation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }
    
        @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM evaluation");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Evaluation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }
}