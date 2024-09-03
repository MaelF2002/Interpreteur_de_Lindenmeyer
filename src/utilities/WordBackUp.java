package src.utilities;

import java.util.ArrayList;


public class WordBackUp {
    private ArrayList<ArrayList<Word> > wordList;



    /**
     Cette méthode est le constructeur de la classe WordBackUp.
     @ensures this.wordList != null
     @ensures this.wordList.size() == 0
     */
    public WordBackUp(){
        this.wordList = new ArrayList<ArrayList<Word> >();
        assert this.wordList != null: "Error: this.wordList is null";
        assert this.wordList.size() == 0: "Error: this.wordList has no a size of 0";
    }



    //////////////////////////////////////GETTERS



    /**
     Fonction qui renvoie la liste des mots chargés 
     @ensures resultat == this.wordList
     @return la liste des mots déjà chargés
     */
    public ArrayList<ArrayList<Word> > getBackUp(){
        ArrayList<ArrayList<Word> > resultat = this.wordList;
        assert resultat.equals(this.wordList): "Error: resultat has a wrong value";
        return resultat;
    }
    

    /**
     Fonction qui renvoie le mot le plus proche dans la liste de celui que l'on cherche à former
     @param searched le mot de base que l'on veut modifier
     @param n le nombre de modifications à faire sur le mot
     @requires n > 0
     @ensures resultat == null => aucun mot dans la liste ne correspond à searched
     @return le mot le plus proche dans la liste
     */
    public Word getLastWordLike(Word searched, int n){
        assert n > 0 : "Negatif or Null Occurence Exception";

        for(int i = 0; i < this.wordList.size(); i++){ //parcours des mots du tableau wordList
            if(this.wordList.get(i).get(0).sameStart(searched)){ //Mot avec le meme debut trouvé
                if(this.wordList.get(i).size() > searched.getOccu()+n){ //Mot avec le bon nombre d'occurences trouvé
                    
                    return this.wordList.get(i).get((searched.getOccu()+n));
                }
                return this.wordList.get(i).get(this.wordList.get(i).size()-1);
            }
        }

        return null; //Pas de mot similaire trouvé
    }


    /**
     Fonction qui ajoute le mot mit en argument à la liste this.wordList
     @param wordToAdd le mot que l'on veut ajouter
     @requires wordToAdd != null
     @ensures this.wordList.contains(wordToAdd) => this.wordList.add(wordToAdd)
     */
    public void addWordToList(Word wordToAdd){
        assert wordToAdd != null : "Word null Exception";
        
        for(int i = 0; i < this.wordList.size(); i++){ //Parcours des différents mots du tableau

            for(int j=0; j < this.wordList.get(i).size(); j++){ //Parcours des différentes évolutions de chaque mot

                if(this.wordList.get(i).get(j).sameStart(wordToAdd)){ //Même début
                    if(this.wordList.get(i).size() <= wordToAdd.getOccu()){ //Le mot a ajouter est plus évolué que ceux déjà présents
                        this.wordList.get(i).add((Word) wordToAdd.clone());  //Ajout du mot à la suite
                    }
                    return; //Fin de la fonction
                }
            }
        }
        //Mot non trouvé dans le tableau, ajout du mot
        ArrayList<Word> tmp = new ArrayList<Word>();
        tmp.add(wordToAdd);
        this.wordList.add(tmp);
    }


}
