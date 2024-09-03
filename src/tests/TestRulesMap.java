package src.tests;

import src.utilities.*;

import java.util.*;

public class TestRulesMap implements Test{

    public static void launchTest(){

        try{
            //Initialisation de la class
            RulesMap rM1 = new RulesMap();
            RulesMap rM2 = new RulesMap("F", "FFF-F");


            //Test getDicoLetter()

            assert rM1.getDicoLetter().equals(new HashMap<String, ArrayList<RuleAbstractClass>>()): "Test failed: getDicoLetter()";
            HashMap<String, ArrayList<RuleAbstractClass>> testHash = new HashMap<String, ArrayList<RuleAbstractClass>>();
            ArrayList<RuleAbstractClass> testArray = new ArrayList<>();
            testArray.add(new RuleNormal("F", "FFF-F"));
            testHash.put("F", testArray);
            assert rM2.getDicoLetter().equals(testHash): "Test failed: getDicoLetter()";


            //Test getRules()

            assert rM1.getRules("") == null: "Test failed: getRules";
            assert rM2.getRules("F").equals(testArray): "Test failed: getRules";


            //Test getRule()

            assert rM1.getRule("F").equals("F"): "Test failed: getRule";
            assert rM2.getRule("F").equals("FFF-F"): "Test failed: getRule";
            assert rM2.getRule("F", 0).equals("FFF-F"): "Test failed: getRule";
            assert rM2.getRule("G").equals("G"): "Test failed: getRule";
  

            //Test getAllLetters()

            assert rM1.getAllLetters().equals(new ArrayList<>()): "Test failed: getAllLetters";
            ArrayList<String> testArray2 = new ArrayList<>();
            testArray2.add("F");
            assert rM2.getAllLetters().equals(testArray2): "Test failed: getAllLetters()";


            //Test addRule()

            rM1.addRule("F", "FFF-F");
            assert rM1.getDicoLetter().equals(testHash): "Test failed; addRule()";
            rM2.addRule("G", "F");
            ArrayList<RuleAbstractClass> testArray3 = new ArrayList<>();
            testArray3.add(new RuleNormal("G", "F"));
            testHash.put("G", testArray3);
            assert rM2.getDicoLetter().equals(testHash): "Test failed: addRule()";


            //Test removeRule()

            rM1.removeRule("F");
            assert rM1.getDicoLetter().equals(new HashMap<String, ArrayList<RuleAbstractClass>>()): "Test failed: removeRule()";
            rM2.removeRule("G");
            testHash = new HashMap<String, ArrayList<RuleAbstractClass>>();
            testArray = new ArrayList<>();
            testArray.add(new RuleNormal("F", "FFF-F"));
            testHash.put("F", testArray);
            assert rM2.getDicoLetter().equals(testHash): "Test failed: removeRule()";


            //Test equals()

            assert rM1.equals(rM1): "Test failed: equals()";
            assert !rM1.equals(rM2): "Test failed: equals()";
            assert rM2.equals(rM2): "Test failed: equals()";




            System.out.println("RulesMap: All tests passed.");

        } catch(Exception e){
            System.out.println(e);
        }


    }


}
