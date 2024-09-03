package src.display2D.controler;

import src.display2D.gui.*;
import src.display2D.utilities.*;
import src.utilities.*;
import java.awt.event.*;

public class ButtonWordChoice extends Button{
    protected int length;
    protected int choiceTree;
    protected double angle;
    protected Word word;

        /**
  Cette méthode est le constructeur de la classe ButtonWordChoice.
  @param title est le String qui sera affiché sur le bouton
  @param branch_length est la longueur des branches de l'arbre
  @param angle est l'angle qu'il y aura entre chaque branche 
  @param choiceTree est le numéro qui va définir quel arbre est choisi
  @param interface2D est l'interface2D sur lequel le bouton sera posé
  @ensures this.length == branch_length
  @ensures this.angle == angle
  @ensures this.choiceTree == choiceTree
  */
    public ButtonWordChoice(String title, int branch_length, double angle, int choiceTree, Interface2D interface2D){
        super(title, interface2D);
        this.length = branch_length;
        this.angle = angle;
        this.choiceTree = choiceTree;
        addActionListener(this);
    }

          /**
  Cette méthode est le actionPerfomed du bouton pour choisir un des 4 arbres prédéfinis.
  @param e le paramètre obligatoire de la méthode actionPerformed
  */
    @Override
    public void actionPerformed(ActionEvent e){
        this.setWord();
        this.getInterface2d().setLength(this.length);
        this.getInterface2d().setAngle(this.angle);
        this.getInterface2d().setWord(this.word);
        //System.out.println(this.length);
        //System.out.println(this.angle);
        //System.out.println(this.getInterface2d().getWord().getRules());
    }
      /**
  Cette méthode sert a crée un nouveau Word en fonction de l'arbre qui a été choisi.
  */
    public void setWord(){
        this.word = new WordAuto(this.getInterface2d().getWordBackUp(), choiceTree);
    }

      /**
  Cette méthode sert a changer la longueur des branches de l'arbre.
  @param length la nouvelle longueur pour les branches
  */
    public void setBranchLength(int length){
        this.length = length;
    }

          /**
  Cette méthode sert a changer l'angle entre les branches de l'arbre.
  @param angle le nouvel angle entre les branches
  */
    public void setAngle(int angle){
        this.angle = angle;
    }

}