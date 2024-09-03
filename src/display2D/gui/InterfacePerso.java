package src.display2D.gui;

import javax.swing.*;
import java.awt.*;

import src.display2D.controler.*;
import src.utilities.*;

import java.util.*;


public class InterfacePerso extends Interface2D{

    private JPanel axiumChargedPanel, rulesPanel, nbrRulesPanel;

    private JTextField axiumTxt, angleTxt;
    private ButtonWordChoicePerso loadTreeButton;
    private ButtonAddRule addRuleButton;
    private ButtonRemRule remRuleButton;

    private ArrayList<JTextField> rulesArray;

    private RulesMap rules;
    private Interface2D interf2D;


  /**
    Cette méthode est le constructeur de la classe InterfacePerso.
    @ensures interf2D = interf2D
  */
    public InterfacePerso(Interface2D interf2D){
        super();


        this.interf2D = interf2D;


        super.setWidth((int)size.getWidth()/4);
        super.setHeight((int)size.getHeight()/4);
        this.setSize(super.width, super.height);



        this.axiumChargedPanel = new JPanel();
        this.axiumChargedPanel.setBackground(Color.gray);
        this.axiumChargedPanel.setLayout(new GridLayout(3,1));



        this.axiumTxt = new JTextField("Axium");
        this.angleTxt = new JTextField("Angle");
        this.loadTreeButton = new ButtonWordChoicePerso("Load Perso Word", this.interf2D, this);
        this.axiumChargedPanel.add(this.axiumTxt);
        this.axiumChargedPanel.add(this.angleTxt);
        this.axiumChargedPanel.add(this.loadTreeButton);


        this.rulesPanel = new JPanel();
        this.rulesPanel.setLayout(new BoxLayout(rulesPanel, BoxLayout.PAGE_AXIS));
        this.rulesArray = new ArrayList<>();
        this.rules = new RulesMap();




        this.nbrRulesPanel = new JPanel();
        this.nbrRulesPanel.setBackground(Color.gray);
        this.nbrRulesPanel.setLayout(new GridLayout(2,1));

        this.addRuleButton = new ButtonAddRule("+", this);
        this.remRuleButton = new ButtonRemRule("-", this);
        this.nbrRulesPanel.add(this.addRuleButton);
        this.nbrRulesPanel.add(this.remRuleButton);


        this.setLayout(new BorderLayout());

        this.getContentPane().add(axiumChargedPanel,BorderLayout.EAST);
        this.getContentPane().add(rulesPanel,BorderLayout.CENTER);
        this.getContentPane().add(nbrRulesPanel ,BorderLayout.WEST);

        this.getContentPane().setBackground(Color.black);

        this.setVisible(false);
    }



  /**
    Cette méthode ajoute une regle via la saisie de texte.
    @ensures this.rules.dicoLetter == dicoLetter
  */
    public void setRules(){
        this.rules = new RulesMap();
        for(JTextField ruleField: this.getRulesArray()){
            this.rules.addRule(ruleField.getText());
        }
    }

    /**
    Cette méthode renvoie la regle via la saisie de texte.
    @ensures résultat == this.rules
    @return les règles de l'arbre perso
  */
    public RulesMap getRules(){
        return this.rules;
    }
    /**
    Cette méthode renvoie le panel des regles.
    @ensures résultat == this.rulesPanel
    @return le panel des regles
  */
    public JPanel getRulesPanel(){
        return this.rulesPanel;
    }

    /**
    Cette méthode renvoie toutes les regles rentrées dans le textField.
    @ensures résultat == this.rulesArray
    @return la liste de règles
  */
    public ArrayList<JTextField> getRulesArray(){
        return this.rulesArray;
    }

    /**
    Cette méthode renvoie l'axium rentré dans le textField.
    @ensures résultat == this.axiumTxt.getText()
    @return l'axium rentré en parametre
  */
    public String getAxiumTxt(){
        return this.axiumTxt.getText();
    }

    /**
    Cette méthode renvoie l'angle rentré dans le textField.
    @ensures résultat == this.angleTxt.getText()
    @return l'angle rentré en parametre
  */
    public String getAngleTxt(){
        return this.angleTxt.getText();
    }

}
