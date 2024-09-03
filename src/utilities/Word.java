package src.utilities;

import java.util.*;

import javax.swing.*;

public class Word{
  private String word;
  private RulesMap rules;
  private String axium;
  private int occu;
  private WordBackUp backUp;
  private ArrayList<String> ignored = new ArrayList<>();


  /**
    Cette méthode est le constructeur de la classe Word.
    @param word est le mot à modifier.
    @param rules est un objet de la class Rules.
    @param backup est un objet de la class WordBackUp.
    @requires axium !=null.
    @requires rules !=null.
    @requires backUp != null.
    @ensures this.axium == axium
    @ensures this.word == axium
    @ensures this.rules == rules
    @ensures this.occu == 0
    @ensures this.backUp = backUp
  */
  public Word(String axium,RulesMap rules, WordBackUp backUp){
    assert axium != null : "Axium null Error";
    assert rules != null : "Rules null Error";
    assert backUp != null : "WordBackUp null Error";
    
    this.axium = axium;
    this.word=axium;
    this.rules=rules;
    this.occu = 0;
    this.backUp = backUp;

    assert this.axium.equals(axium): "Error: wrong value for this.axium";
    assert this.word.equals(axium): "Error: wrong value for this.word";
    assert this.rules.equals(rules): "Error: wrong value for this.rules";
    assert this.occu == 0: "Error: wrong value for this.occu";
    assert this.backUp.equals(backUp): "Error: wrong value for this.backUp";
  }

  /**
    Cette méthode est le constructeur de la classe Word.
    @param word est le mot à modifier.
    @param rules est un objet de la class Rules.
    @param backup est un objet de la class WordBackUp.
    @param ignored est une liste de lettres qui seront ignorées lors de la modification du mot avec des règles contextuelles
    @requires axium !=null.
    @requires rules !=null.
    @requires backUp != null.
    @requires ignored != null.
    @ensures this.axium == axium
    @ensures this.word == axium
    @ensures this.rules == rules
    @ensures this.occu == 0
    @ensures this.backUp = backUp
    @ensures this.ignored == ignored
  */
  public Word(String axium,RulesMap rules, WordBackUp backUp, ArrayList<String> ignored){
    this(axium, rules, backUp);

    assert ignored != null: "Error: ignored is null";

    this.ignored = ignored;

    assert this.ignored.equals(ignored): "Error: wrong value for this.ignored";
  }

//////////////////////////////////////GETTERS


/**
  Fonction qui renvoie la représentation du mot sous forme de String.
  @ensures resultat == this.word
  @return la représentation du mot sous forme de String.
*/
  public String getWord(){
    String resultat = this.word;
    assert resultat.equals(this.word): "Error: wrong value for resultat";
    return resultat;
  }

  /**
  Fonction qui renvoie les règles liées au mot de class Rules.
  @ensures resultat == this.rules
  @return les règles liées au mot de class Rules.
*/
  public RulesMap getRules(){
    RulesMap resultat = this.rules;
    assert resultat.equals(this.rules): "Error: wrong value for resultat";
    return resultat;
  }

  /**
  Fonction qui renvoie l'axium du mot sous forme de String.
  @ensures resultat == this.axium
  @return l'axium du mot sous forme de String.
*/
  public String getAxium(){
    String resultat = this.axium;
    assert resultat.equals(this.axium): "Error: wrong value for resultat";
    return resultat;
  }

  /**
  Fonction qui renvoie le nombre de fois que le mot a subit la fonction readAndApplyRulesToWord() sous forme d'int.
  @ensures resultat == this.occu
  @return le nombre d'occurence que le mot a été modifié sous forme d'int.
*/
  public int getOccu(){
    int resultat = this.occu;
    assert resultat == this.occu: "Error: wrong value of resultat";
    return resultat;
  }

/**
  Fonction qui renvoie la back Up du mot.
  @ensures resultat == this.backUp
  @return la backUp du mot.
*/
public WordBackUp getBackUp(){
  WordBackUp resultat = this.backUp;
  assert resultat.equals(this.backUp): "Error: wrong value for resultat";
  return resultat;
}


