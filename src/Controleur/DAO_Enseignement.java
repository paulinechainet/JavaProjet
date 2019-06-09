/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Enseignement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulinechainet
 */
public class DAO_Enseignement extends DAO<Enseignement> {
      public DAO_Enseignement(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Enseignement obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO Enseignement (`Classe.id`,`Personne.id`,`Discipline.id`) VALUES(?,?,?)"
                    );
            statement.setObject(1,obj.getClasse().getId(),Types.INTEGER); 
            statement.setObject(2,obj.getPersonne().getId(),Types.INTEGER);
            statement.setObject(3,obj.getDiscipline().getId(),Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Enseignement.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }

    @Override
    public boolean delete(Enseignement obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM Enseignement WHERE id="+obj.getId()
                    );
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Enseignement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public boolean update(Enseignement obj) {
         try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE Enseignement SET `Classe.id`=?,`Personne.id`=?,`Discipline.id`=? WHERE id=?"
                    );
            statement.setObject(1,obj.getClasse().getId(),Types.INTEGER); 
            statement.setObject(2,obj.getPersonne().getId(),Types.INTEGER);
            statement.setObject(3,obj.getDiscipline().getId(),Types.INTEGER); 
            statement.setObject(4,obj.getId(),Types.INTEGER); 
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Enseignement.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return true;
    }

    @Override
    public Enseignement find(int id) {
        Enseignement e = null;
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "SELECT * FROM Enseignement WHERE id="+id
                    );
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                e = new Enseignement(rs.getInt("id"));
                DAO_Classe classDAO = new DAO_Classe(this.connect);
                DAO_Personne enDAO = new DAO_Personne(this.connect);
                DAO_Discipline disDAO = new DAO_Discipline(this.connect);
                e.setClasse(classDAO.find(rs.getInt("Classe.id")));
                e.setPersonne(enDAO.find(rs.getInt("Personne.id")));
                e.setDiscipline(disDAO.find(rs.getInt("Discipline.id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Enseignement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }
    
        @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM Enseignement");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Enseignement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }
}
