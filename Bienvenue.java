
package tp2;

/**
 *
 * @author Thierry Despax
 * @version 2.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Bienvenue extends JFrame implements ActionListener {
  
 
private JTextField zone1 = new JTextField();
private JTextField zone2 = new JTextField();

private JButton quitter = new JButton ("Quitter");
 
/**
 * Définition de la fenetre d'affichage Bienvenue
 */
Bienvenue () {
setVisible(true); /* affichage */
setTitle("Bienvenue"); /* titre */
setSize(400,300);  /* taille */
setLocationRelativeTo(null);
this.setLayout(null);

/**
 * Placement des zones sur la fenêtre
 */
zone1.setBounds(20,20,350,20); 
zone2.setBounds(20,80,350,20); 
quitter.setBounds(20,150,150,20);    
 
/**
 * Ajout d'un écouteur sur le bouton Quitter
 */    
quitter.addActionListener(this);

/**
 * Affectation des zones sur la fenêtre
 */
getContentPane().add(zone1);
getContentPane().add(zone2);
  
getContentPane().add(quitter);
 

setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); /* pour arreter le process */
    
    
}  
    
    
 
/**
 * 
 * @param e = source de l'élément sélectionné (bouton)
 * + Gestion du bouton Quitter
 */
  public void actionPerformed(ActionEvent e) {
       Object source = e.getSource();   
      
      if (source==quitter)
          this.dispose();
      
    }  
      
    
}
