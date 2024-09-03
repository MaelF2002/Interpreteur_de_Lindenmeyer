package src.display2D.controler;

import java.util.ArrayList;

import src.display2D.gui.*;
import src.display2D.utilities.*;
import src.display2D.view.*;

import java.awt.event.*;


public class Clicklistener implements MouseListener{
    private ArrayList<Integer> treeRoot = new ArrayList<Integer>();
    private Interface2D itf2D;
    private TreePanel treePanel;

    /**
  Cette méthode est le constructeur de la classe Clicklistener.
  @param treePanel est le panel où sont récuperer les click
  @param itf2D est l'interface principale où est posé treePanel
  @ensures this.treePanel = treePanel
  @ensures this.itf2D = itf2D
  */
    public Clicklistener(TreePanel treePanel, Interface2D itf2D){
        this.treeRoot.add(400);
        this.treeRoot.add(400);
        this.treePanel = treePanel;
        this.itf2D = itf2D;


    }

    /**
  Cette méthode est le mouseClicked de mouseListener qui est lancé en cas de click de souris pour dessiner un arbre.
  @param e l'argument obligatoire de la méthode mouseClicked qui peur notamment servir à récupérer les coordonnées du click
  */
	public void mouseClicked(MouseEvent e){
        setRoot(e.getX() ,e.getY(),e);
        //System.out.println("Coordonée :(" + this.getRootX() + ", " + this.getRootY()+")");
        //System.out.println(this.itf2D.getWord());
        if(this.itf2D.getWordGraph() != null){
            TreeDrawer tree = new TreeDrawer(this.itf2D.getLength(), this.itf2D.getAngle(), this.itf2D.getWordGraph(), this.getRootX(), this.getRootY());
            this.treePanel.setChargedTree(tree);
        }
        this.itf2D.getContentPane().add(this.treePanel);
        this.treePanel.repaint();

    }
     /**
  Cette méthode sert a modifier l'arrayList treeRoot pour mettre les coordonnées x et y du click de la souris
  @param x je sais pas
  @param y je sais pas 
  @param e l'évenement du click de la souris pour récuperer les coordonnées
  @ensures this.treeRoot.get(0) == e.getX()
  @ensures this.treeRoot.get(1) == e.getY()
  */
    public void setRoot(int x,int y,MouseEvent e)
    {
        this.treeRoot.set(0,e.getX());
        this.treeRoot.set(1,e.getY());
    }

     /**
  Cette méthode renvoie le x des coordonnées du click de la souris
  @return this.treeRoot.get(0)
  */
    public int getRootX()
    {
        return this.treeRoot.get(0);
    }
         /**
  Cette méthode renvoie le x des coordonnées du click de la souris
  @return this.treeRoot.get(1)
  */
    public int getRootY()
    {
        return this.treeRoot.get(1);
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}

