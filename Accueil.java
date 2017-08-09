/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;
import static com.sun.glass.ui.Cursor.setVisible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.StringTokenizer;


/**
 *
 * @authorThierry Despax
 * version 2.0
 */
public class Accueil extends JFrame implements ActionListener {
 
/**
* Definition des boutons Connexion Inscription et Quitter
*/
    
private JButton connexion = new JButton ("Connexion");
private JButton inscription = new JButton ("Inscription");    
private JButton quitter = new JButton ("Quitter");     
/**
 * definition de la fenetre d'affichage
 */
    
Accueil () {
setVisible(true); /* affichage */
setTitle("Accueil"); /* titre */
setSize(400,300);  /* taille */
setLocationRelativeTo(null);
this.setLayout(null);

/**
 * Position des zones sur la fenetre d'affichage
 */
connexion.setBounds(50,40,150,20);
inscription.setBounds(50,100,150,20);    
quitter.setBounds(50,160,150,20);

connexion.addActionListener(this);    
inscription.addActionListener(this);
quitter.addActionListener(this);

/**
* Affectation des zones et des boutons sur la fenêtre
*/
 getContentPane().add(connexion);
 getContentPane().add(inscription);
 getContentPane().add(quitter);
 

setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); /* pour arreter le process */

}

/**
 * 
 * @param e = source de l'élément sélectionné (Bouton) 
 *  + Gestion des Boutons pour affichage des fenetres
 **/ 
  
    public void actionPerformed(ActionEvent e) {
      
    Object source = e.getSource();   
      
    if (source==quitter) {
    this.dispose();
    }
    else 
    if (source==inscription){
     Inscription i= new Inscription();
     this.dispose();
   }
    /* if (source==connexion);{
        Connexion c= new Connexion();
     this.dispose();
    } */
    
       
    }

    
    
  
    
    
    
    
}

