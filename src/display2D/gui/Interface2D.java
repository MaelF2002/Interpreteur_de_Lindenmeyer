package src.display2D.gui;

import javax.swing.*;
import java.awt.*;


import src.display2D.view.*;
import src.utilities.*;



public abstract class Interface2D extends JFrame {
 protected Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
 protected int width = (int)Math.round(size.getWidth()/1.4);
 protected int height = (int)Math.round(size.getHeight()/1.4);


 protected int branch_length;
 protected double angle;
 protected Word word;
 protected Word wordGraph;
 protected WordBackUp wordBackUp;




  /**
    Cette méthode est le constructeur de la classe Interface2D.
    @ensures this.branch_length == 0
    @ensures this.angle == 0
    @ensures this.word == null
    @ensures this.wordGraph == null
  */
 public Interface2D(){
  this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  this.setSize(this.width, this.height);
  this.branch_length = 0;
  this.angle = 0;
  this.word = null;
  this.wordGraph = null;
  this.wordBackUp = new WordBackUp();


  this.setLayout(new BorderLayout());

  this.getContentPane().setBackground(Color.white);

  this.setVisible(true);

 }


 /**
    Cette méthode retourne la largeur de la fênetre.
    @ensures résultat == this.width
    @return la largeur de la fênetre.
  */
 public int getFrameWidth(){
   return this.width;
 }

  /**
    Cette méthode retourne la heuteur de la fênetre.
    @ensures résultat == this.height
    @return la heuteur de la fênetre.
  */
 public int getFrameHeight(){
   return this.height;
 }

   /**
    Cette méthode retourne la longueur de la branche.
    @ensures résultat == this.branch_length
    @return la longueur de la branche.
  */
 public int getLength() {
  return this.branch_length;
 }


 /**
    Cette méthode retourne l'angle entre les branches.
    @ensures résultat == this.angle
    @return l'angle entre les branches.
  */
  public double getAngle() {
    return this.angle;
  }

   /**
    Cette méthode retourne le mot de l'arbre.
    @ensures résultat == this.word
    @return le mot de l'arbre.
  */
  public Word getWord() {
    return this.word;
  }

   /**
    Cette méthode retourne le wordGraph de l'arbre.
    @ensures résultat == this.wordGraph
    @return le wordGraph de l'arbre.
  */
  public Word getWordGraph(){
    return this.wordGraph;
  }

 /**
    Cette méthode retourne le wordBackUp de l'arbre.
    @ensures résultat == this.wordBackUp
    @return le wordBackUp de l'arbre.
  */
  public WordBackUp getWordBackUp(){
    return this.wordBackUp;
  }

   /**
    Cette méthode retourne le wordBackUp de l'arbre.
    @ensures résultat == null
    @return null.
  */
  public InterfacePerso getInterfacePerso(){
    return null;
  }





  /**
    Cette méthode change la largeur de la fênetre.
    @param width largeur voulu de la fenêtre
    @requires width > 0
    @ensures width == width
  */
 public void setWidth(int width){
  this.width = width;
 }

   /**
    Cette méthode change la heuteur de la fênetre.
    @param height hauteur voulu de la fenêtre
    @requires height > 0
    @ensures height == height
  */
 public void setHeight(int height){
  this.height = height;
 }

  /**
    Cette méthode change la longueur de branche .
    @param length longueur voulu de la branche
    @requires length > 0
    @ensures length == length
  */
 public void setLength(int length) {
  this.branch_length = length;
}

  /**
    Cette méthode change l'angle entre les branches' .
    @param angle angle voulu entre les branche
    @requires angle > 0
    @ensures angle == angle
  */
public void setAngle(double angle) {
  this.angle = angle;
}


/**
 Cette méthode change le mot de l'arbre' .
 @param word word voulu entre les branche
 @requires word != null
 @ensures word == word
*/
public void setWord(Word word) {
  this.word = word;
}


/**
 Cette méthode change le wordGraph de l'arbre et le charge' .
 @param rulesGraphics les regles voulus pour l'arbre
 @param occu le nombre d'occurence pour la hauteur de l'arbre
 @requires rulesGraphics != null
 @requires occu > 0
 @ensures wordGraph == wordGraph
*/

public void setWordGraph(RulesMap rulesGraphics, int occu){
  //System.out.println(this.word.getRules());
  if(occu-this.word.getOccu() > 0){
    this.word.readAndApplyRulesToWord(occu-this.word.getOccu());

  }
  this.wordGraph = new Word(this.word.getWord(), rulesGraphics, this.wordBackUp);
  //System.out.println("C'est charger");
}


/**
 Cette méthode réinitialise le panel où sont dessinés les arbres' .
 @param treePanel le panel à reinitialiser
*/
public void reInit(TreePanel treePanel){
  treePanel.reInit();
  this.repaint();
  //System.out.println("Repaint");
}


/**
 Cette méthode affiche la frame de personnalisation' .
 @ensures rien ne s'affiche
*/
public void afficheFramePerso(){
}


}
