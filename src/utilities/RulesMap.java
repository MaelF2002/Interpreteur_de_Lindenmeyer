package src.utilities;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class RulesMap{
  private HashMap<String, ArrayList<RuleAbstractClass>> dicoLetter;

  /**
    Cette méthode est le constructeur de la classe Rules.
    @ensures this.dicoLetter != null && dicoLetter.size() == 0
  */
  public RulesMap(){
    this.dicoLetter = new HashMap<String, ArrayList<RuleAbstractClass>>();
    assert this.dicoLetter != null : "Error: dicoLetter is null";
    assert this.dicoLetter.size() == 0: "Error: this size of dicoLetter is wrong";
  }

  /**
    Cette méthode est le constructeur de la classe Word.
    @param letter est un String représentant une lettre à ajouter aux règles
    @param ruleValue est le String représentant la règle que doit suivre la lettre.
    @requires letter !=null.
    @requires ruleValue !=null.
    @ensures this.dicoLetter.get(letter).get(0).getRule().equals(ruleValue)
  */
  public RulesMap(String letter, String ruleValue){
    this();
    assert letter != null : "Letter Null Exception";
    assert ruleValue != null : "RuleValue Null Exception";
    RuleAbstractClass rn;
    ArrayList<RuleAbstractClass> ruleArray = new ArrayList<>();
    

    if(letter.contains("<") || letter.contains(">")){
      rn = new RuleContextuel(letter, ruleValue);
      ruleArray.add(new RuleNormal(rn.getKey()));
    } else {
      rn = new RuleNormal(letter, ruleValue);
    }
    
    ruleArray.add(rn);
    this.dicoLetter.put(rn.getKey(), ruleArray);
    
    assert this.dicoLetter != null: "Error: this.dicoLetter is null";
    assert this.dicoLetter.size() == 1: "Error: this.dicoLetter has a wrong size";
    assert this.dicoLetter.get(letter).get(0).getRule().equals(ruleValue): "Error: ruleValue is not in the list of rules";

  }


  //////////////////////////////////////GETTERS

  /**
    Fonction qui renvoie le dictionnaire de règles
    @ensures resultat == this.dicoLetter
    @return le dictionnaire des règles
  */
  public HashMap<String, ArrayList<RuleAbstractClass>> getDicoLetter(){
    HashMap<String, ArrayList<RuleAbstractClass>> resultat = this.dicoLetter;
    assert resultat.equals(this.dicoLetter): "Error: wrong value for resultat";
    return resultat;
  }


  /**
    Fonction qui renvoie la liste des règles d'une lettre letter
    @param letter est un String représentant une lettre à ajouter aux règles
    @requires letter != null
    @ensures resultat == null => this.dicoLetter.containsKey(letter) == false
    @ensure resultat == this.dicoLetter.get(letter) => this.dicoLetter.containsKey(letter) == true
    @return une ArrayList contenant la liste des règles d'une letter
  */
  public ArrayList<RuleAbstractClass> getRules(String letter){
    assert letter != null: "Error: letter is null";
    ArrayList<RuleAbstractClass> resultat = dicoLetter.get(letter);

    assert resultat == this.dicoLetter.get(letter): "Error: wrong value for resultat";

    return resultat;
  }

  /**
    Fonction qui renvoie la nième règle d'une lettre letter
    @param letter est un String représentant une lettre à ajouter aux règles
    @param n
    @requires letter != null
    @requires n <= dicoLetter.get(letter).get(0).size()
    @ensures resultat == letter => this.dicoLetter.containsKey(letter) == false
    @ensure resultat == this.dicoLetter.get(letter).getRule(n) => this.dicoLetter.containsKey(letter) == true
    @return un String qui est la règle que suit la lettre
  */
  public String getRule(String letter, int n){
    assert letter != null: "Error: letter is null";
    assert n <= dicoLetter.get(letter).get(0).size() : "Too far in the number of rules"; 

    String resultat;
    if(!this.dicoLetter.containsKey(letter)){
      resultat = letter;

      assert resultat.equals(letter): "Error: wrong value for resultat";

      return resultat;
    }

    resultat = dicoLetter.get(letter).get(0).getRule(n);
    assert resultat.equals(dicoLetter.get(letter).get(0).getRule(n)): "Error: wrong value for resultat";
    return resultat;
  }


  /**
    Fonction qui renvoie la première règle d'une lettre letter
    @param letter est un String représentant une lettre à ajouter aux règles
    @requires letter != null
    @ensures resultat == letter => this.dicoLetter.containsKey(letter) == false
    @ensure resultat == this.dicoLetter.get(letter).getRule(n) => this.dicoLetter.containsKey(letter) == true
    @return un String qui est la règle que suit la lettre
  */
  public String getRule(String letter){
    String resultat;
    if(!this.dicoLetter.containsKey(letter)){
      resultat = letter;

      assert resultat.equals(letter): "Error: wrong value for resultat";

      return resultat;
    }

    resultat = dicoLetter.get(letter).get(0).getRule();
    assert dicoLetter.get(letter).get(0).getRules().contains(resultat):"Error: wrong value for resultat";
    return resultat;
  }




  /**
    Fonction qui renvoie la première règle d'une lettre letter
    @param letter est un String représentant une lettre à ajouter aux règles
    @param prev est un String représentant une lettre avant letter
    @param next est un String représentant une lettre après letter
    @requires letter != null
    @return un String qui est la règle que suit la lettre selon sa position
  */
  public String getRule(String letter, String prev, String next){

    if(prev == null && next == null){
      return "null";
    }


    String letterTxt = letter;

    if(prev != null){
      letterTxt = prev + "<" + letterTxt;
    } if (next != null){
      letterTxt = letterTxt + ">" + next;
    }

    RuleContextuel rc = new RuleContextuel(letterTxt);
    

    if(this.dicoLetter.containsKey(rc.getKey())){  

      //Parcours de l'ensemble des règles de la lettre letter
      for(RuleAbstractClass rule: this.dicoLetter.get(rc.getKey())){

        if(rule.type() == "contextuel"){
          RuleContextuel ruleCopy = (RuleContextuel) rule;
          

          if(ruleCopy.getPrevious().equals(prev) && ruleCopy.getNext().equals(next)){ //Trouve une règle correspondant aux prev et next
            return ruleCopy.getRule();
          }
        }

      }
    }
    return "null";
  }



  /**
    Fonction qui renvoie une liste contenant toutes les lettres suivants une règle
    @ensures listLetters.size() == this.dicoLetter.size()
    @ensures this.dicoLetter.get(listLetters[i]) != null
    @return une ArrayList<String> contenant toutes les lettres suivants une règle
  */
  public ArrayList<String> getAllLetters(){
    ArrayList<String> listLetters = new ArrayList<>();
    for(String letter : dicoLetter.keySet()){ 
      listLetters.add(letter);
    }

    assert listLetters.size() == this.dicoLetter.size(): "Error: wrong size for the listLetters";

    return listLetters;
  }



  //////////////////////////////////////SETTERS



  /**
    Fonction qui ajoute une règle au dictionnaire des règles
    @param letter est un String représentant une lettre à ajouter aux règles
    @param ruleValue est le String représentant la règle que doit suivre la lettre.
    @requires letter !=null
    @requires ruleValue !=null
    @ensures this.dicoLetter.containsKey(letter) == true && this.dicoLetter.get(letter) == ruleValue
  */
  public void addRule(String letter, String ruleValue){
    assert letter != null : "Letter Null Exception";
    assert ruleValue != null : "RuleValue Null Exception";

    //Tests si les règles sont contextuelles
    if(letter.contains("<") || letter.contains(">")){ 
      RuleAbstractClass rc = new RuleContextuel(letter, ruleValue);
      
      if(this.dicoLetter.containsKey(rc.getKey())){
        this.dicoLetter.get(rc.getKey()).add(rc); //Ajout d'une règle contextuelle
      } else {
        ArrayList<RuleAbstractClass> ruleArray = new ArrayList<>();

        ruleArray.add(new RuleNormal(rc.getKey()));

        ruleArray.add(rc);
        this.dicoLetter.put(rc.getKey(), ruleArray);   
        assert this.dicoLetter.containsKey(rc.getKey()) == true: "Error: the letter is not in this.dicoLetter";
      }

    } 
    //Pas des règles contextuelles
    else {

      if(this.dicoLetter.containsKey(letter)){ 
        this.dicoLetter.get(letter).set(0, this.dicoLetter.get(letter).get(0).addRule(ruleValue)); //Ajout d'une règle stochastique
      } else {
        RuleAbstractClass rn;
        ArrayList<RuleAbstractClass> ruleArray = new ArrayList<>();
        

        rn = new RuleNormal(letter, ruleValue);

         ruleArray.add(rn); 
        this.dicoLetter.put(letter, ruleArray);    //Ajout d'une règle normale quand la lettre n'était pas déjà dans le dictionnaire
        assert this.dicoLetter.containsKey(letter) == true: "Error: the letter is not in this.dicoLetter";
      }
    }

    
    
  }

  /**
    Fonction qui ajoute une règle au dictionnaire des règles
    @param letter est un String représentant une lettre à ajouter aux règles
    @requires letter !=null
    @ensures this.dicoLetter.containsKey(letter) == true && this.dicoLetter.get(letter) == letter
  */
  public void addRule(String letter){
    assert letter != null : "Letter Null Exception";
    
    if(letter != ""){
      int indexArrow = letter.indexOf("->");
      if(indexArrow != -1){
        this.addRule(letter.substring(0, indexArrow), letter.substring(indexArrow+2));

      }
      else{
        this.addRule(letter, letter);
        assert this.dicoLetter.containsKey(letter) == true: "Error: the letter is not in this.dicoLette";
      }
    }

    
  }

  /**
    Fonction qui ajoute deux règles au dictionnaire des règles
    @param letter est un String représentant une lettre à ajouter aux règles
    @param ruleValue1 est le String représentant une règle que doit suivre la lettre.
    @param ruleValue2 est le String représentant une règle que doit suivre la lettre.
    @requires letter !=null
    @requires ruleValue1 !=null && ruleValue2 !=null
    @ensures this.dicoLetter.containsKey(letter) == true
  */
  public void addRule(String letter, String ruleValue1, String ruleValue2){
    //Assert déjà effectués dans les autres fonctions
    this.addRule(letter, ruleValue1);
    this.addRule(letter, ruleValue2);
  }

  /**
    Fonction qui ajoute trois règles au dictionnaire des règles
    @param letter est un String représentant une lettre à ajouter aux règles
    @param ruleValue1 est le String représentant une règle que doit suivre la lettre.
    @param ruleValue2 est le String représentant une règle que doit suivre la lettre.
    @param ruleValue3 est le String représentant une règle que doit suivre la lettre.
    @requires letter !=null
    @requires ruleValue1 !=null && ruleValue2 !=null && ruleValue3 !=null
    @ensures this.dicoLetter.containsKey(letter) == true
  */
  public void addRule(String letter, String ruleValue1, String ruleValue2, String ruleValue3){
    //Assert déjà effectués dasn les autres fonctions
    this.addRule(letter, ruleValue1, ruleValue2);
    this.addRule(letter, ruleValue3);
  }

  //////////////////////////////////////PRINTING


  /**
    Fonction qui renvoie la liste des lettres et des règles qu'elles suivent
    @return la représenation des règles.
  */
  public String toString(){
    String texteRules = "";
    for(Map.Entry<String, ArrayList<RuleAbstractClass>> lettre : dicoLetter.entrySet()){
      for(RuleAbstractClass rule: lettre.getValue()){
        texteRules += rule;
      }
      
    }
    return texteRules;
  }




  //////////////////////////////////////UTILITIES

  /**
    Fonction qui supprime une règle au dictionnaire des règles
    @param letter est un String représentant une lettre à ajouter aux règles
    @requires letter !=null && dicoLetter.containsKey(letter) == true
    @ensures this.dicoLetter.containsKey(letter) == false && this.dicoLetter.get(letter) == null
  */
  public void removeRule(String letter){
    assert letter != null : "Letter Null Exception";
    assert this.dicoLetter.containsKey(letter) : "Letter is not in the rules";
    dicoLetter.remove(letter);

    assert this.dicoLetter.containsKey(letter) == false && this.dicoLetter.get(letter) == null: "Error: the rule has not be removed";
  }


  /**
    Fonction qui modifie une règle du dictionnaire des règles
    @param letter est un String représentant une lettre à ajouter aux règles
    @requires letter !=null && dicoLetter.containsKey(letter) == true
  */
  public void modifRule(String letter, String ruleValue){
    assert letter != null : "Letter Null Exception";
    assert ruleValue != null : "RuleValue Null Exception";
    assert this.dicoLetter.containsKey(letter) : "Letter is not in the rules";
    addRule(letter, ruleValue);
  }

  /**
    Fonction qui vérifie si deux objets sont égaux ou non
    @param o est un objet de la class java Object
    @ensures resultat == true => this == o
    @ensures resultat == false => this != o
    @return un booleen, vrai si les deux objets sont égaux et false sinon
  */
  public boolean equals(Object o){
    if(this == o) return true;
    if(o == null || getClass() != o.getClass()) return false;
    for(String letter: this.getAllLetters()){
      if(this.getRules(letter).get(0).size() > 1){
        return false;
      }
    }
    RulesMap copy = (RulesMap) o;
    return this.getDicoLetter().equals(copy.getDicoLetter());
}



}
