package src.tests;

import src.utilities.*;

import java.util.*;

public class TestWordBackUp implements Test{
    public static void launchTest(){

        try{

            //Initialisation de la class
            WordBackUp wordbu = new WordBackUp();

            

            ArrayList<String> ignored = new ArrayList<String>();
            ignored.add("F");
            ignored.add("+");
            ignored.add("-");
            RulesMap rules1 = new RulesMap();
            rules1.addRule("0<0>0->1");
            rules1.addRule("0<0>1->0");
            rules1.addRule("0<1>0->0");
            rules1.addRule("0<1>1->1F1");
            rules1.addRule("1<0>0->1");
            rules1.addRule("1<0>1->1[+F1F1]");
            rules1.addRule("1<1>0->1");
            rules1.addRule("1<1>1->0");
            rules1.addRule("+->-");
            rules1.addRule("-->+");
            Word word1 = new Word("F0F1F1", rules1, wordbu, ignored);


            RulesMap rules2 = new RulesMap();
            rules2.addRule("F", "FF");
            rules2.addRule("X", "F[+X]F[-X]+X");
            Word word2 = new Word("X", rules2, wordbu);
        
            RulesMap rules3 = new RulesMap();
            rules3.addRule("F", "F[+F]F[-F]F", "F[+F]F", "F[-F]F");
            Word word3 = new Word("F", rules3, wordbu);


            //Test getBackUp()

            assert wordbu.getBackUp().equals(new ArrayList<ArrayList<Word> >()): "Test failed: getBackUp()";

            //Test addWordToList()
            wordbu.addWordToList(word1);
            assert wordbu.getBackUp().get(0).get(0).equals(word1): "Test failed: addWordToList()";
            
            wordbu.addWordToList(word2);
            assert wordbu.getBackUp().get(1).get(0).equals(word2): "Test failed: addWordToList()";
            assert !wordbu.getBackUp().get(0).get(0).equals(word2): "Test failed: addWordToList()";

            word1.readAndApplyRulesToWord(2);
            assert wordbu.getBackUp().get(0).get(2).equals(word1): "Test failed: addWordToList()";


            //Test getLastWordLike()

            assert wordbu.getLastWordLike(word1, 1).equals(word1): "Test failed: getLastWordLike()";
            assert wordbu.getLastWordLike(word3, 1) == null: "Test failed: getLastWordLike()";


            System.out.println("WordBackUp: All tests passed.");


        } catch(Exception e){
            System.out.println(e);
        }


    }


}
