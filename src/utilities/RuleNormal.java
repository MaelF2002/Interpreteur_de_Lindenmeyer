package src.utilities;



public class RuleNormal extends RuleAbstractClass {
    private String rule;


    /** Constructeur de la class RuleNormal dépendant de RuleAbstractClass
     * @param letter est un String représentant la lettre de la règle
     * @requires letter != null
     * @requires rule != null
     * @ensures this.key == letter
     * @ensures this.rule == rule
     */
    public RuleNormal(String letter, String rule){
        super(letter);

        assert letter != null: "Error: letter is null";
        assert rule != null: "Error: rule is null";

        this.rule = rule;
        
        assert this.getKey().equals(letter): "Error: wrong value for this.key";
        assert this.rule.equals(rule): "Error: wrong value for this.rule";
    }
    
    /** Constructeur de la class RuleNormal dépendant de RuleAbstractClass
     * @param letter est un String représentant la lettre de la règle
     * @requires letter != null
     * @ensures this.key == letter
     * @ensures this.rule == letter
     */
    public RuleNormal(String letter){
        this(letter, letter);

        assert this.getKey().equals(letter): "Error: wrong value for this.key";
        assert this.rule.equals(letter): "Error: wrong value for this.rule";
    }



    //////////////////////////////////////GETTERS

    /** Méthode qui renvoie la règle
     * @ensures resultat == this.rule
     * @return la règle liée à la lettre
     */
    @Override
    public String getRule(){
        String resultat = this.rule;
        assert resultat.equals(this.rule): "Error: wrong value for resultat";
        return resultat;
    }




    //////////////////////////////////////UTILITIES

    /**
     * Ajoute une règle pour la même lettre que celle de la règle en entrée
     * @param rule 
     * @ensures resultat != null
     * @ensures resultat.getKey().equals(this.key)
     * @ensures resultat.getRule(0).equals(rule)
     * @return Une RuleStochastic possédant la même clefs et les mêmes règles
     */
    @Override
    public RuleStochastic addRule(String rule){
        RuleStochastic resultat = new RuleStochastic(this.getKey(), this.getRule(), rule);
        assert resultat != null: "Error: resultat is null";
        assert resultat.getKey().equals(this.getKey()): "Error: wrong key for resultat";
        assert resultat.getRule(0).equals(this.getRule()): "Error: wrong rule for resultat";
        assert resultat.getRule(1).equals(rule): "Error: wrong rule for resultat";
        return resultat;
    }


    /**
     * Renvoie ce qui doit être affiché lorsque l'on veut représenter cet objet par un String
     * @return la représentation en String de l'objet
     */
    @Override
    public String toString(){
        return "La lettre " + this.getKey() + " suit la règle " + this.rule + "\n";
    }


    /**
     * Méthode qui renvoie le type de règle auquel la règle appartient
     * @ensures resultat == "normal"
     * @return Le type sous forme de String
     */
    @Override
    public String type(){
        String resultat = "normal";
        assert resultat.equals("normal"): "Error: wrong value for resultat";
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
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        RuleNormal copy = (RuleNormal) o;
        return this.getKey().equals(copy.getKey()) && this.getRule().equals(copy.getRule());
    }

}
