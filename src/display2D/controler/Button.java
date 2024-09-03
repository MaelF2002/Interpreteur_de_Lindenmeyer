package src.display2D.controler;

import src.display2D.gui.*;

import java.awt.event.*;
import javax.swing.*;

public class Button extends JButton implements ActionListener {
  private Interface2D interface2D;

  /**
  Cette méthode est le constructeur de la class Button.
  @param title est le String qui sera affiché sur le bouton
  @param interface2D est l'interface2D sur lequel le bouton sera posé
  @ensures this.interface2D == interface2D
*/
  public Button(String title, Interface2D interface2D){
    this.setText(title);
    this.interface2D = interface2D;
    addActionListener(this);
  }

  /**
  Cette méthode sert a être utilisé plus tard avec un Override.
  @param e est l'evenement crée par l'humain
  */
  public void actionPerformed(ActionEvent e){
    //Nothing
  }

  /**
  Cette méthode retourne l'Interface2D dans laquelle se trouve le bouton.
  @ensures resultat == interface2D
  */
  public Interface2D getInterface2d(){
    return this.interface2D;
  }

}
