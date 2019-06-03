/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author grego
 */
import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;


public class Graphique extends JFrame{
    private JFrame F;
    public Graphique()
    {
        F = new JFrame("Gestion de l'école");
       F.setSize(1000,700);
        F.setLayout(null); 
    }
    public void build()
    {
       F.setVisible(true);
    }
}
