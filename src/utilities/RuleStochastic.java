package src.utilities;


import java.util.*;

public class RuleStochastic extends RuleAbstractClass {
    private ArrayList<String> rules;


    /** Constructeur de la class RuleStochastic dépendant de RuleAbstractClass
     * @param letter est un String représentant la lettre de la règle
     * @requires letter != null
     * @ensures this.key == letter
     * @ensures this.rules.get(0) == letter
     */
    public RuleStochastic(String letter){
        this(letter, letter);

        assert this.getKey().equals(letter): "Error: wrong value for this.key";
        assert this.rules.get(0).equals(letter): "Error: wrong value for this.rules";
    }

    /** Constructeur de la class RuleStochastic dépendant de RuleAbstractClass
     * @param letter est un String représentant la lettre de la règle
     * @param rule est un String représentant la règle à suivre
     * @requires letter != null
     * @requires rule != null
     * @ensures this.key == letter
     * @ensures this.rules.get(0) == rule
     */
    public RuleStochastic(String letter, String rule){
        super(letter);

        assert letter != null: "Error: letter is null";
        assert rule != null: "Error: rule is null";

        this.rules = new ArrayList<>();
        this.rules.add(rule);

        assert this.getKey().equals(letter): "Error: wrong value for this.key";
        assert this.rules.get(0).equals(rule): "Error: wrong value for this.rules";
    }

    /** Constructeur de la class RuleStochastic dépendant de RuleAbstractClass
     * @param letter est un String représentant la lettre de la règle
     * @param rule1 est un String représentant la règle à suivre
     * @param rule2 est un String représentant la règle à suivre
     * @requires letter != null
     * @requires rule1 != null && rule2 != null
     * @ensures this.key == letter
     * @ensures this.rules.get(0) == rule1 && this.rules.get(1) == rule2
     */
    public RuleStochastic(String letter, String rule1, String rule2){
        this(letter, rule1);

        assert letter != null: "Error: letter is null";
        assert rule1 != null: "Error: rule1 is null";
        assert rule2 != null: "Error: rule2 is null";

        this.rules.add(rule2);

        assert this.getKey().equals(letter): "Error: wrong value for this.key";
        assert this.rules.get(0).equals(rule1) && this.rules.get(1).equals(rule2): "Error: wrong value for this.rules";
    }

    /** Constructeur de la class RuleStochastic dépendant de RuleAbstractClass
     * @param letter est un String représentant la lettre de la règle
     * @param rule1 est un String représentant la règle à suivre
     * @param rule2 est un String représentant la règle à suivre
     * @param rule3 est un String représentant la règle à suivre
     * @requires letter != null
     * @requires rule1 != null && rule2 != null && rule3 != null
     * @ensures this.key == letter
     * @ensures this.rules.get(0) == rule1 && this.rules.get(1) == rule2 && this.rules.get(2) == rule3
     */
    public RuleStochastic(String letter, String rule1, String rule2, String rule3){
        this(letter, rule1, rule2);

        assert letter != null: "Error: letter is null";
        assert rule1 != null: "Error: rule1 is null";
        assert rule2 != null: "Error: rule2 is null";
        assert rule3 != null: "Error: rule2 is null";

        this.rules.add(rule3);

        assert this.getKey().equals(letter): "Error: wrong value for this.key";
        assert this.rules.get(0).equals(rule1) && this.rules.get(1).equals(rule2) && this.rules.get(2).equals(rule3): "Error: wrong value for this.rules";
    }



    //////////////////////////////////////GETTERS



    /** Méthode qui renvoie une règle choisie aléatoirement
     * @ensures this.rules.contains(resultat)
     * @return la règle liée à la lettre
     */
    @Override
    public String getRule(){
        String resultat = this.rules.get(new Random().nextInt(this.rules.size()));
        assert this.rules.contains(resultat): "Error: wrong value for resultat";
        return resultat;
    }


    /** Méthode qui renvoie la nième règle choisie
     * @requires n <= this.size()
     * @ensures this.rules.get(n).equals(resultat)
     * @return la règle liée à la lettre
     */
    @Override
    public String getRule(int n){
        assert n <= this.size(): "Error: wrong value for n";
        String resultat = this.rules.get(n);
        assert this.rules.get(n).equals(resultat): "Error: wrong value for resultat";
        return resultat;
    }


    /** Méthode qui renvoie la liste des règles 
     * @ensures liste.size() >= 1
     * @ensures liste.equals(this.rules)
     * @return la liste des règles
     */
    @Override
    public ArrayList<String> getRules(){
        ArrayList<String> liste = this.rules;
        assert liste.size() >= 1: "Error: wrong size for liste";
        assert liste.equals(this.rules): "Error: wrong value of liste";
        return liste;
    }



    //////////////////////////////////////UTILITIES



    /**
     * Ajoute une règle pour la même lettre que celle de la règle en entrée
     * @param rule 
     * @ensures resultat != null
     * @ensures resultat.getKey().equals(this.key)
     * @ensures resultat.size() == this.size() +1 
     * @return Une RuleStochastic possédant la même clefs et les mêmes règles
     */
    @Override
    public RuleStochastic addRule(String rule){
        this.rules.add(rule);
        return this;
    }


    /**
     * Renvoie ce qui doit être affiché lorsque l'on veut représenter cet objet par un String
     * @return la représentation en String de l'objet
     */
    @Override
    public String toString(){
        String res = "";
        for(int i = 0; i < this.rules.size(); i++){
            res += "La lettre " + this.getKey() + " suit la règle " + this.rules.get(i) + "\n";
        }
        return res;
    }


    /** Méthode qui renvoie le nombre de règles
     * @ensures resultat == this.rules.size()
     * @return le nombre de règles
     */
    @Override
    public int size(){
        int resultat = this.rules.size();
        assert resultat == this.rules.size(): "Error: wrong value for resultat";
        return resultat;
    }

    
    /**
     * Méthode qui renvoie le type de règle auquel la règle appartient
     * @ensures resultat == "stochastic"
     * @return Le type sous forme de String
     */
    @Override
    public String type(){
        String resultat = "stochastic";
        assert resultat.equals("stochastic"): "Error: wrong value for resultat";
        return resultat;
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
        return false;
    }

}
