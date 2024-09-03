package src.display2D.controler;

import src.display2D.gui.*;

import java.awt.event.*;

public class ButtonFramePerso extends Button implements Runnable {


  /**
  Cette méthode est le constructeur de la class ButtonFramePerso.
  @param title est le String qui sera affiché sur le bouton
  @param interface2D est l'interface2D sur lequel le bouton sera posé
  @ensures this.interface2D == interface2D
  */
    public ButtonFramePerso(String title, InterfaceMain interface2D){
        super(title, interface2D);

    }

    /**
    Cette méthode est l'action a faire lorsque le bouton est cliqué.
    @param e l'action performé
    @ensures thread != null
    */
    @Override
    public void actionPerformed(ActionEvent e){
      if(this.getInterface2d().getInterfacePerso().isVisible() == false){
        Thread thread = new Thread(this);
        thread.start();
      }
    }

    /**
    Cette méthode est l'action lancé grace au thread .
    @ensures this.getInterface2d().isVisible() == true
    */
    @Override
    public void run(){
      this.getInterface2d().afficheFramePerso();
    }
}