  /**
   * Fonction qui renvoie la liste des lettres ignorées
   * @ensures resultat.equals(this.ignored)
   * @returnla liste des lettres ignorées pour les règles contextuelles
   */
  public ArrayList<String> getIgnored(){
    ArrayList<String> resultat = this.ignored;
    assert resultat.equals(this.ignored): "Error: wrong value for resultat";
    return resultat;
  }


  //////////////////////////////////////SETTERS


  /** 
  Fonction qui définie la liste des lettres ignorées
  @param ignored est la liste des lettres ignorées
  @requires ignored != null
  @ensures this.ignored.equals(ignored)
  */
  public void setIgnored(ArrayList<String> ignored){
    assert ignored != null: "Error: ignored in argument is null";
    this.ignored = ignored;
    assert this.ignored.equals(ignored): "Error: wrong value for the list this.ignored";
  }


  /** 
  Fonction qui modifie le String this.word
  @param str est le nouveau String pour this.word
  @requires str != null
  @ensures this.word == str
  */
  public void setWord(String str){
    assert str != null : "Word null Exception";
    this.word = str;
    assert this.word.equals(str): "Error: wrong value for this.word";
  }

  /**
  Fonction qui modifie l'int this.occu du mot
  @param n est le nouvel int pour this.occu
  @requires n >= 0
  @ensures this.occu == n
   */
  public void setOccu(int n){
    assert n >= 0 : "Negatif Occurence Exception";
    
    this.occu = n;
    assert this.occu == n: "Error: wrong value for this.occu";
  }




  /**
   * Méthode qui modifie l'axium si le nombre d'occurence vaut 0
   * @param axium est le String qui est lworde nouvel axium du mot
   * @requires axium != null
   * @requires this.getOccu() == 0
   * @ensures this.axium == axium
   * @ensures this.word == axium
   */
  public void setAxium(String axium){
    assert axium != null: "Null axium Exception";
    assert this.getOccu() == 0: "Occu is not equals to 0";

    if(this.getOccu() == 0){
      this.axium = axium;
      this.setWord(this.axium);
    }
    
    assert this.axium.equals(axium): "Error: wrong value for this.axium";
    assert this.word.equals(axium): "Error: wrong value for this.word";
    
  }



  //////////////////////////////////////PRINTING

/**
  Fonction qui renvoie le mot.
  @ensures resultat == this.word
  @return la représenation du mot.
*/
public String toString(){
  return this.word;
}

/**
Fonction qui affiche le mot et fait un retour à la ligne.
*/
public void displayString(){
  System.out.println(this.word);
}




//////////////////////////////////////UTILITIES


/**
  Fonction qui renvoie true si deux mots ont le même axium, le même alphabet et suivent les mêmes règles
  @param word mot a comparé avec this
  @requires word!=NULL
  @ensures resultat == true => this.axium == word.axium && this.getRules().equals(word.getRules())
  @ensures resultat == false => !(this.axium == word.axium && this.getRules().equals(word.getRules()))
  @return true si le mot a le même début que notre mot et false sinon
  */
public boolean sameStart(Word word){
  assert word != null : "Word Null Exception";
  
  if(this.getAxium().equals(word.getAxium())){
    if(this.getRules().equals(word.getRules())){
      return true;
    }
  }
  return false;
}


/**
  Fonction qui renvoie true une copie du mot avec les mêmes attributs
  @ensures this.axium == clone.axium
  @ensures this.rules == clone.rules
  @ensures this.backUp == clone.backUp
  @ensures this.word == clone.word
  @ensures this.occu == clone.occu
  @ensures this.ignored == clone.ignored
  @return un mot identique au mot d'origine
  */
public Word clone(){
  Word clone = new Word(this.getAxium(), this.getRules(), this.backUp, this.getIgnored());
  clone.setWord(this.word);
  clone.setOccu(this.occu);

  assert this.axium.equals(clone.getAxium()): "Error: wrong axium for the clone";
  assert this.rules.equals(clone.getRules()): "Error: wrong rules for the clone";
  assert this.backUp.equals(clone.getBackUp()): "Error: wrong backUp for the clone";
  assert this.word.equals(clone.getWord()): "Error: wrong word for the clone";
  assert this.occu == clone.getOccu(): "Error: wrong occu for the clone";
  assert this.getIgnored().equals(clone.getIgnored()): "Error: wrong ignored list";

  return clone;
}


