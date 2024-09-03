package src.display2D.controler;


import src.display2D.gui.*;
import src.utilities.*;
import java.awt.event.*;

public class ButtonWordChoicePerso extends ButtonWordChoice {
    private InterfacePerso interfacePerso;
    
    /**
  Cette méthode est le constructeur de la classe ButtonWordChoicePerso.
  @param title est le String qui sera affiché sur le bouton
  @param interface2D est l'interface2D principale  
  @param interfacePerso est l'interface2D sur lequel le bouton sera posé
  @ensures this.interfacePerso == interfacePerso
  */
    public ButtonWordChoicePerso(String title, Interface2D interface2D ,  InterfacePerso interfacePerso){
        super(title, 1, 0, 0, interface2D);
        this.interfacePerso = interfacePerso;
    }

    /**
  Cette méthode est le actionPerformed du bouton .
  @param e l'argument obligatoire pour la méthode actionPerformed
  */
    @Override
    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);
    }


    /**
  Cette méthode sert à créer un nouveau mot avec les différentes entrées des textField de la framePerso.
  */
    @Override
    public void setWord(){
        this.interfacePerso.setRules();
        super.setBranchLength(1);
        super.setAngle(Integer.parseInt(this.interfacePerso.getAngleTxt()));
        this.word = new Word(this.interfacePerso.getAxiumTxt(), this.interfacePerso.getRules(), super.getInterface2d().getWordBackUp());
    }

}