package src.display2D.utilities;

import java.util.ArrayList;

import src.utilities.*;

public class WordAuto extends Word{


    public WordAuto(String axium, RulesMap rules, WordBackUp wordBackUp){
        super(axium, rules, wordBackUp);
    }


    public WordAuto(WordBackUp backUp, int choiceTree){
        super("X", new RulesMap(), backUp);
        super.setOccu(0);
        if(choiceTree == 1){
            /*super.setAxium("aF");
            super.getRules().addRule("a->FFFFFv[+++h][---q]fb");
            super.getRules().addRule("b->FFFFFv[+++h][---q]fc");
            super.getRules().addRule("c->FFFFFv[+++fa]fd");
            super.getRules().addRule("d->FFFFFv[+++h][---q]fe");
            super.getRules().addRule("e->FFFFFv[+++h][---q]fg");
            super.getRules().addRule("g->FFFFFv[---fa]fa");
            super.getRules().addRule("h->ifFF");
            super.getRules().addRule("i->fFFF[--m]j");
            super.getRules().addRule("j->fFFF[--n]k");
            super.getRules().addRule("k->fFFF[--o]l");
            super.getRules().addRule("l->fFFF[--p]");
            super.getRules().addRule("m->fFn");
            super.getRules().addRule("n->fFo");
            super.getRules().addRule("o->fFp");
            super.getRules().addRule("p->fF");
            super.getRules().addRule("q->rfF");
            super.getRules().addRule("r->fFFF[++m]s");
            super.getRules().addRule("s->fFFF[++n]t");
            super.getRules().addRule("t->fFFF[++o]u");
            super.getRules().addRule("u->fFFF[++p]");
            super.getRules().addRule("v->Fv");*/

            super.setAxium("FAFAFA");
            ArrayList<String> ignored = new ArrayList<String>();
            ignored.add("F");
            ignored.add("+");
            ignored.add("-");
            super.setIgnored(ignored);
            super.getRules().addRule("B<B>B->B");
            super.getRules().addRule("B<B>A->A[-AFFFFFFFFFFFFFFAAAFFFFFFFFFFFFFFAA]");
            super.getRules().addRule("B<A>B->A");
            super.getRules().addRule("B<A>A->A");
            super.getRules().addRule("A<B>B->B");
            super.getRules().addRule("A<B>A->AFFFFFFFFFFFFFFA");
            super.getRules().addRule("A<A>B->A");
            super.getRules().addRule("A<A>A->B");
            super.getRules().addRule("+->-");
            super.getRules().addRule("-->+");

        }
        else if(choiceTree == 2){
            super.setAxium("X");
            super.getRules().addRule("F", "FF");
            super.getRules().addRule("X", "F[+X]F[-X]+X");
  
        }
        else if(choiceTree == 3){
            super.setAxium("X");
            super.getRules().addRule("F", "FF");
            super.getRules().addRule("X", "F[+X][-X]FX");

        }
        else if(choiceTree == 4){
            super.setAxium("F");
            super.getRules().addRule("F", "F[+F]F[-F]F", "F[+F]F", "F[-F]F");
            
        }
    }








}





