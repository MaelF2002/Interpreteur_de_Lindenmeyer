package src.display2D.controler;

import src.display2D.gui.*;

import java.awt.event.*;
import javax.swing.*;

public class ButtonAddRule extends Button {
  private InterfacePerso interface2D;

  /**
  Cette méthode est le constructeur de la class ButtonAddRule.
  @param title est le String qui sera affiché sur le bouton
  @param interface2D est l'interface2D sur lequel le bouton sera posé
  @ensures this.interface2D == interface2D
  */
  public ButtonAddRule(String title, InterfacePerso interface2D){
    super(title, interface2D);
    this.interface2D = interface2D;
  }

  /**
  Cette méthode est l'action a faire lorsque le bouton est cliqué.
  @param e est l'événement performé
  @ensures this.interface2D.getRules.get(0) == (this.interface2D.getRulesArray().get(this.interface2D.getRulesArray().size()-1)).getText()
  */
  public void actionPerformed(ActionEvent e){
    this.interface2D.getRulesArray().add(new JTextField(("?->????")));
    this.interface2D.getRulesPanel().add(this.interface2D.getRulesArray().get(this.interface2D.getRulesArray().size()-1));
    this.interface2D.getRules().addRule((this.interface2D.getRulesArray().get(this.interface2D.getRulesArray().size()-1)).getText());

    this.interface2D.getRulesPanel().revalidate();
    this.interface2D.repaint();
  }


}
