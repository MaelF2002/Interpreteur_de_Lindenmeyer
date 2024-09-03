package src;

import src.tests.*;


public class Test{
  public static void main(String[] args){

    //Début des tests
    TestRuleNormal.launchTest();
    TestRuleStochastic.launchTest();
    TestRuleContextuel.launchTest();
    TestRulesMap.launchTest();
    TestWord.launchTest();
    TestWordBackUp.launchTest();


  }


}
