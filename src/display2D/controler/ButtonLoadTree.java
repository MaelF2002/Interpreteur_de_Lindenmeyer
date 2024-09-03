package src.display2D.controler;

import src.display2D.gui.*;
import src.utilities.*;

import java.awt.event.*;


public class ButtonLoadTree extends Button implements Runnable {
  protected RulesMap rulesGraphics;
  protected LengthField taille;

   /**
  Cette méthode est le constructeur de la class ButtonLoadTree.
  @param title est le String qui sera affiché sur le bouton
  @param interface2D est l'interface2D sur lequel le bouton sera posé
  @param taille est le nombre d'occurence pour le WordGrph qui va être chargé
  @ensures this.taille == taille
  */
  public ButtonLoadTree(String title, Interface2D interface2D, LengthField taille){
    super(title, interface2D);
    this.rulesGraphics = new RulesMap();
    this.rulesGraphics.addRule("F", "forward");
    this.rulesGraphics.addRule("+", "turnLeft");
    this.rulesGraphics.addRule("-", "turnRight");
    this.rulesGraphics.addRule("[", "memorisedPose");
    this.rulesGraphics.addRule("]", "backMemorisedPose");
    this.taille = taille;
  }

  /**
  Cette méthode est le actionPerfomed lorque l'on clique sur le bouton qui lance le thread de chargement du mot.
  @param e arguement obligatoire de la méthode actionPerfomed
  */
  @Override
  public void actionPerformed(ActionEvent e){
    if(this.getInterface2d().getWord() != null){
      Thread thread = new Thread(this);
      thread.start();
    }    
  }
    /**
  Cette méthode est le run du thread qui est lancé depuis le actionPerformed du bouton qui charge un wordGraph.
  */
  @Override
  public void run(){
    this.getInterface2d().setWordGraph(this.rulesGraphics, taille.setOccu());
  }
    
}


