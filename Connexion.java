 
package tp2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Thierry Despax
 * @version 2.0
 */
public class Connexion extends JFrame implements ActionListener,KeyListener   {
   
private JLabel libemail = new JLabel ("E.mail");
private JTextField email = new JTextField();
private JLabel libmdp = new JLabel ("Mot de Passe");
private JTextField mdp = new JTextField();
 
private JButton connexion = new JButton ("Connexion");
 
/**
 * Déinition de la fenêtre connexion
 */

Connexion () {
setVisible(true); /* affichage */
setTitle("Connexion"); /* titre */
setSize(600,300);  /* taille */
setLocationRelativeTo(null);
this.setLayout(null);

/**
 * Positionnement des zones sur la fenêtre
 */
libemail.setBounds(20,20,150,20);email.setBounds(180,20,150,20);
libmdp.setBounds(20,60,150,20);mdp.setBounds(180,60,150,20);
 
connexion.setBounds(180,150,150,20);    
    
connexion.addActionListener(this);

getContentPane().add(libemail);
getContentPane().add(email);
getContentPane().add(libmdp);
getContentPane().add(mdp);
  
getContentPane().add(connexion);

/**
 * Ajout d'écouteur sur la zone email et mot de passe
 */
email.addKeyListener(this);
mdp.addKeyListener(this);

 /**
  * Désactivation du bouton connexion par défaut
  */
connexion.setEnabled(false); 

setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); /* pour arreter le process */
    
    
}    

/**
 * 
 * @param ae = source de l'élément sélectionné
 * Gestion de l'activation du bouton selon les zones saisies
 * sur les trois méthodes
 */
public void keyTyped (KeyEvent ae){
        
 if(!email.getText().isEmpty()&& !mdp.getText().isEmpty())  
    connexion.setEnabled(true); 
 else {
   connexion.setEnabled(false);  
 }

}

public void keyPressed(KeyEvent ae){
    
 if(!email.getText().isEmpty()&& !mdp.getText().isEmpty())  
    connexion.setEnabled(true); 
 else {
   connexion.setEnabled(false);  
 }

}

public void keyReleased(KeyEvent ae){
    
 if(!email.getText().isEmpty()&& !mdp.getText().isEmpty())  
    connexion.setEnabled(true); 
 else {
   connexion.setEnabled(false);  
 }

}

/**
 * 
 * @param e = source de l'élément sélectionné (bouton)
 * Source non terminé
 */
    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    
   Object source = e.getSource(); 
   String ligne;  
   boolean trouve = false;
         
   try{
    BufferedReader  br = new BufferedReader(new FileReader("membre.txt"));
       
    while ((ligne=br.readLine()) !=null &&!trouve)
    {
              StringTokenizer s= new StringTokenizer(ligne);
              String nomlu= s.nextToken();
              String prenomlu =s.nextToken();
              String maillu = s.nextToken();
              String mdplu = s.nextToken();
              
               if (maillu.compareTo(email.getText())==0 && mdplu.compareTo(mdp.getText())==0 )
                  trouve = true;
                }
     
               if(trouve)
               connexion.setEnabled(true);
               
               
               Bienvenue b= new Bienvenue();
               this.dispose();
   
    }
     
    catch (FileNotFoundException ex) {
     Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
        Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
    }
   
   if(trouve)
               connexion.setEnabled(true);
               
               
               Bienvenue b= new Bienvenue();
               this.dispose();


} 
}
 
   
     

    
    

