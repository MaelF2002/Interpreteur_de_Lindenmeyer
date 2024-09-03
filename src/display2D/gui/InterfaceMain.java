package src.display2D.gui;

import javax.swing.*;
import java.awt.*;


import src.display2D.controler.*;
import src.display2D.view.TreePanel;
import src.utilities.*;


public class InterfaceMain extends Interface2D {

 private InterfacePerso interfPerso;

 private TreePanel treePanel;
 private JPanel buttonPanel;
 private Clicklistener clickListener;

 private JPanel buttonChargeTreePanel;

 private JPanel buttonTreePanel;
 private JPanel buttonTailleTreePanel;
 private JPanel buttonBottomPanel;

 private ButtonWordChoice buttonArbre1;
 private ButtonWordChoice buttonArbre2;
 private ButtonWordChoice buttonArbre3;
 private ButtonWordChoice buttonArbre4;

 private LengthField taille;
 private ButtonLoadTree buttonChargeArbre;
 private JProgressBar progress;

 private ButtonReinit buttonC;
 private ButtonFramePerso buttonFramePerso;


  /**
    Cette méthode est le constructeur de la classe InterfaceMain.
  */
 public InterfaceMain(){
  super();

  //creation de l'interface perso et le cache
  this.interfPerso = new InterfacePerso(this);
  this.interfPerso.setVisible(false);

  //creation des panels pour les button et les arbres
  this.buttonPanel = new JPanel();
  this.buttonPanel.setLayout(new GridLayout(2,1));

  this.treePanel = new TreePanel();
  this.clickListener = new Clicklistener(this.treePanel, this);
  this.treePanel.addMouseListener(clickListener);

  //creation des buttons
  this.buttonTreePanel = new JPanel();
  this.buttonTreePanel.setLayout(new GridLayout(2,2));
  this.buttonArbre1 = new ButtonWordChoice("Arbre Contextuel",1,25.75, 1,this);
  this.buttonArbre2 = new ButtonWordChoice("Arbre Touffu",1,20, 2,this);
  this.buttonArbre3 = new ButtonWordChoice("Arbre Ficus",1,25.7, 3,this);
  this.buttonArbre4 = new ButtonWordChoice("Arbre Stochastique",1,20, 4,this);
  this.buttonTreePanel.add(buttonArbre1);
  this.buttonTreePanel.add(buttonArbre2);
  this.buttonTreePanel.add(buttonArbre3);
  this.buttonTreePanel.add(buttonArbre4);
  this.buttonPanel.add(this.buttonTreePanel);
  this.buttonC = new ButtonReinit("C", this, this.treePanel);
  this.buttonFramePerso = new ButtonFramePerso("Frame Perso", this);
  this.taille = new LengthField();
  this.buttonChargeArbre = new ButtonLoadTree("Charger",this, this.taille);



  //mise en place des boutons
  this.buttonChargeTreePanel = new JPanel();
  this.buttonChargeTreePanel.setLayout(new GridLayout(3,1));

  this.buttonTailleTreePanel = new JPanel();
  this.buttonTailleTreePanel.setLayout(new GridLayout(1,2));

  this.buttonTailleTreePanel.add(this.taille);
  this.buttonTailleTreePanel.add(this.buttonChargeArbre);
  this.buttonChargeTreePanel.add(this.buttonTailleTreePanel);

  this.progress =  new JProgressBar(0,1000);
  this.progress.setValue(0);
  this.buttonChargeTreePanel.add(this.progress);

  this.buttonBottomPanel = new JPanel();
  this.buttonBottomPanel.setLayout(new GridLayout(1,2));

  this.buttonBottomPanel.add(buttonC);
  this.buttonBottomPanel.add(buttonFramePerso);

  this.buttonChargeTreePanel.add(this.buttonBottomPanel);

  this.buttonPanel.add(buttonChargeTreePanel);

  this.add(this.buttonPanel);
  this.add(this.treePanel);

  this.setLayout(new BorderLayout());

  this.getContentPane().add(buttonPanel,BorderLayout.WEST);
  this.getContentPane().add(treePanel,BorderLayout.CENTER);

  this.getContentPane().setBackground(Color.gray);

  this.setVisible(true);


  }

  /**
    Cette méthode retourne le champs textuel pour la taille des arbres.
    @ensures résultat == this.taille
    @return la taille de l'arbre à charger
  */
  public JTextField getLengthTextField(){
    return this.taille;
  }


  /**
    Cette méthode retourne la barre de chargement des arbres.
    @ensures résultat == this.progress
    @return la progress bar de chargement de l'arbre
  */
  public JProgressBar getProgressBar(){
    return this.progress;
  }

  /**
    Cette méthode change la largeur de la fênetre.
    @param rulesGraphics regles pour l'affichage de l'arbre
    @param occu hauteur de l'arbre
    @requires rulesGraphics != null
    @requires occu >= 0
    @ensures wordGraph == new Word(this.word.getWord(), rulesGraphics, this.wordBackUp)
  */
  @Override
  public void setWordGraph(RulesMap rulesGraphics, int occu){
    //si la hauteur est >0 alors transforme le mot à chaque occurence
    if(occu-this.word.getOccu() > 0){
      this.word.readAndApplyRulesToWord(occu-this.word.getOccu(), this.progress);

    }
    // creation du mot graphique en fonction du mot si-dessus
    this.wordGraph = new Word(this.word.getWord(), rulesGraphics, this.wordBackUp);
    //System.out.println("C'est charger2");
  }

  /**
    Cette méthode retourne l'interface de personnalisation des arbres.
    @ensures résultat == this.interfPerso
    @return l'interfPerso de la frame
  */
  @Override
  public InterfacePerso getInterfacePerso(){
    return this.interfPerso;
  }


  /**
    Cette méthode affiche l'interface de personnalisation des arbres.
    @ensures interfPerso.isVisible() == true
  */
  @Override
  public void afficheFramePerso(){
    System.out.println("affiche la frame");
    this.interfPerso.setVisible(true);
  }



}
