package src.utilities;


import java.util.*;

public abstract class RuleAbstractClass {
    private String key; //Règle dépend du String key

    
    /** Constructeur de la class abstraite RuleAbstractClass
     * @param letter est un String représentant la lettre de la règle
     * @requires letter != null
     * @ensures letter == this.key
     */
    public RuleAbstractClass(String letter){
        assert letter != null: "Error: letter is null";
        this.key = letter;
        assert this.key.equals(letter): "Error: wrong value for this.key";
    }

    //////////////////////////////////////GETTERS

    /** Méthode qui renvoie la clef de la règle
     * @ensures resultat == this.key
     * @return la clef de la règle
     */
    public String getKey(){
        String resultat = this.key;
        assert resultat.equals(this.key): "Error: Wrong resultat";
        return resultat;
    }
    

    /** Méthode qui renvoie la règle
     * @ensures resultat == ""
     * @return la règle liée à la lettre
     */
    public String getRule(){
        String resultat = "";
        assert resultat.equals(""): "Error: Wrong resultat";
        return resultat;
    }


    /**Méthode qui renvoie la règle numéro n de la règle
     * @requires n == 0
     * @ensures resultat == this.getRule()
     * @return La règle numéro n 
     */
    public String getRule(int n){
        assert n == 0: "Error: wrong value for n";
        String resultat = this.getRule();
        assert resultat.equals(this.getRule()): "Error: Wrong resultat";
        return resultat;
    }


    /** Méthode qui renvoie la liste des règles 
     * @ensures liste.size() == 1
     * @ensures liste.get(0) == this.getRule()
     * @return la liste des règles
     */
    public ArrayList<String> getRules(){
        ArrayList<String> liste = new ArrayList<>();
        liste.add(this.getRule());
        assert liste.size() == 1: "Error: wrong size for the liste";
        assert liste.get(0).equals(this.getRule()): "Error: Wrong value for the first element in liste";
        return liste;
    }





    //////////////////////////////////////UTILITIES

    /** Méthode qui renvoie le nombre de règles
     * @ensures resultat == 0
     * @return le nombre de règles
     */
    public int size(){
        int resultat = 0;
        assert resultat == 0: "Error: wrong value for resultat";
        return resultat;
    }

    /**
     * Méthode qui renvoie le type de règle auquel la règle appartient
     * @ensures resultat == "abstract"
     * @return Le type sous forme de String
     */
    public String type(){
        String resultat = "abstract";
        assert resultat.equals("abstract"): "Error: wrong value for resultat";
        return resultat;
    }


    /**
     * Ajoute une règle pour la même lettre que celle de la règle en entrée
     * @param rule 
     * @ensures resultat != null
     * @ensures resultat.getKey().equals(this.key)
     * @ensures resultat.getRule(0).equals(rule)
     * @return Une RuleStochastic possédant la même clefs et les mêmes règles
     */
    public RuleStochastic addRule(String rule){
        RuleStochastic resultat = new RuleStochastic(this.getKey(), rule);
        assert resultat != null: "Error: resultat is null";
        assert resultat.getKey().equals(this.key): "Error: wrong key for resultat";
        assert resultat.getRule(0).equals(rule): "Error: wrong rule for resultat";
        return resultat;
    }


    /**
     * Renvoie ce qui doit être affiché lorsque l'on veut représenter cet objet par un String
     * @return la représentation en String de l'objet RuleAbstractClass
     */
    public String toString(){
        return "La lettre " + this.key + " suit aucune règle";
    }


    /**
        Méthode qui vérifie si deux objets sont égaux ou non
        @param o est un objet de la class java Object
        @ensures resultat == true => this == o
        @ensures resultat == false => this != o
        @return un booleen, vrai si les deux objets sont égaux et false sinon
    */
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        RuleAbstractClass copy = (RuleAbstractClass) o;
        return this.key == copy.getKey();
    }


}
