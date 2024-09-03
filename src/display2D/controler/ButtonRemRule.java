package src.display2D.controler;

import src.display2D.gui.*;

import java.awt.event.*;


public class ButtonRemRule extends Button{
  private InterfacePerso interface2D;

    /**
  Cette méthode est le constructeur de la classe ButtonRemRule.
  @param title est le String qui sera affiché sur le bouton
  @param interface2D est l'interface2D sur lequel le bouton sera posé
  @ensures this.interface2D == interface2D
  */
  public ButtonRemRule(String title, InterfacePerso interface2D){
    super(title, interface2D);
    this.interface2D = interface2D;
  }

      /**
  Cette méthode est le actionPerfomed du bouton pour supprimer une règle.
  @param e le paramètre obligatoire de la méthode actionPerformed
  */
  @Override
  public void actionPerformed(ActionEvent e){
    if(this.interface2D.getRulesArray().size() >= 1){
      this.interface2D.getRules().removeRule((this.interface2D.getRulesArray().get(this.interface2D.getRulesArray().size()-1)).getText());
      this.interface2D.getRulesPanel().remove(this.interface2D.getRulesArray().get(this.interface2D.getRulesArray().size()-1));
      this.interface2D.getRulesArray().remove(this.interface2D.getRulesArray().size()-1);
    } 
    this.interface2D.getRulesPanel().revalidate();
    this.interface2D.repaint();
  }


}
