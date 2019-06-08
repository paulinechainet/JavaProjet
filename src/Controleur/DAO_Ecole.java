/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import Modele.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author paulinechainet
 */
public  class DAO_Ecole extends DAO<Ecole> {
    public DAO_Ecole(Connection conn) {
        super(conn);
    }

    public boolean create(Discipline obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO ecole (nom) VALUES(?)"
                    );
            statement.setObject(1,obj.getNom(),Types.VARCHAR);  
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Discipline.class.getName()).log(Level.SEVERE, null, ex);
        }
        //en spécifiant bien les types SQL cibles 
        
        return true;
    }  

    @Override
    public boolean create(Ecole obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Ecole obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Ecole obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMaxId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ecole find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
