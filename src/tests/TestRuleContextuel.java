package src.tests;


import src.utilities.RuleStochastic;
import src.utilities.RuleContextuel;

import java.util.ArrayList;


public class TestRuleContextuel implements Test{


    public static void launchTest(){

        try{
            //Initialisation de la class
            RuleContextuel ruleTest1 = new RuleContextuel("A<A->BA");
            RuleContextuel ruleTest2 = new RuleContextuel("B>B");
            RuleContextuel ruleTest3 = new RuleContextuel("C<C>C", "CAA");

            //Test getKey()
            assert ruleTest1.getKey().equals("A") : "Test failed: getKeys()";
            assert ruleTest2.getKey().equals("B") : "Test failed: getKeys()";
            assert ruleTest3.getKey().equals("C") : "Test failed: getKeys()";


            //Test getRule()
            assert ruleTest1.getRule().equals("BA") : "Test failed: getRule()";
            assert ruleTest2.getRule().equals("B") : "Test failed: getRule()";
            assert ruleTest3.getRule().equals("CAA") : "Test failed: getRule()";

            //Test getRule(int n)
            assert ruleTest1.getRule(0).equals("BA") : "Test failed: getRule()";
            assert ruleTest2.getRule(0).equals("B") : "Test failed: getRule()";
            assert ruleTest3.getRule(0).equals("CAA") : "Test failed: getRule()";

            //Test getPrevious()
            assert ruleTest1.getPrevious().equals("A") : "Test failed: getPrevious()";
            assert ruleTest2.getPrevious() == null : "Test failed: getPrevious()";
            assert ruleTest3.getPrevious().equals("C") : "Test failed: getPrevious()";

            //Test getNext()
            assert ruleTest1.getNext() == null : "Test failed: getNext()";
            assert ruleTest2.getNext().equals("B") : "Test failed: getNext()";
            assert ruleTest3.getNext().equals("C") : "Test failed: getNext()";
            

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
            assert stochastic1 == null: "Test failed: addRule(String rule)";
        
            RuleStochastic stochastic2 = ruleTest2.addRule("BBB");
            assert stochastic2 == null: "Test failed: addRule(String rule)";

            RuleStochastic stochastic3 = ruleTest3.addRule("CCC");
            assert stochastic3 == null: "Test failed: addRule(String rule)";


            //Test toString()
            assert ruleTest1.toString().equals("La lettre A<A suit la règle BA" + "\n"): "Test failed: toString()";
            assert ruleTest2.toString().equals("La lettre B>B suit la règle B" + "\n"): "Test failed: toString()";
            assert ruleTest3.toString().equals("La lettre C<C>C suit la règle CAA" + "\n"): "Test failed: toString()";


            //Test size()
            assert ruleTest1.size() == 0: "Test failed: size()";
            assert ruleTest2.size() == 0: "Test failed: size()";
            assert ruleTest3.size() == 0: "Test failed: size()";


            //Test type()
            assert ruleTest1.type().equals("contextuel"): "Test failed: type()";
            assert ruleTest2.type().equals("contextuel"): "Test failed: type()";
            assert ruleTest3.type().equals("contextuel"): "Test failed: type()";


            //Test equals()
            RuleContextuel ruleTestEqual = new RuleContextuel("A<A->BA");
            RuleContextuel ruleTestNotEqual = new RuleContextuel("A>A->BA");

            assert ruleTest1.equals(ruleTestEqual): "Test failed: equals(Object o)";
            assert !ruleTest1.equals(ruleTestNotEqual): "Test failed: equals(Object o)";


            System.out.println("RuleContextuel: All tests passed.");

        } catch(Exception e){
            System.out.println(e);
        }
        
    }




   
}