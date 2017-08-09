/**
/*  
 */
package tp2;

/**
 *
 * @author Thierry Despax
 * @version 2.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Inscription extends JFrame implements ActionListener,KeyListener {
    
/**
 * Definition des differents zones de la fenetre
 */    
private JLabel libnom = new JLabel ("Nom");
private JTextField nom = new JTextField();
private JLabel libpre = new JLabel ("Prenom");
private JTextField prenom = new JTextField();
private JLabel libmdp = new JLabel ("Mot de Passe");
private JTextField mdp = new JTextField();

private JButton inscription = new JButton ("Inscription");    

static int cpt;
 
/**
 * definition de la fenetre d'affichage
 */
    
Inscription () {
setVisible(true); /* affichage */
setTitle("Inscription"); /* titre */
setSize(600,300);  /* taille */
setLocationRelativeTo(null);
this.setLayout(null);

/**
 * Positionnement des zones sur la fenetre
 */
libnom.setBounds(20,20,150,20);nom.setBounds(180,20,150,20);
libpre.setBounds(20,60,150,20);prenom.setBounds(180,60,150,20);
libmdp.setBounds(20,100,150,20);mdp.setBounds(180,100,150,20);

inscription.setBounds(180,150,150,20);    
 
inscription.addActionListener(this);

nom.addKeyListener(this);
prenom.addKeyListener(this);
mdp.addKeyListener(this);
 

/**
* Affectation des zones et des boutons sur la fenêtre
*/
 getContentPane().add(libnom);
 getContentPane().add(nom);
 getContentPane().add(libpre);
 getContentPane().add(prenom);
 getContentPane().add(libmdp);
 getContentPane().add(mdp);
 
 
 getContentPane().add(inscription);
 inscription.setEnabled(false);

setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); /* pour arreter le process */



}    
 
/**
 * 
 * @param ae source de l'element selectionné
 * Activation du bouton selon les zones sélectionnées
 * sur les trois méthodes
 */
public void keyTyped (KeyEvent ae){
        
 if(!nom.getText().isEmpty()&& !prenom.getText().isEmpty() && !mdp.getText() .isEmpty()) 
    inscription.setEnabled(true); 
 else {
   inscription.setEnabled(false);  
 }

}

public void keyPressed(KeyEvent ae){
    
 if(!nom.getText() .isEmpty()&& !prenom.getText() .isEmpty() && !mdp.getText() .isEmpty()) 
    inscription.setEnabled(true); 
 else {
   inscription.setEnabled(false);  
 }

}

public void keyReleased(KeyEvent ae){
    
 if(!nom.getText() .isEmpty()&& !prenom.getText() .isEmpty() && !mdp.getText() .isEmpty()) 
    inscription.setEnabled(true); 
 else {
   inscription.setEnabled(false);  
 }

}

/**
 * 
 * @param e = source de l'élément sélectionné 
 * 
 * Ecriture dans le fichier membre.txt avec les zones saisies
 * et concaténéees (nom prenom mail mot de passe
 * Constitution de l'email par concaténation de zones
 */
public void actionPerformed(ActionEvent e) {
    String zone;  
    String mail;
   
    Object source = e.getSource();   
      
    if (source==inscription) {
        cpt++;
         
        try{
        BufferedWriter  bw = new BufferedWriter(new FileWriter("membre.txt",true));
        
        mail = nom.getText()+ "." + prenom.getText() + "@mii.fr"; 
        zone= nom.getText() + " " + prenom.getText()+ " " + mail +" " + mdp.getText();
        
        bw.write(zone);
        bw.newLine(); /* pour ecrire à la ligne */
        
        Bienvenue b= new Bienvenue();
        this.dispose();
        
        bw.close() ;
        
             
    }   catch (IOException ex) {
            Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
        }



}
    
}
}
