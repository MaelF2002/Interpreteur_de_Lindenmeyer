package src.display2D.view;


import src.display2D.utilities.*;

import javax.swing.*;

import java.awt.*;
import java.util.*;


public class TreePanel extends JPanel{
    private ArrayList<TreeDrawer> treeList;
    private ArrayList<Color> colorList;


    /**
    Cette méthode est le constructeur de la class TreePanel.
    @ensures this.isVisible() == true
    @ensures this.isOpaque() == true
    @ensures this.colorList.size() == 20
  */
    public TreePanel(){
        this.treeList = new ArrayList<TreeDrawer>();
        this.setOpaque(true);
        this.setBackground(Color.gray);
        this.setVisible(true);

        this.colorList = new ArrayList<>();
        for(int i = 1; i < 20; i++){
            //System.out.println(i*20%255 + " " + 255 + " " +0);
            this.colorList.add(new Color(i*100%255, 255, 0));
        }

    }


    /**
    Cette méthode ajoute dans la liste des arbres chargés l'arbre passé en paramètre.
    @param chargedTree qui est l'arbre à rajouter
    @requires chargedTree != null
    @ensures treeList.get(0) == chargedTree
  */
    public void setChargedTree(TreeDrawer chargedTree){
        this.treeList.add(chargedTree);
    }

    /**
      Cette méthode retourne la liste des arbres.
      @return this.treeList
      @ensures résultat == treeList
    */
    public ArrayList<TreeDrawer> getTreeList(){
        return this.treeList;
    }

    /**
      Cette méthode réinitialise le panel où sont dessinés las arbres.
      @ensures treeList.size() == 0
    */
    public void reInit(){
        this.treeList = new ArrayList<TreeDrawer>();
        System.out.println("Reinit");
      }


    @Override
    /**
    Cette méthode sert à dessiner les arbres sur le panel prévu à cet effet.
    @param g qui est la méthode Graphics
    @requires g != null
    @ensures i == treeList.size()
  */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        int i = 0;

        for(TreeDrawer chargedTree: treeList){
            g2D.setColor(this.colorList.get(i%this.colorList.size()));
            chargedTree.paintTree(g2D);
            i++;
        }

    }

}
