package src.display2D.controler;


import java.awt.event.*;
import javax.swing.*;

public class LengthField extends JTextField implements ActionListener{
    
     /**
  Cette méthode est le constructeur de la classe LengthField
  */
    public LengthField(){
        this.setText("1");
        addActionListener(this);
    }
     /**
  Cette méthode est le actionPerfomed de JTextField et lance la fonction setText
  @param e l'argument obligatoire de la méthode actionPerformed
  */
    public void actionPerformed(ActionEvent e){
        this.setText("");
    }
      
    /**
  Cette méthode sert a modifier le contenu du JTextField
  @param x l'entier que tu veux mettre dans le JTextField
  */
    public void setText(int x){
      this.setText("" + x);
    }
      
   /**
  Cette méthode sert mettre sous format int le conetu de JTextField qui est un String
  @return Integer.parseInt(str) l'entier contenu dans le JTextField
  */       
    public int setOccu(){
        String str = this.getText();
        return Integer.parseInt(str);
    }
 }