    /**
        Méthode qui vérifie si deux objets sont égaux ou non
        @param o est un objet de la class java Object
        @ensures resultat == true => this == o
        @ensures resultat == false => this != o
        @return un booleen, vrai si les deux objets sont égaux et false sinon
    */
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Word copy = (Word) o;
        return this.getAxium().equals(copy.getAxium()) && this.getRules().equals(copy.getRules()) && this.getWord().equals(copy.getWord()) && this.getBackUp().equals(copy.getBackUp()) && this.getOccu() == copy.getOccu()  && this.getIgnored().equals(copy.getIgnored());
    }






  /**
    La fonction lis le String et applique aux lettres dans l'alphabet les régles définis dans Rules. Et ce n fois.
    @param n nombre d'itérations à effectuer
    @param progress la JProgressBar qui affiche l'avancement de la modification du mot
    @requires n > 0
    @requires progress != null
    @return le mot après application des regles de Rules.
  */
  public void readAndApplyRulesToWord(int n, JProgressBar progress){
    assert n > 0 : "Number of iteration null or negative";
    assert progress != null: "Error: the JProgressBar is null";


    progress.setValue(progress.getMinimum()); //L'évolution de la bar est à 0

    Word clone = this.backUp.getLastWordLike(this, n); //Obtention du mot qui se rapproche le plus de la modification voulue

    if(clone == null){ //Ajout du mot si il n'est pas connu dans la backUp
      this.backUp.addWordToList(this);
    }
    else{
      this.word = clone.getWord(); //Modification automatique du mot s'il un mot proche est trouvé
      n += this.getOccu();
      this.occu = clone.getOccu();
      n -= this.getOccu();
      
    }
    

    
    for(int j=0;j<n;j++){
      //System.out.println(this.word);
      progress.setValue((progress.getMaximum() * j / n  )); //Avancée de la bar de progression
      
      this.occu ++;
      String wordTmp = ""; //Mot avec modification (vide au début)
      String prev = null; 
      String next = null;

      //Parcours du mot pour la modification
      for(int i=0; i < this.word.length(); i++) {
        

        int min = i-1;
        int max = i+1;
        String lettre = word.substring(i, i+1);

        //Modification des lettres precedentes et suivantes
        if(min > 0){
          prev = word.substring(min, min+1);
        } else {
          prev = null;
        }
        if(max+1 < this.word.length()){
          next = word.substring(max, max+1);
        } else {
          next = null;
        }
        
        while((min > 0) && this.ignored.contains(prev)){
          min--;
          prev = word.substring(min, min+1);
        }
        while((max+1 < this.word.length()) && this.ignored.contains(next)){
          max++;
          next = word.substring(max, max+1);
        }
        
        //Vérification pour les règles contextuelles
        if(!this.rules.getRule(lettre, prev, next).equals("null")){
          wordTmp += this.rules.getRule(lettre, prev, next);
        } else {
          wordTmp += this.rules.getRule(lettre); //Modification du mot selon la règle de la lettre
        }

      }

      this.word=wordTmp;
      this.backUp.addWordToList(this); //ajout du nouveau mot à la backUp
    }

    progress.setValue(progress.getMaximum()); //ProgressBar au maximum
  }

  /**
    La fonction lis le String et applique aux lettres dans l'alphabet les régles définis dans Rules. Et ce n fois.
    @param n nombre d'itérations à effectuer
    @requires n > 0
    @return le mot après application des regles de Rules.
  */
  public void readAndApplyRulesToWord(int n){
    assert n > 0: "Error: n must be superior to 0";
    readAndApplyRulesToWord(n, new JProgressBar(0, 0));
  }

  /**
    La fonction lis le String et applique aux lettres dans l'alphabet les régles définis dans Rules. Et ce une fois.
    @return le mot après application des regles de Rules.
  */
  public void readAndApplyRulesToWord(){
    readAndApplyRulesToWord(1);
  }

}