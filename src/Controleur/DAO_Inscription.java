/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Classe;
import Modele.Inscription;
import Modele.Personne;
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

public class DAO_Inscription extends DAO<Inscription>{
    
    public DAO_Inscription(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Inscription obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO `inscription`(`id`, `Personne.id`,`Classe.id`) VALUES(?,?,?)"
                    );
            statement.setObject(1,obj.getId(),Types.INTEGER); 
            statement.setObject(2,obj.getPersonne().getId(),Types.INTEGER); 
            statement.setObject(3,obj.getClasse().getId(),Types.INTEGER);
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Inscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(Inscription obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM inscription WHERE id="+obj.getId()
                    );
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Inscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public boolean update(Inscription obj) {
         try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE inscription SET `Classe.id`=?,`Personne.id`=? WHERE id=?"
                    );
            statement.setObject(2,obj.getPersonne().getId(),Types.INTEGER); 
            statement.setObject(1,obj.getClasse().getId(),Types.INTEGER);
            statement.setObject(3,obj.getId(),Types.INTEGER);
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Inscription.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
    

    @Override
    public Inscription find(int id) {
        Inscription e = null;
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "SELECT * FROM inscription WHERE id="+id
                    );
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                e = new Inscription(rs.getInt("id"));
                DAO_Personne personneDAO = new DAO_Personne(this.connect);
                DAO_Classe classDAO = new DAO_Classe(this.connect);
                e.setPersonne(personneDAO.find(rs.getInt("Personne.id")));
                e.setClasse(classDAO.find(rs.getInt("Classe.id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Inscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }
    
        @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM inscription");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Inscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }
}
