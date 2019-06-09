/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Detail;
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
public class DAO_Detail extends DAO<Detail> {
  /**
   * 
   * @param conn 
   */
    public DAO_Detail(Connection conn) {
        super(conn);
    }
    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean create(Detail obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO detailbulletin (`Bulletin.id`,`Enseignement.id`,`appreciation`,`Moyenne`) VALUES(?,?,?,?)"
                    );
            statement.setObject(1,obj.getBulletin().getId(),Types.INTEGER);
            statement.setObject(2,obj.getEnseignement().getId(),Types.INTEGER);
            statement.setObject(3,obj.getapre(),Types.VARCHAR);

            statement.setObject(4,obj.getMoyenne(),Types.FLOAT);
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Detail.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    /**
     * 
     * @param id
     * @return 
     */  

    @Override
    public Detail find(int id) {
        Detail e = null;
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "SELECT * FROM detailbulletin WHERE id="+id
                    );
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                e = new Detail(rs.getInt("id"));
                DAO_Enseignement ensDAO = new DAO_Enseignement(this.connect);
                DAO_Bulletin bullDAO = new DAO_Bulletin(this.connect);
                e.setEnseignement(ensDAO.find(rs.getInt("Enseignement.id")));
                e.setBulletin(bullDAO.find(rs.getInt("Bulletin.id")));
                e.setapre(rs.getString("Appreciation"));

                e.setMoyenne(rs.getFloat("Moyenne"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Bulletin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }
    /**
     * 
     * @return 
     */
        @Override
    public int getMaxId(){
        int max_id = 0;
        try {
             ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(id) FROM detailbulletin");
             if(result.first())
             {
                 max_id = result.getInt("MAX(id)");
             }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Detail.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return max_id;
    }
/**
 * 
 * @param obj
 * @return 
 */
    @Override
    public boolean delete(Detail obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean update(Detail obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE detailbulletin SET `Bulletin.id`=?,`Enseignement.id`=?,`appreciation`=?,`Moyenne`=? WHERE id=?"
                    );
            statement.setObject(2,obj.getEnseignement().getId(),Types.INTEGER);
            statement.setObject(1,obj.getBulletin().getId(),Types.INTEGER); 
            statement.setObject(3,obj.getapre(),Types.VARCHAR); 

            statement.setObject(4,obj.getMoyenne(),Types.FLOAT);
            statement.setObject(5,obj.getId(),Types.INTEGER);
            
            statement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Detail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
