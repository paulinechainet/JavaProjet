/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Vue.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author paulinechainet
 */
public class ProjetJAVA {
    private static Connexion bdd;
    private static Graphique G;
    private Login l;
    
    public static Connexion BaseDeDonnee() throws SQLException, ClassNotFoundException
    {
        JOptionPane jop = new JOptionPane();
    String nom = jop.showInputDialog(null, "Veuillez entrer le nom de la base de donnée", "Ouverture base de donnée", JOptionPane.QUESTION_MESSAGE);
    String login = jop.showInputDialog(null, "Veuillez entrer votre login", "Ouverture base de donnée", JOptionPane.QUESTION_MESSAGE);
    String mdp = jop.showInputDialog(null, "Veuillez entrer votre mot de passe", "Ouverture base de donnée", JOptionPane.QUESTION_MESSAGE);
    Connexion c = new Connexion(nom,login,mdp);
    return c;
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
            new Login();
            //new Reporting();
    }
    
}
