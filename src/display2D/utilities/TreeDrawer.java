package src.display2D.utilities;

import java.util.*;

import src.utilities.Word;

import java.awt.*;

public class TreeDrawer{
 private int branch_length;
 private double angle;
 private Word word;
 private Double x;
 private Double y;

  /**
    Cette méthode est le constructeur de la classe TreeDrawer
    @param branch_length la longueur des branches de l'arbre qui va être dessiné
    @param angle l'angle qu'il y aura entre les branches de l'arbre qui va être dessiné
    @param word le mot qui va servir de schéma de l'arbre qui va être dessiné
    @param x la position x de la racine de l'arbre qui va être dessiné
    @param y la position y de la racine de l'arbre qui va être dessiné
    @ensures branch_length = branch_length
    @ensures angle = angle
    @ensures word = word
    @ensures x = x
    @ensures y = y
    */
   public TreeDrawer(int branch_length,double angle, Word word, double x, double y){
    this.branch_length = branch_length;
    this.angle = angle;
    this.word = word;
    this.x = x;
    this.y = y;
   }


    /**
    Cette méthode retourne un arrayList de Double correspondant au sinus et cosinus d'un angle en degré.
    @param deg l'angle en degré qui va être convertit en sinus et cosinus
    @return angl l'arrayList contenant le sinus et cosinus de l'angle passé en parametre
    */
    public ArrayList<Double> turnAngleOf(Double deg){
      ArrayList<Double> angl = new ArrayList<Double>();
      angl.add(Math.sin(Math.toRadians(deg)));
      angl.add(Math.cos(Math.toRadians(deg)));
    	return angl;
    }


    /**
    Cette méthode dessine un trait en fonction des arguments passé et retourne un arrayList de Double correspondant au coordonnées d'arrivé'.
    @param x la coordonnée x d'où part le trait
    @param y la coordonnée y d'où part le trait
    @param angle l'angle qu'aura le trait
    @param g2D les paramètre graphique permettant de dessiner
    @return forwardCo l'arrayList contenant le x et y d'arrivé du trait ainsi que l'angle que le trait avais en paramètre
    */
    public ArrayList<Double> forward(Double x, Double y, Double angle, Graphics2D g2D){
      ArrayList<Double> newCo = turnAngleOf(angle);
      //System.out.println(angle + " " + newCo);
      newCo.set(0,(x + (newCo.get(0)*this.branch_length)));
      newCo.set(1,(y - (newCo.get(1)*this.branch_length)));

      //System.out.println(newCo);

      g2D.drawLine((int)Math.round(x), (int)Math.round(y), (int)Math.round(newCo.get(0)), (int)Math.round(newCo.get(1)));
      ArrayList<Double> forwardCo = new ArrayList<Double>();
      forwardCo.add(newCo.get(0));
      forwardCo.add(newCo.get(1));
      forwardCo.add(angle);
      return forwardCo;
    }
    
    /**
    Cette méthode dessine un arbre grace aux arguments passé dans le constructeur
    @param g2D les paramètres graphiques permettant de dessiner
    */
    public void paintTree(Graphics2D g2D){
      
      g2D.setStroke(new BasicStroke(1,BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
      
      //System.out.println(this.word + " " + this.branch_length + " " + this.angle + " " + this.x + " " + this.y);


      Stack<ArrayList<Double>> stackCo = new Stack<ArrayList<Double>>();
      ArrayList<Double> lastCo = new ArrayList<Double>();
      lastCo.add(this.x);
      lastCo.add(this.y);
      lastCo.add((double) 0);
      //System.out.println(lastCo);
      
      for (int i = 0; i < this.word.getWord().length(); i++) {

        //System.out.println(this.word.getRules().getRule(Character.toString(this.word.getWord().charAt(i))));

        if (this.word.getRules().getRule(Character.toString(this.word.getWord().charAt(i))) == "forward"){
          lastCo = forward(lastCo.get(0),lastCo.get(1),lastCo.get(2),g2D);
          //System.out.println("Forw: "+lastCo);
        }
        else if (this.word.getRules().getRule(Character.toString(this.word.getWord().charAt(i))) == "memorisedPose") {
          stackCo.push((ArrayList<Double>) lastCo.clone());
          //System.out.println("Save: "+lastCo + "; " + stackCo);
        }
        else if (this.word.getRules().getRule(Character.toString(this.word.getWord().charAt(i))) == "backMemorisedPose") {
          lastCo = stackCo.pop();
          //System.out.println("Get: "+lastCo + "; " + stackCo);
        }
        else if (this.word.getRules().getRule(Character.toString(this.word.getWord().charAt(i))) == "turnLeft"){
          lastCo.set(2,(lastCo.get(2) - this.angle));
        }
        else if (this.word.getRules().getRule(Character.toString(this.word.getWord().charAt(i))) == "turnRight"){
          lastCo.set(2,(lastCo.get(2) + this.angle));
        }
      }
    }
}
