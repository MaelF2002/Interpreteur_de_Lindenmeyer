package src.utilities;


import java.util.*;

public class RuleContextuel extends RuleAbstractClass {
    private HashMap<String, String> rules;


    /** Constructeur de la class RuleContextuel dépendant de RuleAbstractClass
     * @param letter est un String représentant la lettre de la règle
     * @requires letter != null
     * @requires letter.contains("<") || letter.contains(">")
     * @ensures rules != null
     */
    public RuleContextuel(String letter){
        super(letter.substring(letter.indexOf("<")+1, letter.indexOf("<")+2));
        assert letter != null: "Error: letter is null";
        assert letter.contains("<") || letter.contains(">") : "Error: wrong value for letter, it should contains '<' or '>'";

        this.rules = new HashMap<>();

        String rule = letter.substring(letter.indexOf("<")+1, letter.indexOf("<")+2);

        if(letter.contains("->")){
            rule = letter.substring(letter.indexOf("->")+2);
            letter = letter.substring(0, letter.indexOf("->"));
        }


        this.rules.put("previous", null);
        this.rules.put("next", null);

        if(letter.contains("<")){
            this.rules.put("previous", letter.substring(0, 1));
        }
        if(letter.contains(">")){
            this.rules.put("next", letter.substring(letter.length()-1));
        }

        this.rules.put("value", rule);

        assert this.rules != null: "Error: this.rules equals null";
    }

    /** Constructeur de la class RuleContextuel dépendant de RuleAbstractClass
     * @param letter est un String représentant la lettre de la règle
     * @requires letter != null
     * @requires letter.contains("<") || letter.contains(">")
     * @requires rule != null
     * @ensures rules != null
     */
    public RuleContextuel(String letter, String rule){
        super(letter.substring(letter.indexOf("<")+1, letter.indexOf("<")+2));

        assert letter != null: "Error: letter is null";
        assert letter.contains("<") || letter.contains(">") : "Error: wrong value for letter, it should contais '<' or '>'";
        assert rule != null: "Error: rule is null";

        this.rules = new HashMap<>();

        this.rules.put("previous", null);
        this.rules.put("next", null);

        if(letter.contains("<")){
            this.rules.put("previous", letter.substring(0, 1));
        }
        if(letter.contains(">")){
            this.rules.put("next", letter.substring(letter.length()-1));
        }

        this.rules.put("value", rule);

        assert this.rules != null: "Error: this.rules equals null";
    }




    //////////////////////////////////////GETTERS


    /** Méthode qui renvoie la règle
     * @ensures resultat == this.rules.get("value")
     * @return la règle liée à la lettre
     */
    @Override
    public String getRule(){
        String resultat = this.rules.get("value");
        assert resultat == this.rules.get("value");
        return resultat;
    }

    /** Méthode qui renvoie la liste des règles 
     * @ensures liste.size() == 1
     * @ensures liste.get(0) == this.getRule()
     * @return la liste des règles
     */
    @Override
    public ArrayList<String> getRules(){
        ArrayList<String> liste = new ArrayList<>();
        liste.add(this.getRule());
        assert liste.size() == 1: "Error: wrong size for liste";
        assert liste.get(0).equals(this.getRule()): "Error: wrong value for the first element in liste";
        return liste;
    }


    /**
     * Méthode qui renvoie l'élément nécessaire précédent la lettre subissant la règle
     * @ensures resultat == this.rules.get("previous")
     * @return Le String précédent la lettre pour que la règle fonctionne
     */
    public String getPrevious(){
        String resultat = this.rules.get("previous");
        assert resultat == this.rules.get("previous"): "Error: wrong value for resultat";
        return resultat;
    }

    /**
     * Méthode qui renvoie l'élément nécessaire suivant la lettre subissant la règle
     * @ensures resultat == this.rules.get("next")
     * @return Le String suivant la lettre pour que la règle fonctionne
     */
    public String getNext(){
        String resultat = this.rules.get("next");
        assert resultat == this.rules.get("next"): "Error: wrong value for resultat";
        return resultat;
    }


    //////////////////////////////////////UTILITIES


    /**
     * Ajoute une règle pour la même lettre que celle de la règle en entrée
     * @param rule 
     * @ensures resultat == null
     * @return Une RuleStochastic vallant null
     */
    @Override
    public RuleStochastic addRule(String rule){
        RuleStochastic resultat = null;
        assert resultat == null: "Error: resultat should be null";
        return resultat;
    }


    /**
     * Renvoie ce qui doit être affiché lorsque l'on veut représenter cet objet par un String
     * @return la représentation en String de l'objet
     */
    @Override
    public String toString(){
        String res = "La lettre ";
        if(this.rules.get("previous") != null){
            res += this.rules.get("previous") + "<";
        }
        res += this.getKey();
        if(this.rules.get("next") != null){
            res += ">" + this.rules.get("next");
        }
        res += " suit la règle " + this.rules.get("value") + "\n";
        return res;
    }



    /**
     * Méthode qui renvoie le type de règle auquel la règle appartient
     * @ensures resultat == "contextuel"
     * @return Le type sous forme de String
     */
    @Override
    public String type(){
        String resultat = "contextuel";
        assert resultat.equals("contextuel"): "Error: wrong value for resultat";
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
        RuleContextuel copy = (RuleContextuel) o;
        String next = this.getNext() + "";
        String prev = this.getPrevious() + "";
        String nextCop = copy.getNext() + "";
        String prevCop = copy.getPrevious() + "";
        //System.out.println(this.getKey().equals(copy.getKey()) + ";" + next.equals(nextCop) + ";" + prev.equals(prevCop)+ ";" +this.getRule().equals(copy.getRule()));
        return this.getKey().equals(copy.getKey()) && next.equals(nextCop) && prev.equals(prevCop) && this.getRule().equals(copy.getRule());
    }

}
