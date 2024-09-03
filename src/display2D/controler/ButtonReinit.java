package src.display2D.controler;

import src.display2D.gui.*;
import src.display2D.view.TreePanel;

import java.awt.event.*;


public class ButtonReinit extends Button{
    private TreePanel tree;

  /**
  Cette méthode est le constructeur de la classe ButtonReinit.
  @param title est le String qui sera affiché sur le bouton
  @param interface2D est l'interface2D sur lequel le bouton sera posé
  @param tree est le panel où sont dessinés les arbres
  @ensures this.tree == tree
  */
    public ButtonReinit(String title, Interface2D interface2D, TreePanel tree){
        super(title, interface2D);
        this.tree = tree;
    }

  /**
  Cette méthode est le actionPerformed du bouton de réinitilisation du panel de dessin.
  @param e le paramètre obligatoire de la méthode actionPerformed
  */
    @Override
    public void actionPerformed(ActionEvent e){
      this.getInterface2d().reInit(this.tree);
    }


}