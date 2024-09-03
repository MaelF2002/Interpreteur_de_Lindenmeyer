package src.tests;

import src.utilities.*;

import java.util.*;

public class TestWord implements Test{
    public static void launchTest(){

        try{
            //Initialisation de la class
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
            WordBackUp wbu = new WordBackUp();
            Word word1 = new Word("F0F1F1", rules1, wbu, ignored);


            RulesMap rules2 = new RulesMap();
            rules2.addRule("F", "FF");
            rules2.addRule("X", "F[+X]F[-X]+X");
            Word word2 = new Word("X", rules2, wbu);
        
            RulesMap rules3 = new RulesMap();
            rules3.addRule("F", "F[+F]F[-F]F", "F[+F]F", "F[-F]F");
            Word word3 = new Word("F", rules3, wbu);

            

            //Test getWord()
            assert word1.getWord().equals("F0F1F1"): "Test failed: getWord()";
            assert word2.getWord().equals("X"): "Test failed: getWord()";
            assert word3.getWord().equals("F"): "Test failed: getWord()";


            //Test getRules()
            assert word1.getRules().equals(rules1): "Test failed: getRules()";
            assert word2.getRules().equals(rules2): "Test failed: getRules()";
            assert word3.getRules().equals(rules3): "Test failed: getRules()";


            //Test getAxium()
            assert word1.getAxium().equals("F0F1F1"): "Test failed: getAxium()";
            assert word2.getAxium().equals("X"): "Test failed: getAxium()";
            assert word3.getAxium().equals("F"): "Test failed: getAxium()";


            //Test getBackUp()
            assert word1.getBackUp().equals(wbu): "Test failed: getBackUp()";
            assert word2.getBackUp().equals(wbu): "Test failed: getBackUp()";
            assert word3.getBackUp().equals(wbu): "Test failed: getBackUp()";


            //Test getIgnored()
            assert word1.getIgnored().equals(ignored): "Test failed: getIgnored()";
            assert word2.getIgnored().equals(new ArrayList<String>()): "Test failed: getIgnored()";
            assert word3.getIgnored().equals(new ArrayList<String>()): "Test failed: getIgnored()";


            //Test setIgnored()

            word1.setIgnored(new ArrayList<String>());
            assert word1.getIgnored().equals(new ArrayList<String>()): "Test failed: setIgnored()";
            word1.setIgnored(ignored);
            assert word1.getIgnored().equals(ignored): "Test failed: setIgnored()";


            //Test setWord()

            word1.setWord("FFF");
            assert word1.getWord().equals("FFF"): "Test failed: setWord()";
            word1.setWord("F0F1F1");
            assert word1.getWord().equals("F0F1F1"): "Test failed: setWord()";


            //Test setAxium()

            word1.setAxium("FFF");
            assert word1.getAxium().equals("FFF"): "Test failed: setAxium()";
            word1.setAxium("F0F1F1");
            assert word1.getAxium().equals("F0F1F1"): "Test failed: setAxium()";


            //Test toString()

            assert word1.toString().equals(word1.getWord()): "Test failed: toString()";
            assert word2.toString().equals(word2.getWord()): "Test failed: toString()";
            assert word3.toString().equals(word3.getWord()): "Test failed: toString()";


            //Test equals()

            assert word1.equals(word1): "Test failed: equals()";
            assert word2.equals(word2): "Test failed: equals()";
            assert !word1.equals(word2): "Test failed: equals()";
            assert !word2.equals(word3): "Test failed: equals()";


            //Test clone()

            Word word1Bis = word1.clone();
            assert word1Bis.equals(word1): "Test failed: clone()";
            Word word2Bis = word2.clone();
            assert word2Bis.equals(word2): "Test failed: clone()";
            Word word3Bis = word3.clone();
            assert word3Bis.equals(word3): "Test failed: clone()";


            //Test readAndApplyRulesToWord()

            word1.readAndApplyRulesToWord();
            assert word1.getOccu() == 1: "Test failed: readAndApplyRulesToWord()";
            word1.readAndApplyRulesToWord(3);
            assert word1.getOccu() == 4: "Test failed: readAndApplyRulesToWord()";


            //Test getOccu()

            assert word1.getOccu() == 4: "Test failed: getOccu()";
            assert word2.getOccu() == 0: "Test failed: getOccu()";
            word3.readAndApplyRulesToWord(2);
            assert word3.getOccu() == 2: "Test failed: getOccu()";


            //Test setOccu()

            word2.setOccu(10);
            assert word2.getOccu() == 10: "Test failed: setOccu()";
            word2.setOccu(0);
            assert word2.getOccu() == 0: "Test failed: setOccu()";


            //Test sameStart()
            
            assert word1.sameStart(word1Bis): "Test failed: sameStart()";
            assert word2.sameStart(word2Bis): "Test failed: sameStart()";
            assert word3.sameStart(word3Bis): "Test failed: sameStart()";
            assert !word1.sameStart(word2): "Test failed: sameStart()";
            assert !word2.sameStart(word1Bis): "Test failed: sameStart()";







            System.out.println("Word: All tests passed.");

        } catch(Exception e){
            System.out.println(e);
        }


    }


}
