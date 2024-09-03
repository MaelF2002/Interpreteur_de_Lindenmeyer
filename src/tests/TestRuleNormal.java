package src.tests;


import src.utilities.RuleNormal;
import src.utilities.RuleStochastic;

import java.util.ArrayList;


public class TestRuleNormal implements Test{




    public static void launchTest(){


        try{
            //Initialisation de la class
            RuleNormal ruleTest1 = new RuleNormal("A", "AA");
            RuleNormal ruleTest2 = new RuleNormal("B");
            RuleNormal ruleTest3 = new RuleNormal("C", "CC");

            //Test getKey()
            assert ruleTest1.getKey().equals("A") : "Test failed: getKeys()";
            assert ruleTest2.getKey().equals("B") : "Test failed: getKeys()";
            assert ruleTest3.getKey().equals("C") : "Test failed: getKeys()";


            //Test getRule()
            assert ruleTest1.getRule().equals("AA") : "Test failed: getRule()";
            assert ruleTest2.getRule().equals("B") : "Test failed: getRule()";
            assert ruleTest3.getRule().equals("CC") : "Test failed: getRule()";

            //Test getRule(int n)
            assert ruleTest1.getRule(0).equals("AA") : "Test failed: getRule()";
            assert ruleTest2.getRule(0).equals("B") : "Test failed: getRule()";
            assert ruleTest3.getRule(0).equals("CC") : "Test failed: getRule()";


            //Test getRules()
            ArrayList<String> rule1 = ruleTest1.getRules();
            assert rule1.size() == 1: "Test failed: getRules()";
            assert rule1.get(0) == ruleTest1.getRule() : "Test failed: getRules()";

            ArrayList<String> rule2 = ruleTest2.getRules();
            assert rule2.size() == 1: "Test failed: getRules()";
            assert rule2.get(0) == ruleTest2.getRule() : "Test failed: getRules()";

            ArrayList<String> rule3 = ruleTest3.getRules();
            assert rule3.size() == 1: "Test failed: getRules()";
            assert rule3.get(0) == ruleTest3.getRule() : "Test failed: getRules()";


            //Test addRule()
            RuleStochastic stochastic1 = ruleTest1.addRule("AAA");
            assert stochastic1 != null: "Test failed: addRule(String rule)";
            assert stochastic1.getKey() == ruleTest1.getKey(): "Test failed: addRule(String rule)";
            assert stochastic1.getRule(0) == ruleTest1.getRule(0) && stochastic1.getRule(1) == "AAA": "Test failed: addRule(String rule)";

            RuleStochastic stochastic2 = ruleTest2.addRule("BBB");
            assert stochastic2 != null: "Test failed: addRule(String rule)";
            assert stochastic2.getKey() == ruleTest2.getKey(): "Test failed: addRule(String rule)";
            assert stochastic2.getRule(0) == ruleTest2.getRule(0) && stochastic2.getRule(1) == "BBB": "Test failed: addRule(String rule)";

            RuleStochastic stochastic3 = ruleTest3.addRule("CCC");
            assert stochastic3 != null: "Test failed: addRule(String rule)";
            assert stochastic3.getKey() == ruleTest3.getKey(): "Test failed: addRule(String rule)";
            assert stochastic3.getRule(0) == ruleTest3.getRule(0) && stochastic3.getRule(1) == "CCC": "Test failed: addRule(String rule)";



            //Test toString()
            assert ruleTest1.toString().equals("La lettre " + "A" + " suit la règle " + "AA" + "\n"): "Test failed: toString()";
            assert ruleTest2.toString().equals("La lettre " + "B" + " suit la règle " + "B" + "\n"): "Test failed: toString()";
            assert ruleTest3.toString().equals("La lettre " + "C" + " suit la règle " + "CC" + "\n"): "Test failed: toString()";


            //Test size()
            assert ruleTest1.size() == 0: "Test failed: size()";
            assert ruleTest2.size() == 0: "Test failed: size()";
            assert ruleTest3.size() == 0: "Test failed: size()";


            //Test type()
            assert ruleTest1.type().equals("normal"): "Test failed: type()";
            assert ruleTest2.type().equals("normal"): "Test failed: type()";
            assert ruleTest3.type().equals("normal"): "Test failed: type()";


            //Test equals()
            RuleNormal ruleTestEqual = new RuleNormal("A", "AA");
            RuleNormal ruleTestNotEqual = new RuleNormal("A");

            assert ruleTest1.equals(ruleTestEqual): "Test failed: equals(Object o)";
            assert !ruleTest1.equals(ruleTestNotEqual): "Test failed: equals(Object o)";


            System.out.println("RuleNormal: All tests passed.");

        } catch(Exception e){
            System.out.println(e);
        }

    }




   
}