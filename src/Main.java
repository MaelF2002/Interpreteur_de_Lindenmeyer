package src;

import src.utilities.*;
import src.display2D.gui.*;
import src.display3D.gui.*;

import java.util.*;

public class Main{
  public static void main(String[] args){

    

    System.out.println("Choisissez ce que vous voulez faire:\n  1. Essayer de creer un mot dans le terminal\n  2. Dessiner des arbres en 2D\n  3. Dessiner des arbres en 3D");

    try (Scanner scanner = new Scanner(System.in)) {
      String txt = scanner.nextLine();

      if(txt.equals("1")){
        
        System.out.println("Commencez par entrer les règles que va suivre votre mot: (Appuyez sur entrée sans écrire pour passer l'étape)");

        RulesMap ruleMap = new RulesMap();
        String regle = "test";

        while(!regle.equals("")){
          System.out.println("Ecrire une règle de la forme: ?->??? ou ?<?>?->???");
          regle = scanner.nextLine();
          if(!regle.equals("")){
            ruleMap.addRule(regle);
          }
          
        }


        System.out.println("Maintenant entrez les lettres ignorées par l'amélioration du mot sous les règles contextuelles");

        regle = "test";
        ArrayList<String> ignored = new ArrayList<>();
        while(!regle.equals("")){
          System.out.println("Ecrire une lettre ignorée");
          regle = scanner.nextLine();
          if(!regle.equals("")){
            ignored.add(regle);
          }
          
        }


        
        WordBackUp wBU = new WordBackUp();

        System.out.println("Entrez l'axium de votre mot:");
        String axium = scanner.nextLine();

        

        Word word = new Word(axium, ruleMap, wBU, ignored);

        System.out.println("Entrez le nombre de modification que doit subir votre mot (<20 et >0):");

        int n = -1;
        while(n <= 0 || n >= 20){
          n = Integer.parseInt(scanner.nextLine());  
        }

        word.readAndApplyRulesToWord(n);

        System.out.println("Voici votre mot:");
        System.out.println(word);



      } 
      
      else if(txt.equals("2")){
        System.out.println("Voici un exemple d'arbre en 2D.");
        
        new InterfaceMain();
      } 
      
      else if(txt.equals("3")){

        System.out.println("Voici un exemple d'arbre en 3D.");

        RulesMap regles = new RulesMap();
        //regles.addRule("A","FF+&FF&FF&FF//F");
        regles.addRule("A","B-F+CFC+F-D&F∧D-F+&&CFC+F+B/");
        regles.addRule("B", "A&F^CFB^F^D^^-F-D^|F^B|FC^F^A/");
        regles.addRule("C",  "|D^|F^B-F+C^F^A&&FA&F^C+F+B^F^D/");
        regles.addRule("D", "|CFB-F+B|FA&F^A&&FB-F+B|FC/");

        WordBackUp wBackUp = new WordBackUp();

        Word mot = new Word("A", regles, wBackUp);
        
        mot.readAndApplyRulesToWord(4);

        RulesMap rulesGraphics = new RulesMap();
        rulesGraphics.addRule("F", "forward");
        rulesGraphics.addRule("+", "turnLeft");
        rulesGraphics.addRule("-", "turnRight");
        rulesGraphics.addRule("\\","rollLeft");
        rulesGraphics.addRule("/", "rollRight");
        rulesGraphics.addRule("&", "pitchDown");
        rulesGraphics.addRule("^", "pitchUp");
        rulesGraphics.addRule("|", "turnAround");

        Word motGraph = new Word(mot.getWord(), rulesGraphics, wBackUp);

        new Interface3D(motGraph,90);


      }
    } catch (NumberFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


  }


}
