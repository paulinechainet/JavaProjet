/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcv2018;

import java.sql.*;
import java.util.*;

/**
 *
 * @author paulinechainet
 */
public class ProjetJAVA {

 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        String nameDatabase ="ProjetJAVA/";
        String loginDatabase ="root";
        String passwordDatabase="root";
        Connexion c1= new Connexion(nameDatabase, loginDatabase, passwordDatabase);
        
        
       
}
}
