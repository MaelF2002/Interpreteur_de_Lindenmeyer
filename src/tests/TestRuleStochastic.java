package src.tests;



import src.utilities.RuleStochastic;

import java.util.ArrayList;


public class TestRuleStochastic implements Test{


    public static void launchTest(){

        
        try{
            //Initialisation de la class
            RuleStochastic ruleTest1 = new RuleStochastic("A", "AA");
            RuleStochastic ruleTest2 = new RuleStochastic("B");
            RuleStochastic ruleTest3 = new RuleStochastic("C", "CC", "CCC");
            RuleStochastic ruleTest4 = new RuleStochastic("D", "DD", "DDD", "DDDD");

            //Test getKey()
            assert ruleTest1.getKey().equals("A") : "Test failed: getKey()";
            assert ruleTest2.getKey().equals("B") : "Test failed: getKey()";
            assert ruleTest3.getKey().equals("C") : "Test failed: getKey()";
            assert ruleTest4.getKey().equals("D") : "Test failed: getKey()";


            //Test getRules()
            ArrayList<String> rule1 = ruleTest1.getRules();
            assert rule1.size() == 1: "Test failed: getRules()";
            assert rule1.get(0) == "AA" : "Test failed: getRules()";

            ArrayList<String> rule2 = ruleTest2.getRules();
            assert rule2.size() == 1: "Test failed: getRules()";
            assert rule2.get(0) == "B" : "Test failed: getRules()";

            ArrayList<String> rule3 = ruleTest3.getRules();
            assert rule3.size() == 2: "Test failed: getRules()";
            assert rule3.get(0) == "CC" && rule3.get(1) == "CCC": "Test failed: getRules()";

            ArrayList<String> rule4 = ruleTest4.getRules();
            assert rule4.size() == 3: "Test failed: getRules()";
            assert rule4.get(0) == "DD" && rule4.get(1) == "DDD" && rule4.get(2) == "DDDD": "Test failed: getRules()";



            //Test getRule()
            assert rule1.contains(ruleTest1.getRule()) : "Test failed: getRule()";
            assert rule2.contains(ruleTest2.getRule()) : "Test failed: getRule()";
            assert rule3.contains(ruleTest3.getRule()) : "Test failed: getRule()";
            assert rule4.contains(ruleTest4.getRule()) : "Test failed: getRule()";

            //Test getRule(int n)
            assert ruleTest1.getRule(0).equals("AA") : "Test failed: getRule()";
            assert ruleTest2.getRule(0).equals("B") : "Test failed: getRule()";
            assert ruleTest3.getRule(0).equals("CC") : "Test failed: getRule()";
            assert ruleTest3.getRule(1).equals("CCC") : "Test failed: getRule()";
            assert ruleTest4.getRule(0).equals("DD") : "Test failed: getRule()";
            assert ruleTest4.getRule(1).equals("DDD") : "Test failed: getRule()";
            assert ruleTest4.getRule(2).equals("DDDD") : "Test failed: getRule()";


    

        


            //Test toString()
            assert ruleTest1.toString().equals("La lettre A suit la règle AA\n"): "Test failed: toString()";
            assert ruleTest2.toString().equals("La lettre B suit la règle B\n"): "Test failed: toString()";
            assert ruleTest3.toString().equals("La lettre C suit la règle CC\n"+"La lettre C suit la règle CCC\n"): "Test failed: toString()";
            assert ruleTest4.toString().equals("La lettre D suit la règle DD\n"+"La lettre D suit la règle DDD\n"+"La lettre D suit la règle DDDD\n"): "Test failed: toString()";


            //Test size()
            assert ruleTest1.size() == 1: "Test failed: size()";
            assert ruleTest2.size() == 1: "Test failed: size()";
            assert ruleTest3.size() == 2: "Test failed: size()";
            assert ruleTest4.size() == 3: "Test failed: size()";



            //Test addRule()
            RuleStochastic stochastic1 = ruleTest1.addRule("AAA");
            assert stochastic1 != null: "Test failed: addRule(String rule)";
            assert stochastic1.size() == 2 : "Test failed: addRule(String rule)";
            assert stochastic1.getKey() == ruleTest1.getKey(): "Test failed: addRule(String rule)";
            assert stochastic1.getRule(0) == ruleTest1.getRule(0) && stochastic1.getRule(1) == ruleTest1.getRule(1): "Test failed: addRule(String rule)";
            
            RuleStochastic stochastic2 = ruleTest2.addRule("BBB");
            assert stochastic2 != null: "Test failed: addRule(String rule)";
            assert stochastic2.size() == 2 : "Test failed: addRule(String rule)";
            assert stochastic2.getKey() == ruleTest2.getKey(): "Test failed: addRule(String rule)";
            assert stochastic2.getRule(0) == ruleTest2.getRule(0) && stochastic2.getRule(1) == ruleTest2.getRule(1): "Test failed: addRule(String rule)";

            RuleStochastic stochastic3 = ruleTest3.addRule("CCC");
            assert stochastic3 != null: "Test failed: addRule(String rule)";
            assert stochastic3.size() == 3 : "Test failed: addRule(String rule)";
            assert stochastic3.getKey() == ruleTest3.getKey(): "Test failed: addRule(String rule)";
            assert stochastic3.getRule(0) == ruleTest3.getRule(0) && stochastic3.getRule(1) == ruleTest3.getRule(1) && stochastic3.getRule(2) == ruleTest3.getRule(2): "Test failed: addRule(String rule)";

            RuleStochastic stochastic4 = ruleTest4.addRule("DDDD");
            assert stochastic4 != null: "Test failed: addRule(String rule)";
            assert stochastic4.size() == 4 : "Test failed: addRule(String rule)";
            assert stochastic4.getKey() == ruleTest4.getKey(): "Test failed: addRule(String rule)";
            assert stochastic4.getRule(0) == ruleTest4.getRule(0) && stochastic4.getRule(1) == ruleTest4.getRule(1) && stochastic4.getRule(2) == ruleTest4.getRule(2) &&stochastic4.getRule(3) == ruleTest4.getRule(3): "Test failed: addRule(String rule)";




            //Test type()
            assert ruleTest1.type().equals("stochastic"): "Test failed: type()";
            assert ruleTest2.type().equals("stochastic"): "Test failed: type()";
            assert ruleTest3.type().equals("stochastic"): "Test failed: type()";
            assert ruleTest4.type().equals("stochastic"): "Test failed: type()";


            //Test equals()
            RuleStochastic ruleTestEqual = new RuleStochastic("D", "DD", "DDD", "DDDD");
            RuleStochastic ruleTestNotEqual = new RuleStochastic("D", "DD", "DDD");
            RuleStochastic ruleTestNotEqual2 = new RuleStochastic("D", "DD", "DDD", "DDD");
            RuleStochastic ruleTestNotEqual3 = new RuleStochastic("D", "DD");

            assert !ruleTest4.equals(ruleTestEqual): "Test failed: equals(Object o)";
            assert !ruleTest4.equals(ruleTestNotEqual): "Test failed: equals(Object o)";
            assert !ruleTest4.equals(ruleTestNotEqual2): "Test failed: equals(Object o)";
            assert !ruleTest4.equals(ruleTestNotEqual3): "Test failed: equals(Object o)";

            ruleTestNotEqual3.addRule("DDD");
            ruleTestNotEqual3.addRule("DDDD");
            assert !ruleTest4.equals(ruleTestNotEqual3): "Test failed: equals(Object o)";

            System.out.println("RuleStochastic: All tests passed.");

        } catch(Exception e){
            System.out.println(e);
        }
        

        
        

    }




   
}